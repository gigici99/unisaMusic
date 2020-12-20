package controlservlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelbean.BranoBean;
import modeldao.BranoDao;


@WebServlet("/EliminaCarrello")
public class EliminaCarrello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EliminaCarrello() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArrayList<BranoBean> carrello;
		if(session.getAttribute("carrello") == null) {
			carrello = new ArrayList<BranoBean>();
		}else {
			carrello = (ArrayList<BranoBean>) session.getAttribute("carrello");
		}
		
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		BranoDao branoDao = new BranoDao();
		try {
			BranoBean brano = branoDao.doRetrieveById(id);
			System.out.println(brano.getTitle());
			boolean x=true;
			for(int i=0; i<carrello.size(); i++)
				if(carrello.get(i).getID()==id)
					carrello.remove(carrello.get(i));
			
			session.removeAttribute("carrello");
			session.setAttribute("carrello", carrello);
			
			RequestDispatcher rd = request.getRequestDispatcher("/carrello.jsp");
			rd.forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

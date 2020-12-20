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
import modelbean.UserBean;
import modeldao.BranoDao;
import modeldao.CanzoniAcquistateDao;


@WebServlet("/AggiungiCarrello")
public class AggiungiCarrello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AggiungiCarrello() {
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
		UserBean user = (UserBean) session.getAttribute("user");
		try {
			BranoBean brano = branoDao.doRetrieveById(id);
			ArrayList<BranoBean> brani=branoDao.doRetrieveAll("");
			CanzoniAcquistateDao canzoneDao= new CanzoniAcquistateDao();
			
			if(!canzoneDao.doRetrieveByAcquista(user.getId(), id)) {
			boolean x=true;
			for(BranoBean b:carrello)
				if(b.getID()==id)
					x=false;
			if(x)
				carrello.add(brano);
			}
			
			
			ArrayList<BranoBean> braniTot = branoDao.doRetrieveAll("");
			for(int i=0; i<carrello.size(); i++) {
				for(int j=0; j<braniTot.size(); j++) {
					if(carrello.get(i).equals(braniTot.get(j)))
						brani.remove(carrello.get(i));
			}
			}
			
			request.setAttribute("brani", brani);
			session.removeAttribute("carrello");
			session.setAttribute("carrello", carrello);
			
			RequestDispatcher rd = request.getRequestDispatcher("/brani.jsp");
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

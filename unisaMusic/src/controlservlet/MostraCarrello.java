package controlservlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelbean.BranoBean;


@WebServlet("/MostraCarrello")
public class MostraCarrello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public MostraCarrello() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArrayList<BranoBean> carrello;
		if(session.getAttribute("carrello") == null) {
			carrello = new ArrayList<BranoBean>();
			session.setAttribute("carrello", carrello);
		}
		
				
		RequestDispatcher rd = request.getRequestDispatcher("carrello.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

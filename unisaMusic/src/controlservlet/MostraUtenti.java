package controlservlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelbean.UserBean;
import modeldao.UserDao;


@WebServlet("/MostraUtenti")
public class MostraUtenti extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MostraUtenti() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<UserBean> utenti;
		UserDao userDao = new UserDao();
		try {
			utenti = (ArrayList<UserBean>) userDao.doRetrieveAll("");
			request.setAttribute("utenti", utenti);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
				
		RequestDispatcher rd = request.getRequestDispatcher("account.jsp");
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

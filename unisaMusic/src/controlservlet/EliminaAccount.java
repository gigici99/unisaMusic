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

import modelbean.UserBean;
import modeldao.UserDao;


@WebServlet("/EliminaAccount")
public class EliminaAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EliminaAccount() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<UserBean> utenti;
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		UserDao userDao = new UserDao();
		try {				
					userDao.doDelete(id);
					utenti = (ArrayList<UserBean>) userDao.doRetrieveAll("");
					
					request.setAttribute("utenti", utenti);
			
			RequestDispatcher rd = request.getRequestDispatcher("/account.jsp");
			rd.forward(request, response);

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		/*ArrayList<UserBean> utenti = new ArrayList<UserBean>();
		
		int id = Integer.parseInt(request.getParameter("id"));

		try {
			UserDao userDao = new UserDao();
			utenti = (ArrayList<UserBean>) userDao.doRetrieveAll("");
			for(UserBean u: utenti) {
				if(u.getId() == id) {
					utenti.remove(id);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/eliminaAccount.jsp");
		rd.forward(request, response);
		*/
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

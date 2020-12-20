package controlservlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelbean.UserBean;
import modeldao.UserDao;



@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	
		 		
		 		String email = request.getParameter("email");
		        String password=request.getParameter("password");  
		        
		        UserBean user;
				try {
					user = userDao.doRetrieveByEmailPassword(email, password);
					
					if(user != null) {
						//System.out.println(user.getTipo());
						HttpSession session=request.getSession();  
						session.setAttribute("user", user);
						RequestDispatcher rd = getServletContext().getRequestDispatcher(response.encodeURL("/home.jsp"));
						rd.forward(request, response);						
					}else {
						RequestDispatcher rd = getServletContext().getRequestDispatcher(response.encodeURL("/index.jsp"));
						rd.forward(request, response);
					}
				} catch (SQLException e) {
					RequestDispatcher rd = getServletContext().getRequestDispatcher(response.encodeURL("/index.jsp"));
					rd.forward(request, response);
					
					e.printStackTrace();
				}
		        
				
	}
	private static UserDao userDao = new UserDao();
}
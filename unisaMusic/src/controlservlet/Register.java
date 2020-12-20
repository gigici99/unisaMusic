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

@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Register() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserBean user = new UserBean();
		
			
				String username = request.getParameter("username");
				String email = request.getParameter("email");
				String password = request.getParameter("password");	
				String passwordConferma = request.getParameter("passwordConferma");
				
				
				try {
					 if (!(username != null && username.length() >= 6 && username.matches("^[0-9a-zA-Z]+$"))) {    //soltanto una parola(prima ed ultima)
				            throw new MyServletException("Username non valido.");
				        }

				      if (!(password != null && password.length() >= 8 && !password.toUpperCase().equals(password)
				                && !password.toLowerCase().equals(password) && password.matches(".*[0-9].*"))) {
				            throw new MyServletException("Password non valida.");
				        }

				      if (!password.equals(passwordConferma)) {
				            throw new MyServletException("Password e conferma differenti.");
				        }

				       

				       if (!(email != null && email.matches("^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w+)+$"))) {    //parola+quante altre parole vuoi+@+parola+ altre parole+parola
				            throw new MyServletException("Email non valida.");
				        }
				       
				       user.setUsername(username);
				       user.setEmail(email);
				       user.setPassword(password);
					
					model.doSave(user);
					//System.out.println(user.getTipo());
					request.setAttribute("message", "utente inserito");
					session.setAttribute("user", user);
					RequestDispatcher rd = getServletContext().getRequestDispatcher(response.encodeURL("/home.jsp"));
					rd.forward(request, response);
					
				} catch (SQLException e) {
					//e.printStackTrace();
					request.setAttribute("message", "utente non inserito!");
					RequestDispatcher rd = getServletContext().getRequestDispatcher(response.encodeURL("/esitoregistrazione.jsp"));
					rd.forward(request, response);
				}
		

		
		
	}
	private static UserDao model = new UserDao();
}

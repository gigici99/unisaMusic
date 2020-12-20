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


@WebServlet("/modifica-profilo")
public class UserMod extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UserMod() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserBean user = (UserBean) session.getAttribute("user");
		int id = user.getId();
		
		//int id = Integer.parseInt(request.getParameter("id"));
		
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String codiceFiscale = request.getParameter("codicefiscale");
		String password = request.getParameter("password");	
		String passwordConferma = request.getParameter("passwordConferma");

		try {
		user = model.doRetrieveById(id);
		
		 if (!(username != null && username.length() >= 6 && username.matches("^[0-9a-zA-Z]+$"))) {    //soltanto una parola(prima ed ultima)
	            throw new MyServletException("Username non valido.");
	        }
      

		 if (!(email != null && email.matches("^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w+)+$"))) {    //parola+quante altre parole vuoi+@+parola+ altre parole+parola
	            throw new MyServletException("Email non valida.");
	        }
		
		 if (!(nome != null && nome.trim().length() > 0 && nome.matches("^[ a-zA-Z\u00C0-\u00ff]+$"))) {  //caratteri speciali tabella ascii
	            throw new MyServletException("Nome non valido.");
	        }
		 
		 if (!(cognome != null && cognome.trim().length() > 0 && cognome.matches("^[ a-zA-Z\u00C0-\u00ff]+$"))) {  //caratteri speciali tabella ascii
	            throw new MyServletException("Cognome non valido.");
	        }
		
		 if (!(password != null && password.length() >= 8 && !password.toUpperCase().equals(password)
	    		   && !password.toLowerCase().equals(password) && password.matches(".*[0-9].*"))) {
	    	   throw new MyServletException("Password non valida.");
	       }
		 
		 if (!password.equals(passwordConferma)) {
	    	   throw new MyServletException("Password e conferma differenti.");
	       }
		 
		 if(codiceFiscale == null || (codiceFiscale.length() != 16) /*|| !codiceFiscale.matches("[a-zA-Z]{6}dd[a-zA-Z]dd[a-zA-Z]ddd[a-zA-Z]")*/){
			 throw new MyServletException("CodiceFiscale non valido");
		 }
		
		 	
		 user.setUsername(username);
		 user.setEmail(email);
		 user.setNome(nome);
		 user.setCognome(cognome);
		 user.setCf(codiceFiscale);
		 user.setPassword(password);
		 
			model.doUpdate(user);
			request.setAttribute("message", "credenziali aggiornate correttamente!");
		}
		catch(SQLException e) {
			request.setAttribute("message", "aggiornamento non riuscito!");
		}

		
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(response.encodeURL("/esitoregistrazione.jsp"));
		rd.forward(request, response);
		
	}
	private static UserDao model = new UserDao();
}

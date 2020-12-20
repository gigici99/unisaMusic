package controlservlet;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modeldao.UserDao;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/VerificaUsername")
public class VerificaUsernameServlet extends HttpServlet {
    private final UserDao userDao = new UserDao();
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        response.setContentType("text/xml");
        try {
			if (username != null && username.length() >= 6 && username.matches("^[0-9a-zA-Z]+$")
			        && userDao.doRetrieveByUsername(username) == null) {
			    response.getWriter().append("<ok/>");
			} else {
			    response.getWriter().append("<no/>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
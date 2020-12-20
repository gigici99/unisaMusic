package controlservlet;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modeldao.UserDao;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/VerificaEmail")
public class VerificaEmailServlet extends HttpServlet {
    private final UserDao userDao = new UserDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        response.setContentType("text/xml");
        try {
			if (email != null && email.matches("^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w+)+$") && userDao.doRetrieveByEmail(email) == null) {
			    response.getWriter().append("<ok/>");
			} else {
			    response.getWriter().append("<no/>");
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
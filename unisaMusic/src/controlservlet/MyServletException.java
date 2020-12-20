package controlservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelbean.UserBean;

import java.io.IOException;

public class MyServletException extends ServletException {
    private static final long serialVersionUID = -8976023136478643816L;

    public MyServletException() {
        super();
    }

    public MyServletException(String message, Throwable rootCause) {
        super(message, rootCause);
    }

    public MyServletException(String message) {
        super(message);
    }

    public MyServletException(Throwable rootCause) {
        super(rootCause);
    }

    public static void checkAdmin(HttpServletRequest request) throws MyServletException {
        UserBean utente = (UserBean) request.getSession().getAttribute("user");
        if (utente == null || !utente.getTipo()) {
            throw new MyServletException("Utente non autorizzato");
        }
    }

}
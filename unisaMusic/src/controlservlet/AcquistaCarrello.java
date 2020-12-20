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

import com.mysql.cj.Session;

import modelbean.BranoBean;
import modelbean.CanzoniAcquistateBean;
import modelbean.UserBean;
import modeldao.CanzoniAcquistateDao;


@WebServlet("/AcquistaCarrello")
public class AcquistaCarrello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public AcquistaCarrello() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArrayList<BranoBean> carrello = (ArrayList<BranoBean>) session.getAttribute("carrello");
		UserBean user = (UserBean) session.getAttribute("user");
		
		int id = user.getId();
		CanzoniAcquistateDao canzoneDao = new CanzoniAcquistateDao();
		
		try {
		for(BranoBean b: carrello) {
			CanzoniAcquistateBean canzone = new CanzoniAcquistateBean();
			canzone.setIdBrano(b.getID());
			canzone.setIdCliente(id);
			
				canzoneDao.doSave(canzone);
				}
		session.removeAttribute("carrello");
		} catch (SQLException e) {
			throw new MyServletException("Acquisto non eseguito!");
		}
		
		request.setAttribute("message", "Acquisto con successo");
		
		RequestDispatcher rd = request.getRequestDispatcher("/esitoregistrazione.jsp");
		rd.forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

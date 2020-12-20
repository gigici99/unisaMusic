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

import modelbean.BranoBean;
import modelbean.CanzoniAcquistateBean;
import modelbean.UserBean;
import modeldao.BranoDao;
import modeldao.CanzoniAcquistateDao;
import modeldao.UserDao;


@WebServlet("/CanzoniAcquistate")
public class CanzoniAcquistate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public CanzoniAcquistate() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		CanzoniAcquistateDao canzoniDao = new CanzoniAcquistateDao();
		UserBean user = (UserBean) session.getAttribute("user");
		BranoDao branoDao = new BranoDao();
		
		ArrayList<CanzoniAcquistateBean> canzoni = new ArrayList<CanzoniAcquistateBean>();
		
		int id = user.getId();
		try {
			
			canzoni = canzoniDao.doRetrieveByIdCliente(id);
			ArrayList<BranoBean> brani = new ArrayList<BranoBean>();
			for(CanzoniAcquistateBean c: canzoni) {
				BranoBean b = branoDao.doRetrieveById(c.getIdBrano()); 
				brani.add(b);
				request.setAttribute("brani", brani);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/acquisti.jsp");
		rd.forward(request, response);
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

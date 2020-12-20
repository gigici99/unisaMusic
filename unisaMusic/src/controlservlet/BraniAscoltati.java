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

import modelbean.BranoBean;
import modeldao.BranoDao;


@WebServlet("/BraniAscoltati")
public class BraniAscoltati extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public BraniAscoltati() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BranoDao branoDao = new BranoDao();
		ArrayList<BranoBean> brani = new ArrayList<BranoBean>();
		
		try {
			brani = branoDao.doRetrieveAll("ascolti");
			request.setAttribute("brani", brani);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/braniAscoltati.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

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

import modelbean.ArtistaBean;
import modeldao.ArtistaDao;


@WebServlet("/InitServletArtisti")
public class InitServletArtisti extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public InitServletArtisti() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArtistaDao artistaDao = new ArtistaDao();
		ArrayList<ArtistaBean> artisti = new ArrayList<ArtistaBean>();
		
		try {
			artisti = artistaDao.doRetrieveAll("");
			request.setAttribute("artisti", artisti);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/artisti.jsp");
			rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

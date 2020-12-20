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
import modeldao.ArtistaDao;
import modeldao.BranoDao;


@WebServlet("/InsertBrano")
public class InsertBrano extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public InsertBrano() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String titolo = request.getParameter("titolo");
		String durata = request.getParameter("durata");
		String nomeArte = request.getParameter("nome_arte");
		
		ArtistaDao artistaDao = new ArtistaDao();
		
		try {
			if(artistaDao.doRetrieveById(nomeArte) != null) {		
				BranoBean brano = new BranoBean();
				
				
			if(titolo!= null || !titolo.trim().equals(""))
				brano.setTitle(titolo);
				
			if(durata != null || !durata.trim().equals(""))
				brano.setTime(durata);
			
			if(nomeArte != null || !nomeArte.trim().equals(""))
				brano.setNomeArtista(nomeArte);
			
			System.out.println("ok");
			
				model.doSave(brano);
				request.setAttribute("brano", brano);
				request.setAttribute("message", "Brano inserito!");
				RequestDispatcher rd = getServletContext().getRequestDispatcher(response.encodeURL("/esitoregistrazione.jsp"));
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("message", "Brano non inserito!");
			RequestDispatcher rd = getServletContext().getRequestDispatcher(response.encodeURL("/esitoregistrazione.jsp"));
			rd.forward(request, response);
		}

		
		
		
		}
	public static BranoDao model = new BranoDao();
}

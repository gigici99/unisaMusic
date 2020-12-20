package controlservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelbean.ArtistaBean;
import modeldao.ArtistaDao;


@WebServlet("/InsertArtista")
public class InsertArtista extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public InsertArtista() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeArte = request.getParameter("nome");
		
		try {
			ArtistaBean artistaBean = new ArtistaBean();
			
			if(nomeArte != null || nomeArte.trim().equals(""))
				artistaBean.setNomeArte(nomeArte);
			
			model.doSave(artistaBean);
			request.setAttribute("message", "artista inserito");
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "artista non inserito");
		}
		
		RequestDispatcher rdi = getServletContext().getRequestDispatcher(response.encodeURL("/esitoregistrazione.jsp"));
		rdi.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	ArtistaDao model = new ArtistaDao();
}

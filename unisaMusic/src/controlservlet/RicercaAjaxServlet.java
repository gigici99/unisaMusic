
package controlservlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import modelbean.BranoBean;
import modeldao.BranoDao;



@WebServlet("/RicercaAjax")
public class RicercaAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final BranoDao branoDao = new BranoDao();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		JSONArray prodJson = new JSONArray();
		String query = request.getParameter("q");
		System.out.println(query);
		if (query != null) {
			List<BranoBean> brani;
			try {
				brani = branoDao.doRetrieveByNome(query + "*");
				for (BranoBean p : brani) {
					System.out.println(p.getTitle());
					prodJson.put(p.getTitle());
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		response.setContentType("application/json");
		response.getWriter().append(prodJson.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
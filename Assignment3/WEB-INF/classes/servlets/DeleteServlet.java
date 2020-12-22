package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ApplicationDao;

public class DeleteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public DeleteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ApplicationDao appDao = new ApplicationDao();
		String id = request.getParameter("id");

		appDao.deleteLog(id);

		response.sendRedirect(request.getContextPath() + "/logsServlet");
	}

} // end class DeleteServlet

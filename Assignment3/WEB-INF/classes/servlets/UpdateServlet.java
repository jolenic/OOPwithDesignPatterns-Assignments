package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ApplicationDao;

public class UpdateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public UpdateServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ApplicationDao appDao = new ApplicationDao();
		PrintWriter writer = response.getWriter();
		String id = request.getParameter("id");
		String title = request.getParameter("post_title");
		String content = request.getParameter("post_content");
		
		String htmlResponse = "<html><head><title>Edit Log</title></head><body>";
		writer.write(htmlResponse);

		writer.write("<h3>Edit Log ID=" + id + ":</h3><form method=\"get\"><table><tr>"
				+ "<td><label for=\"post_title\">New Post Title: </label>"
				+ "<input type=\"hidden\" id=\"id\" name=\"id\" value=\"" + id + "\">"
				+ "<input type=\"text\" id=\"post_title\" name=\"post_title\" required=\"required\" />"
				+ "	</td></tr><tr><td>"
				+ "	<label for=\"post_content\">New Post Content: </label>"
				+ " <input type=\"text\" id=\"post_content\" name=\"post_content\" required=\"required\" />"
				+ "	</td></tr><tr><td>"
				+ "	<a href=\"/updateServlet\">"
				+ "<input type=\"submit\" value=\"Submit\" />" + "</a></td></tr>"
				+ "</table></form>");

		if ((title != null) && (content != null) && (id != null)) {
			appDao.editLog(title, content, id);
			writer.write("Post is Updated");
		}

		writer.write("<p><a href=" + request.getContextPath() + "/logsServlet>Back</a>");
		writer.write("</body></html>");

	}

}

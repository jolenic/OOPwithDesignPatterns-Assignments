package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.DisplayLogs;
import beans.TextLog;
import dao.ApplicationDao;
import inmemory.ApplicationInMemory;

public class LogsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LogsServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = request.getParameter("post_title");
		String content = request.getParameter("post_content");
		ApplicationDao appDao = new ApplicationDao();

		String htmlResponse = "<html><head><title>Logs</title></head><body>";
		PrintWriter writer = response.getWriter();
		writer.write(htmlResponse);

		if ((title != null) && (content != null)) {
			TextLog test = new TextLog(title, content);
			ApplicationInMemory.allLogs.add(test);
			writer.write("TextLog succesfully created!  ");
			if (appDao.insertNewLog(test.getId().toString(), test.getTitle(), test.getContent(),
					test.getCreateTimestamp().toString()) != 0) {
				writer.write("Log added to database!");
			} else {
				writer.write("Not added to database :(");
			}
		}

		writer.write("<h3>Assignment 3</h3><form method=\"get\"><table><tr>"
				+ "	<td><label for=\"post_title\">Post Title: </label>"
				+ "	<input type=\"text\" id=\"post_title\" name=\"post_title\" required=\"required\" />"
				+ "	</td></tr><tr><td>"
				+ "<label for=\"post_content\">Post Content: </label>"
				+ "	<input type=\"text\" id=\"post_content\" name=\"post_content\" required=\"required\" />"
				+ "	</td></tr><tr><td>"
				+ "	<a href=\"/logsServlet\"></a><input type=\"submit\" value=\"Submit\" /></a></td>"
				+ "</tr></table></form><h4>Here are your logs:</h4>");

		writer.write(htmlResponse);
		ArrayList<DisplayLogs> dbLogs = new ArrayList<>();
		try {
			dbLogs = appDao.selectAllLogs();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (DisplayLogs l : dbLogs) {
			writer.write("<p> </p>" + l.displayHTML() + "<p><a href=" + request.getContextPath() + "/updateServlet?id="
					+ l.getId() + ">Edit</a>" + " <a href=" + request.getContextPath() + "/deleteServlet?id="
					+ l.getId() + ">Delete</a></p>");
		}
		writer.write("</body></html>");
	}
}

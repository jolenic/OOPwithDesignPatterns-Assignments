package com.algonquin.loggy.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algonquin.loggy.beans.Log;
import com.algonquin.loggy.beans.TextLog;
import com.algonquin.loggy.dao.ApplicationDao;
import com.algonquin.loggy.inmemory.ApplicationInMemory;
import com.algonquin.loggy.services.ApplicationService;

/**
 * Servlet implementation class LogsServlet
 */
//@WebServlet(description = "Loggy Logs", urlPatterns = { "/LogsServlet" })
public class LogsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    ApplicationService logs;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogsServlet() {
        super();
//        this.logs = new ApplicationInMemory();
        this.logs = new ApplicationDao();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("delete".equals(action)) {
            delete(request);
        }

        String title = "";
        String content = "";
        String id = request.getParameter("id");
        if (id == null || "".equals(id)) {
            // Initialize id and continue with the rendering.
            id = "";
        } else {
            // Read the record from memory.
            Log log = this.logs.readLog(id);
            if (log == null) {
                // Log not found, initialize id and continue with the rendering.
                id = "";
            } else {
                // Log found, initialize title and content.
                title = log.getTitle();
                content = log.getContent();
            }
        }

        // Read all logs, assign to local variable and sent to printOutBodyList
        Map<UUID, Log> logs = this.logs.readLogs();
        
        //pass logs back to logging.jsp
        request.setAttribute("logs", logs);
        request.setAttribute("id", id);
        request.setAttribute("title", title);
        request.setAttribute("content", content);
        request.getRequestDispatcher("logging.jsp").forward(request, response);
        

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Log log = null;
        String id = request.getParameter("id");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        if (id == null || "".equals(id)) {
            // Create the log.
            log = new TextLog(title, content);
        } else {
            // Read the log.
            log = this.logs.readLog(id);
            log.setTitle(title);
            log.setContent(content);
        }
        // Update the log.
        this.logs.createOrUpdateLog(log);

        // Process GET for rendering the page with updates.
        doGet(request, response);
    }

    private void delete(HttpServletRequest request) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id != null && !id.equals("null")) {
            // Remove the log.
            this.logs.deleteLog(id);
        }
    }


}

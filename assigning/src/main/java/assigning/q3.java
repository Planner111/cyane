package assigning;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/q3")
public class q3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public q3() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

        String errorType = request.getParameter("errorType");
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if ("404".equals(errorType)) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            out.println("<h1>404 Not Found</h1>");
            out.println("<p>The requested resource was not found on this server.</p>");
        } else if ("500".equals(errorType)) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.println("<h1>500 Internal Server Error</h1>");
            out.println("<p>There was an error processing your request. Please try again later.</p>");
        } else {
            response.setStatus(HttpServletResponse.SC_OK);
            out.println("<h1>Welcome</h1>");
            out.println("<p>No error. Use the following links to generate errors:</p>");
            out.println("<ul>");
            out.println("<li><a href='q3?errorType=404'>Generate 404 Error</a></li>");
            out.println("<li><a href='q3?errorType=500'>Generate 500 Error</a></li>");
            out.println("</ul>");
        }
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

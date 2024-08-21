package eric;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class request
 */
@WebServlet("/request")
public class request extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public request() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");

        // Retrieve parameters sent in the POST request
        
        String username = request.getParameter("username");
        String password = request.getParameter("userpass");
        
        String validUsername = "Murwanashyaka";
        String validPassword = "password";
        
        RequestDispatcher dispatcher;

        if (username.equals(validUsername) && password.equals(validPassword)) {
            // Login success - forward to success page
            dispatcher = request.getRequestDispatcher("success.html");
            dispatcher.forward(request, response);
        } else {
            // Login failure - forward to failure page
            dispatcher = request.getRequestDispatcher("failure.html");
            dispatcher.forward(request, response);
        }
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}

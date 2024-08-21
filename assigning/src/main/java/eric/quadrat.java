package eric;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class quadratic
 */
@WebServlet("/quadrat")
public class quadrat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public quadrat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
        double a = Double.parseDouble(request.getParameter("a"));
        double b = Double.parseDouble(request.getParameter("b"));
        double c = Double.parseDouble(request.getParameter("c"));

        double discriminant = b * b - 4 * a * c;
        String result;

        if (a == 0) {
            result = "Coefficient 'a' cannot be zero.";
        } else if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            result = "Roots are: " + root1 + " and " + root2;
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            result = "Root is: " + root;
        } else {
            result = "The equation has no real roots.";
        }
        response.setContentType("text/html");
        //yes
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h2>Results</h2>");
        response.getWriter().println("<p>" + result + "</p>");
        response.getWriter().println("<a href='quadrat.html'>Go Back</a>");
        response.getWriter().println("</body></html>");
    }

	}

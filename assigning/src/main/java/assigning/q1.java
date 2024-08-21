package assigning;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/q1")
public class q1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public q1() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub`
		doGet(request, response);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String uname=request.getParameter("username");
		String pass=request.getParameter("password");
		if(uname.equals("cyane")&& pass.equals("ishimwe")) {
		RequestDispatcher rd=request.getRequestDispatcher("welcome");
		rd.forward(request, response);
		}else{
		out.print("Sorry, incorrect username or password, try again");
		out.print("<a href='home.html'>try again</a>");
		}}
	}



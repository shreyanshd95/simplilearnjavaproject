

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/jsp");
			response.sendRedirect("login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	response.setContentType("text/jsp");
	PrintWriter out = response.getWriter();
	

	String userEmail = request.getParameter("userName");
	String userPassword = request.getParameter("Password");
    if(userEmail!=null && !userEmail.equals("")&& !userPassword.equals("")) {
		if(userEmail.equals("admin@gmail.com") && userPassword.equals("admin@123")) {
		    //login success then create a cookie
			//create Cookie
			Cookie ck = new Cookie("userEmail", userEmail);
			// add cookie in response 
			response.addCookie(ck);
		     
		//	response.sendRedirect("home.jsp");
			request.getRequestDispatcher("home.jsp").include(request, response);
			 out.println("<h1 style='color:green'>Login successful!!! </h1>");

	}else {
		request.getRequestDispatcher("login.jsp").include(request, response);
	     out.println("<h3 style='color:red'>Login Failed * Invalid Credentials </h1>");

	}
    }else {
		request.getRequestDispatcher("login.jsp").include(request, response);

	     out.println("<h3 style='color:red'>Login Failed * Required fields are missing! </h1>");

    }
}}

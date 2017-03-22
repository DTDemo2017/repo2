

import java.io.*;
import java.io.IOException;
import javax.servlet.GenericServlet;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;




@WebServlet("/MyServlet")
public class MyServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;

    
	public void service(ServletRequest request, ServletResponse response) throws IOException
	{
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		
		out.println("<html><body>");
		out.println("This is the First Servlet");
		out.println("</body></html>");
	}

}

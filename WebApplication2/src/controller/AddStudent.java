package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String s1= request.getParameter("id");
		int id= Integer.parseInt(s1);
		String name= request.getParameter("name");
		String s2= request.getParameter("marks");
		int marks= Integer.parseInt(s2);
		
		Student s= new Student();
		s.setId(id);
		s.setName(name);
		s.setMarks(marks);
		
		//attach the student s with the request object
		request.setAttribute("myStudent", s);
		
		//create object of request dispatcher to dispatch show_student.jsp
		RequestDispatcher rd= request.getRequestDispatcher("show_student.jsp");
		
		//dispatch
		rd.forward(request, response);
		
	}

}

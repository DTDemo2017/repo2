package controller;

import dao.StudentDao;
import dao.StudentDaoImpl;
import model.Student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class ShowStudents
 */
@WebServlet("/ShowStudents")
public class ShowStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowStudents() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StudentDao studentDao= new StudentDaoImpl();
		ArrayList<Student> list= studentDao.getAllStudent();
		
		request.setAttribute("studentList", list);
		
		//dispatching
		RequestDispatcher r= request.getRequestDispatcher("students.jsp");
		r.forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}

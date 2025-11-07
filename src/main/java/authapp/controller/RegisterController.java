package authapp.controller;

import java.io.IOException;

import authapp.dao.UserDao;
import authapp.dto.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User(request.getParameter("firstName"), request.getParameter("lastName"), request.getParameter("email"), request.getParameter("contactNumber"), request.getParameter("password"));
		UserDao uDao = new UserDao();
		if (uDao.setUser(user)) {
			request.setAttribute("status", "success");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		} else {
			request.setAttribute("status", "failed");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
	}

}

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
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String checkEmail = request.getParameter("email");
		String checkPassword = request.getParameter("password");
		UserDao uDao = new UserDao();
		User user = uDao.getUser(checkEmail);
		if (user != null && checkPassword.equals(user.getPassword())) {
			if (user.getRole().equals("admin")) {
				request.getSession().setAttribute("user", user);
				response.sendRedirect("admindashboard");
			} else {
				request.getSession().setAttribute("user", user);
				response.sendRedirect("dashboard");
			}
		} else {
			request.setAttribute("authenticated", "false");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}

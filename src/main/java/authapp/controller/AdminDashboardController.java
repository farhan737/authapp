package authapp.controller;

import java.io.IOException;
import java.util.ArrayList;

import authapp.dao.UserDao;
import authapp.dto.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class DashboardController
 */
@WebServlet("/admindashboard")
public class AdminDashboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		if (session != null && session.getAttribute("user") != null) {
			UserDao uDao = new UserDao();
			ArrayList<User> users = uDao.getAllUsers();
			session.setAttribute("users", users);
			request.getRequestDispatcher("admindashboard.jsp").forward(request, response);
		} else {
			response.sendRedirect("login.jsp");
		}
	}

}

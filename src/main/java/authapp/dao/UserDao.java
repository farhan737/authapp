package authapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import authapp.dto.User;
import authapp.util.DatabaseUtil;

public class UserDao {
	static Connection conn = DatabaseUtil.getConnection();

	public boolean setUser(User user) {
		try {
			String registerQuery = "insert into users(firstName, lastName, email, contactNumber, password) values(?, ?, ?, ?, ?);";
			PreparedStatement registerStmt = conn.prepareStatement(registerQuery);
			registerStmt.setString(1, user.getFirstName());
			registerStmt.setString(2, user.getLastName());
			registerStmt.setString(3, user.getEmail());
			registerStmt.setString(4, String.valueOf(user.getContactNumber()));
			registerStmt.setString(5, user.getPassword());
			int addedUser = registerStmt.executeUpdate();
			if (addedUser > 0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public User getUser(String email) {
		User user = null;
		String query = "select firstName, lastName, email, contactNumber, password from users where email = ?;";
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			user = new User(rs.getString(1),rs.getString(2), rs.getString(3), Long.parseLong(rs.getString(4)), rs.getString(5));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
}

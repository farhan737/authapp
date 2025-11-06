package authapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
	final private static String URL = "jdbc:mysql://localhost:3306/Users";
	final private static String USERNAME = "root";
	final private static String PASSWORD = "3419";
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		try {
			Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}

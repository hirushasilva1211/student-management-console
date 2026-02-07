package com.example.student.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {

	private static final String URL = "jdbc:mysql://localhost:3306/student_db";
	private static final String NAME = "root";
	private static final String PASSWORD = "root";
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, NAME, PASSWORD);
	}


	
}

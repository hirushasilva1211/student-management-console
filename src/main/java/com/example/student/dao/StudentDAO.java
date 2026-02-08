package com.example.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.student.model.Student;
import com.example.student.util.JDBCUtil;

public class StudentDAO {
	
	// Add a student
	public static void addStudent(Student student){
		
		String sql = "INSERT INTO students(name, email, age) VALUES (?, ?, ?)";
		
		// Use try-with-resources, automatically closes connection & statement
		try(Connection con = JDBCUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(sql)) {
					
			ps.setString(1, student.getName());
			ps.setString(2, student.getEmail());
			ps.setInt(3, student.getAge());
			
			
			ps.executeUpdate(); // executeUpdate() for INSERT,UPDATE,DELETE
			System.out.println("Student Added Successfully");
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	// Get student by ID
	public static Student getStudentById(long id) {
		
		String sql = "SELECT * FROM students WHERE id=?";
		Student student = null;
		
		try(Connection con = JDBCUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setLong(1, id);
			try(ResultSet rs = ps.executeQuery();){
				if(rs.next()) {
					student = new Student(
							rs.getInt("id"),
							rs.getString("name"),
							rs.getString("email"),
							rs.getInt("age"));
				}
			}	
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}
	
	// Get all students
	public static List<Student> getAllStudents(){
		
		String sql = "SELECT * FROM students";
		List<Student> studentList = new ArrayList<>();
		
		try(Connection con = JDBCUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery()){
			
			while(rs.next()) {
				studentList.add(new Student(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("email"),
						rs.getInt("age"))
				);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return studentList;
	}
	
	// Update student name
	public static void updateName(int id, String name) {
	    String sql = "UPDATE students SET name = ? WHERE id = ?";

	    try (Connection con = JDBCUtil.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setString(1, name);
	        ps.setInt(2, id);
	        ps.executeUpdate();
	    }catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Update student email address
	public static void updateEmail(int id, String email) {
	    String sql = "UPDATE students SET email = ? WHERE id = ?";

	    try (Connection con = JDBCUtil.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setString(1, email);
	        ps.setInt(2, id);
	        ps.executeUpdate();
	    }catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Update student age
	public static void updateAge(int id, int age) {
	    String sql = "UPDATE students SET age = ? WHERE id = ?";

	    try (Connection con = JDBCUtil.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setInt(1, age);
	        ps.setInt(2, id);
	        ps.executeUpdate();
	    }catch (SQLException e) {
			e.printStackTrace();
		}
	}
		

	// Delete student by id
	public static void deleteStudent(long id) {
	    String sql = "DELETE FROM students WHERE id = ?";

	    try (Connection con = JDBCUtil.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setLong(1, id);
	        ps.executeUpdate();
	        System.out.println("Student record deleted successfully");
	    }catch (SQLException e) {
			e.printStackTrace();
		}
	}

}


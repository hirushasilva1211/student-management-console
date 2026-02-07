import java.util.List;
import java.util.Scanner;

import com.example.student.dao.StudentDAO;
import com.example.student.model.Student;

public class ConsoleDisplay {
	
	private Scanner sc;
	
	public ConsoleDisplay() {
		super();
	}
	
	public ConsoleDisplay(Scanner sc) {
		super();
		this.sc = sc;
	}
	
	// Get data from user to add a student
	public Scanner getScanner() {
		return sc;
	}

	public void setScanner(Scanner sc) {
		this.sc = sc;
	}

	public void addStudent() {
		
		Student student = new Student();
		System.out.println("Enter Student Details,");
		
		// Get input Name
		while(true) {
			System.out.print("Name : ");
			String name = sc.nextLine().trim();
			
			if(name.isEmpty()) {
				System.out.println("Input cannot be empty.");
				continue;
			}else if(!name.matches("[a-zA-Z ]+")) {
				System.out.println("Only letters are allowed.");
				continue;
			}else {
				student.setName(name);
				break;
			}	
		}
		// Get input email
		while(true) {
			System.out.print("Email : ");
			String email = sc.nextLine().trim();
			
			if(email.isEmpty()) {
				System.out.println("Input cannot be empty.");
				continue;
			}else{
				student.setEmail(email);
				break;
			}	
		}
		// Get age
		while(true) {
			System.out.print("Age : ");
			
			String input = sc.nextLine(); // always read a line

		    int age;
		    try {
		        age = Integer.parseInt(input); // convert to int
		    } catch (NumberFormatException e) {
		        System.out.println("Please enter a alid age.");
		        continue;
		    }
			
			if(age < 1 || age > 100) {
				System.out.println("Please enter a valid age.");
				continue;
			}else {
				student.setAge(age);
				break;
			}
		}
		
		StudentDAO.addStudent(student);
	}
	
	// Display selected student details on console
	public void getStudentById() {
		
		long id;
		
		while(true) {
			System.out.print("Enter Student ID = ");
			
			String input = sc.nextLine(); // always read a line

		    try {
		        id = Integer.parseInt(input); // convert to int
		        break;
		    } catch (NumberFormatException e) {
		        System.out.println("Please Enter a Number.");
		        continue;
		    }
		}
		
		Student student = StudentDAO.getStudentById(id);
		
		if(student == null) {
			System.out.println("Student not found.");
			return;
		}
		
		System.out.println("Name : " + student.getName());
		System.out.println("Email : " + student.getEmail());
		System.out.println("Age : " +student.getAge() + "\n");		
		
	}
	
	// Display students
	public void getAllStudents() {
		List<Student> studentList = StudentDAO.getAllStudents();
		
		for(Student student : studentList) {
			if(student == null) {
				System.out.println("Student not found.");
				continue;
			}		
			System.out.println("Name : " + student.getName());
			System.out.println("Email : " + student.getEmail());
			System.out.println("Age : " +student.getAge() + "\n");
		}
	}
	
	//Update student
	public void updateEmail() {
		System.out.println("Update operation is under construction...");
	}
	
	// Display delete operation by id
	public void deleteStudent() {
		
		long id;
		while(true) {
			System.out.print("Enter Student ID = ");
			
			String input = sc.nextLine(); // always read a line

		    try {
		        id = Integer.parseInt(input); // convert to int
		        break;
		    } catch (NumberFormatException e) {
		        System.out.println("Please Enter a Number.");
		        continue;
		    }
		}
		
		StudentDAO.deleteStudent(id);
	}
}

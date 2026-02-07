import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("== Student Management System ==");
		Scanner sc = new Scanner(System.in);
		ConsoleDisplay consoleDisplay = new ConsoleDisplay(sc);
		boolean exit = false;
		
		while(!exit) {
			// One second delay
			try {
				Thread.sleep(1000);
			}catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				break;
			}
			
			System.out.println("\n1. Add\n2. View by Id\n3. View all\n4. Update\n5. Delete\n6. Exit\n");
			System.out.print("Enter Your Operation = ");
			
			// One second delay
			try {
				Thread.sleep(2000);
			}catch(InterruptedException e) {
				Thread.currentThread().interrupt();
				break;
			}
			String input = sc.nextLine(); // always read a line

		    int choice;
		    try {
		        choice = Integer.parseInt(input); // convert to int
		    } catch (NumberFormatException e) {
		        System.out.println("Please Enter a Number.");
		        continue;
		    }
				
			switch(choice) {
				case 1:
					consoleDisplay.addStudent();
					break;
				case 2:
					consoleDisplay.getStudentById();
					break;
				case 3:
					consoleDisplay.getAllStudents();
					break;
				case 4:
					consoleDisplay.updateEmail();
					break;
				case 5:
					consoleDisplay.deleteStudent();
					break;
				case 6:
					exit = true;
					break;
				default:
					System.out.println("Something Went Wrong.\nTry Again");	
			}
		}
		sc.close();
		System.out.println("Thank You");
	}
}

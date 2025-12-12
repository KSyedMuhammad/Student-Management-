package main;

import java.util.Scanner;
import model.Student;
import service.StudentService;
import service.LoginService;

//Main class that runs the student management menu
public class App {
     
	public static void main(String args[]) {
		
		// Scanner object to read user input from the console
		Scanner sc = new Scanner(System.in);
		
		// Creating LoginService object to validate user name and password
		LoginService login = new LoginService();
		
		// Creating StudentService object to manage student operations
		StudentService service = new StudentService(); 
		
		
		// Displaying school header/banner information
		System.out.println("=============================================================================");
		System.out.println("                    Zilla Parishad High School                               ");
		System.out.println("                    (Affiliated to CBSE Board)                               ");
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println(" Address : Rajiv Colony, Shadi Mahal Oposit,Gorantla - 515231, Andrah Pradesh");
		System.out.println(" Contact : +91 9878586848");
		System.out.println(" Email   : info@xyzschool.com");
		System.out.println(" Motto   : \"Empowering Students for the Future\"");
		System.out.println("===========================================================================\n");
        
		
		// Login section title
		System.out.println("                        LOGIN PORTAL                                          ");
		System.out.println("===========================================================================\n");
		
		// Asking user to enter user name
		System.out.println("Enter Username: ");
		String user = sc.nextLine();
		
		// Asking user to enter password
		System.out.println("Enter Password: ");
		String pass = sc.nextLine();
		
		// Validate the entered user name and password
        // If login() returns false → credentials are invalid
		if (!login.login(user,pass)) {
			System.out.println("Invalid Credentials! Access Denied.");
			System.exit(0); // Exit the program if login fails
		}
		
		// Exit the program if login fails
		System.out.println("Login Successful!\n");
		
		while(true) {
			
			
			// Display menu options
			System.out.println("\n ==== Student Management System ====");
			System.out.println("1. Add Student");
			System.out.println("2. View All Students");
			System.out.println("3. Search Student By Id");
			System.out.println("4. Update Student");
			System.out.println("5. Delete Student");
			System.out.println("6. Exit");
			System.out.print("Enter choice: ");
			
			int choice = sc.nextInt();
			sc.nextLine(); // To avoid nextLine bug
			
			switch(choice) {
			
			case 1: 
				
				// Adding a new student
				System.out.print("Enter Student ID: ");
				int id = sc.nextInt();
				sc.nextLine();
				
				System.out.print("Enter Student Name: ");
				String name = sc.nextLine();
				
				System.out.print("Enter Student Age: ");
				int age = sc.nextInt();
				sc.nextLine();
				
				System.out.print("Enter Student Gender: ");
				String gender = sc.nextLine();
				
				System.out.print("Enter Student Course: ");
				String course = sc.nextLine();
				
				service.addStudent(new Student(id, name, age,gender,course));
				break;
				
			case 2: 
				// View all students
				service.viewAllStudents();
				break;
			
			case 3: 
				// Search student by ID
				System.out.print("Enter Stuydent ID: ");
				int sid = sc.nextInt();
				Student s = service.getStudentById(sid);
				if (s != null) System.out.println(s);
				else System.out.println("Student Not Found!");
				break;
				
			case 4:
				// Update student details
				System.out.print("Enter Student Id to Update: ");
				int uid = sc.nextInt();
				sc.nextLine();
				
				System.out.print("Enter New Student Name: ");
                String newName = sc.nextLine();

                System.out.print("Enter New Student Age: ");
                int newAge = sc.nextInt();
                sc.nextLine();
                
                System.out.print("Enter Student Gender: ");
                String newGender = sc.nextLine();

                System.out.print("Enter New Student Course: ");
                String newCourse = sc.nextLine();
                
                service.updateStudent(uid, newName, newAge,newGender, newCourse);
                break;
                
			case 5:
				// Delete a student
				System.out.print("Enter Student Id to Delete: ");
				int did = sc.nextInt();
				service.deleteStudent(did);
				break;
			case 6: 
				// Exit program
				System.out.println("Exiting....Thank You");
				System.exit(0);
				
			default :
                System.out.println("Invalid choice!");
				
			}
		}
	}
}

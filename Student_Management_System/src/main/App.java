package main;

import java.util.Scanner;
import model.Student;
import service.StudentService;

public class App {
     
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		StudentService service = new StudentService(); 
		
		while(true) {
			System.out.println("\n ==== Student Management System ====");
			System.out.println("1. Add Student");
			System.out.println("2. View All Students");
			System.out.println("3. Search Student By Id");
			System.out.println("4. Update Student");
			System.out.println("5. Delete Student");
			System.out.println("6. Exit");
			System.out.print("Enter choice: ");
			
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			
			case 1: 
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
				service.viewAllStudents();
				break;
			
			case 3: 
				System.out.print("Enter Stuydent ID: ");
				int sid = sc.nextInt();
				Student s = service.getStudentById(sid);
				if (s != null) System.out.println(s);
				else System.out.println("Student Not Found!");
				break;
				
			case 4:
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
				System.out.print("Enter Student Id to Delete: ");
				int did = sc.nextInt();
				service.deleteStudent(did);
				break;
			case 6: 
				System.out.println("Exiting....Thank You");
				System.exit(0);
				
			default :
                System.out.println("Invalid choice!");
				
			}
		}
	}
}

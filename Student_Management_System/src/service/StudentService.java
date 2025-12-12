package service;
import java.util.ArrayList;
import java.util.List;
import model.Student;


//This class handles all business logic for student operations
public class StudentService {
    
	// List to store student objects (acts as a database)
	private List<Student> students = new ArrayList<>();
	
	// Add new student to the list
	public void addStudent(Student s) {
		
		students.add(s);
		System.out.println("Student Added Successfully!");
	}
	
    // Display all students in table format
	public void viewAllStudents() {
		if(students.isEmpty()) {
			System.out.println("No students found.");
			return; 
		}
		for (Student s : students) {
			System.out.println(s);
		}
	}
	
    // Search and return a student using ID
	public Student getStudentById(int id) {
		for (Student s : students) {
			if (s.getID() == id ) return s; //Student found
		}
		return null; //Not found
	}
	
	
	// Update student details using ID
	public void updateStudent(int id, String name, int age,String gender, String course) {
		Student s = getStudentById(id);
		if (s != null) {
			// Update fields
			s.setName(name);
			s.setAge(age);
			s.setGender(gender);
			s.setCourse(course);
			System.out.println("Student Update Successfully");
		} else {
			System.out.println("Student Not Found!");
		}
	}
	
	
	
	// Delete student from the list by ID
	public void deleteStudent(int id) {
		Student s = getStudentById(id);
		if(s!= null) {
			students.remove(s);
			System.out.println("Student Deleted");
		}else {
			System.out.println("Student Not Found!");
		}
	}
}

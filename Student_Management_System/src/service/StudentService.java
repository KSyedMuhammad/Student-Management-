package service;
import java.util.ArrayList;
import java.util.List;
import model.Student;

public class StudentService {

	private List<Student> students = new ArrayList<>();
	
	public void addStudent(Student s) {
		
		students.add(s);
		System.out.println("Student Added Successfully!");
	}
	
	public void viewAllStudents() {
		if(students.isEmpty()) {
			System.out.println("No students found.");
			return;
		}
		System.out.println("--------------------------------------------------------------");
	    System.out.printf("| %-4s | %-15s | %-3s | %-20s |\n", "ID", "Name", "Age", "Course");
	    System.out.println("--------------------------------------------------------------");
	    for (Student s : students) {
	        System.out.printf("| %-4d | %-15s | %-3d | %-20s |\n",
	                s.getID(),
	                s.getName(),
	                s.getAge(),
	                s.getCourse()
	        );
	    }System.out.println("--------------------------------------------------------------");
	}
	
	
	public Student getStudentById(int id) {
		for (Student s : students) {
			if (s.getID() == id ) return s;
		}
		return null;
	}
	
	
	public void updateStudent(int id, String name, int age, String course) {
		Student s = getStudentById(id);
		if (s!= null) {
			s.getName();
			s.getAge();
			s.getCourse();
			System.out.println("Student Update Successfully");
		} else {
			System.out.println("Student Not Found!");
		}
	}
	
	
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

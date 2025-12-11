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
		for (Student s : students) {
			System.out.println(s);
		}
	}
	
	
	public Student getStudentById(int id) {
		for (Student s : students) {
			if (s.getID() == id ) return s;
		}
		return null;
	}
	
	
	public void updateStudent(int id, String name, int age, String course) {
		Student s = getStudentById(id);
		if (s != null) {
			s.setName(name);
			s.setAge(age);
			s.setCourse(course);
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

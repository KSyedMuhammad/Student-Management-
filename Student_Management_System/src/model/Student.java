package model;


//Student Model Class - Represents a single student record

public class Student {
    // Fields to store student information
	// Hear we hiding data.
	private int id;
	private String name;
	private int age;
	private String gender;
	private String course;
	
    // Constructor to initialize student details
	public Student(int id, String name, int age, String gender, String course) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.course = course;
	}
	
	
	
    // Getters to access private fields
	public int getID() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getGender() {
		return gender;
	}
	public String getCourse() {
		return course;
	}
	
	
	
    // Setters to update student details
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	
	// toString() method is overridden to return student information
	// in a single formatted line. This is useful for debugging,
	// logging, and quick display of student details.
    @Override
	public String toString() {
        return "ID: " +id + "| Name: "+name +" |Age:" + age + "|Gender: " +gender+ "|Course: " +course;
    }
}

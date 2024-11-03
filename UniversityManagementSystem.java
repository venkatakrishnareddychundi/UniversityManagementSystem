package com.crudoperations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student{
	private int id;
	private String name;
	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
}

class Course{

	private int id;
	private String name;
	public Course(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}
	
	
}

class Enrollment{
	private Student student;
	private Course course;
	public Enrollment(Student student, Course course) {
		this.student = student;
		this.course = course;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	@Override
	public String toString() {
		return "Enrollment [student=" + student + ", course=" + course + "]";
	}
	
	
}


public class UniversityManagementSystem {
	static List<Student>students=new ArrayList<>();
	static List<Course>courses=new ArrayList<>();
	static List<Enrollment>enrollments=new ArrayList<>();
	static Scanner scanner=new Scanner(System.in);
	public static void addStudent() {
		System.out.print("Enter Student id: ");
		int id=scanner.nextInt();
		System.out.print("Enter Student name: ");
		String name=scanner.next();
		students.add(new Student(id,name));
		System.out.println("Student added successfully");
	}
	public static void addCourse() {
		System.out.print("Enter Course id: ");
		int id=scanner.nextInt();
		System.out.print("Enter Course name: ");
		String name=scanner.next();
		courses.add(new Course(id,name));
		System.out.println("Course added successfully");
	}
	public static Student findStudentById(int id) {
		for(Student student:students) {
			if(student.getId()==id) {
				return student;
			}
		}
		return null;
	}
	public static Course findCourseById(int id) {
		for(Course course:courses) {
			if(course.getId()==id) {
				return course;
			}
		}
		return null;
	}
	public static void enrollStudent() {
		System.out.print("Enter student id: ");
		int studentId=scanner.nextInt();
		System.out.print("Enter course id: ");
		int courseId=scanner.nextInt();
		
		Student student=findStudentById(studentId);
		Course course=findCourseById(courseId);
		
		if(student!=null&&course!=null) {
			enrollments.add(new Enrollment(student,course));
			System.out.println("Successfully Enrolled");
		}
		else {
			System.out.println("Invalid Student or Course id");
		}
	}
	public static void viewEnrollments() {
		if(enrollments.isEmpty()) {
			System.out.println("Enrollments not their");
		}
		else {
			for(Enrollment enrollment:enrollments) {
				System.out.println("Enrollments: ");
				System.out.println(enrollments);

			}
		}
	}
	
	

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		boolean exit=false;
		while(!exit) {
	        System.out.println("University Management System");
	        System.out.println("1. Add Student");
	        System.out.println("2. Add Course");
	        System.out.println("3. Enroll Student in Course");
	        System.out.println("4. View Enrollments");
	        System.out.println("5. Exit");
	        System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    addCourse();
                    break;
                case 3:
                    enrollStudent();
                    break;
                case 4:
                    viewEnrollments();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

		}

	}

}

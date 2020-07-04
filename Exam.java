package college_managment_system;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Exam {

	String courseId;
	String studentId;
	String grade;
	
	public Exam(String id, String course, String grade2) throws IOException {
		courseId=course;
		studentId=id;
		grade=grade2;
	    BufferedWriter grades = new BufferedWriter(new FileWriter("Grades.txt",true)); 
	    grades.append(id+","+course+","+"1"+","+grade+"\n");
	    grades.close();
	    System.out.println("Added successfully");
	}
	
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
}
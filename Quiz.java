package college_managment_system;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Quiz {
	private String courseId;
	private String studentId;
	private String grade;

	public Quiz(String id, String course, String grade2) throws IOException {
		courseId=course;
		studentId=id;
		grade=grade2;
	    BufferedWriter grades = new BufferedWriter(new FileWriter("Grades.txt",true)); 
	    grades.append(id+","+course+","+"2"+","+grade+"\n");
	    grades.close();
	    System.out.println("Added successfully");
	}


	public String getCourseId() {
		return courseId;
	}
	
	public void setcourseId(String courseid) {
        this.courseId=courseid;
	}
	public String getstudentId() {
		return studentId;
	}
	
	public void setstudentId(String studentid) {
        this.studentId=studentid;
	}


	public String getgrade() {
		return grade;
	}
	
	public void setgrade(String grade) {
        this.grade=grade;
	}
	
}

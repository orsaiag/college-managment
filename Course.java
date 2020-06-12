import java.util.List;
import java.util.ArrayList;


public class Course {

	private int courseID;
	private String courseName;
	private List<Lecturer> lctlist;
	private List<Tutor> tutList;
	private List<Student> stdlist;
	
	
	public Course(int courseID,String courseName,List<Lecturer> lList,List<Tutor> tList,List<Studnt> sList) {
		this.courseID=courseID;
		this.courseName=courseName;
		this.lctlist=lList;
		this.tutList=tList;
		this.stdlist=sList;
	}
	
	//sets
	public void setCourseID(int courseID) {
		this.courseID=courseID;
	}
	public void setCourseName(String courseName) {
		this.courseName=courseName;
	}
	public void setLecturerList(List<Lecturer> lList) {
		this.lctlist=lList;
	}
	public void setStudentList(List<Student> sList) {
		this.stdlist=sList;
	}
	public void setTutorList(List<Tutor> tList) {
		this.tutList=tList;
	}
	
	
	//gets
	public int getCourseID() {
		return this.courseID;
	}
	public String getCourseName() {
		return this.courseName;
	}
	public List<Lecturer> getLecturerList(){
		return this.lctlist;
	}
	public List<Student> getStudentList(){
		return this.stdlist;
	}
	public List<Tutor> getTutorList(){
		return this.tutList;
	}
	
	
	
}

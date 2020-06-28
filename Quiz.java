package college_managment_system;


public class Quiz {
	private int courseid;
	private String studentid;//int?
	private String lectuerid;
	private int grade;

	public int getCourseid() {
		return courseid;
	}
	
	public void setcourseid(int courseid) {
        this.courseid=courseid;
	}
	public String getstudentid() {
		return studentid;
	}
	
	public void setstudentid(String studentid) {
        this.studentid=studentid;
	}

	public void setlectuerid(String lectuerid) {
		this.lectuerid = lectuerid;
	}
	
	public String getlectuerid() {
		return lectuerid;
	}
	public int getgrade() {
		return grade;
	}
	
	public void setgrade(int grade) {
        this.grade=grade;
	}
	
}

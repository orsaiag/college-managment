package college_managment_system;
//import java.util.List;
//import java.util.ArrayList;
import java.util.Date;

public class Lecturer extends Person{
	//List<Course> courses;
	int salary;
	String password;
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Lecturer(String id, String name, String address,String password, String email, String dateOfBirth,int salary) {
		super(id, name, address, email, dateOfBirth);
		this.salary=salary;
		this.password=password;
	}
	
	public void showPersonalInformation() {
		System.out.println("Name:"+getName());
		System.out.println("Id:"+getId());
		System.out.println("Address: "+getAddress());
		System.out.println("Email: "+getEmail());
		System.out.println("DateOfBirth: "+getDateOfBirth());
		System.out.println("Salary: "+getSalary());

	}
	
	/*public List<Student> getListStudents(Course course){
		return List<Student>;
	}
	*/
	
	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
/*
	public void showReports() { //override - show reports of all kind 
		
	}
	
*/

}


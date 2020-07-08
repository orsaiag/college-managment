package college_managment_system;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Lecturer extends Person{
	int salary;
	String password;
	ArrayList<Course> l1 = new ArrayList<Course>();
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Lecturer(String id, String name, String email,String password,String address , String dateOfBirth,int salary) {
		super(id, name, address, email, dateOfBirth);
		this.salary=salary;
		this.password=password;
	}
	
	public Lecturer(Lecturer lec) {super(lec.getId(),lec.getName(),lec.getEmail(),lec.getAddress(),lec.getDateOfBirth());
	this.password=lec.getPassword();
	this.salary=lec.getSalary();
		
	}

	public void showPersonalInformation() {
		System.out.println("Name:"+getName());
		System.out.println("Id:"+getId());
		System.out.println("Address: "+getAddress());
		System.out.println("Email: "+getEmail());
		System.out.println("DateOfBirth: "+getDateOfBirth());
		System.out.println("Salary: "+getSalary());

	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public void buildCourseList() throws FileNotFoundException {
		File file = new File("LecturerAndCourse.txt");
		Scanner in = new Scanner(file);
		while (in.hasNext()) {
			String line = in.nextLine();
			if (line.contains(id))
				this.l1.add(new Course(new Integer(line.charAt(line.length() - 1)) - 48));
		}
		in.close();
		file = new File("Course.txt");
		for (int i = 0; i < l1.size(); i++) {
			in = new Scanner(file);
			while (in.hasNext()) {
				String line = in.nextLine();
				if (line.contains(l1.get(i).getCourseID() +""))
					this.l1.get(i).setCourseName(line.substring(2));
			}
		}
		in.close();
	}
	
	public String[] getMyCourses()
	{
		int i=0, j = 1;
		String[] print=new String[this.l1.size()+1];
		print[0]="These are my courses";
		for (; i < l1.size(); i++) {
			print[j++]=( l1.get(i).getCourseID() + " - " + l1.get(i).getCourseName());
		}
		return print;
	}
	
	


}



package college_managment_system;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Tutor extends Person {
	int salary;
	String password;
	ArrayList<Course> l1 = new ArrayList<Course>();

	public int getsalary() {
		return salary;
	}

	public void setsalary(int salary) {
		this.salary = salary;
	}

	public void showStudentInformation() {
		System.out.println("Name:" + getName());
		System.out.println("Id:" + getId());
		System.out.println("Address: " + getAddress());
		System.out.println("Email: " + getEmail());
		System.out.println("Age: " + getDateOfBirth());
		System.out.println("Salary: " + getSalary());
	}

	public Tutor(String id, String name, String address, String email, String password, String dateOfBirth,
			int salary) {
		super(id, name, address, email, dateOfBirth);
		this.salary = salary;
		this.password = password;
	}

	public Tutor(Tutor tut) {
		super(tut.getId(), tut.getName(), tut.getEmail(), tut.getAddress(), tut.getDateOfBirth());
		this.password = tut.getPassword();
		this.salary = tut.getSalary();

	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public void buildCourseList() throws FileNotFoundException {
		File file = new File("TutorAndCourse.txt");
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

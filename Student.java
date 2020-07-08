package college_managment_system;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Student extends Person  implements Cloneable{
	int numberOfCourse;
	String password;
	ArrayList<Course> l1 = new ArrayList<Course>();

	public Student(String id, String name, String email, String password, String address, String dateOfBirth,
			int numberOfCourse) {
		super(id, name, email, address, dateOfBirth);
		this.numberOfCourse = numberOfCourse;
		this.password = password;
	}

	public Student(Student std) {
		super(std.getId(), std.getName(), std.getEmail(), std.getAddress(), std.getDateOfBirth());
		this.password = std.getPassword();
		this.numberOfCourse = std.getNumberOfCourse();

	}

	public void showStudentInformation() {
		System.out.println("Name:" + getName());
		System.out.println(" Id:" + getId());
		System.out.println(" Address: " + getAddress());
		System.out.println(" Email: " + getEmail());
		System.out.println(" DateOfBirth: " + getDateOfBirth());
		System.out.println(" NumberOfCourse: " + getnumberOfCourse());

	}

	public int getNumberOfCourse() {
		return numberOfCourse;
	}

	private int getnumberOfCourse() {
		return numberOfCourse;
	}

	public void setNumberOfCourse(int numberOfCourse) {
		this.numberOfCourse = numberOfCourse;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<Course> getL1() {
		return l1;
	}

	public void setL1(ArrayList<Course> l1) {
		this.l1 = l1;
	}

	public void buildCourseList() throws FileNotFoundException {
		File file = new File("StudentsAndCourse.txt");
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

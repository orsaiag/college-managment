package college_managment_system;

import java.util.ArrayList;

public class Principal extends Person {
	
	int salary; 
	Person[] personArr;
	String password;
	
	public Principal(String id, String name,String email, String password,String address, String dateOfBirth, int salary) {
		super(id,name,address,email,dateOfBirth);
		this.salary = salary;
		this.password=password;
	}
	
	public int showNumOfPersonsInIinstitution() {
		return personArr.length;
	}
	
	public ArrayList<Student> getStudentList(Person[] pArr) {
		ArrayList<Student> studentList = new ArrayList<Student>();
		for(int i=0; i < pArr.length; i++) {
			if (pArr[i] instanceof Student) {
				studentList.add((Student)pArr[i]);
			}	
		}
		return studentList;
	}
	
	public ArrayList<Lecturer> getLecturerList(Person[] pArr) {
		ArrayList<Lecturer> lecturerList = new ArrayList<Lecturer>();
		for(int i=0; i < pArr.length; i++) {
			if (pArr[i] instanceof Lecturer) {
				lecturerList.add((Lecturer)pArr[i]);
			}	
		}
		return lecturerList;
	}
	
	public ArrayList<Tutor> getTutorList(Person[] pArr) {
		ArrayList<Tutor> tutorList = new ArrayList<Tutor>();
		for(int i=0; i < pArr.length; i++) {
			if (pArr[i] instanceof Tutor) {
				tutorList.add((Tutor)pArr[i]);
			}	
		}
		return tutorList;
	}
	
//	public ArrayList<Secratery> getSecrateryList(Person[] pArr) {
//		ArrayList<Secratery> secrateryList = new ArrayList<Secratery>();
//		for(int i=0; i < pArr.length; i++) {
//			if (pArr[i] instanceof Secratery) {
//				secrateryList.add((Secratery)pArr[i]);
//			}	
//		}
//		return secrateryList;
//	}
	
	public ArrayList<Janitor> getJanitorList(Person[] pArr) {
		ArrayList<Janitor> janitorList = new ArrayList<Janitor>();
		for(int i=0; i < pArr.length; i++) {
			if (pArr[i] instanceof Janitor) {
				janitorList.add((Janitor)pArr[i]);
			}	
		}
		return janitorList;
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


	
	// public void showReports() 
}
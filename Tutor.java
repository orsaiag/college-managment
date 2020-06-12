package college_managment_system;

import java.util.List;

public class Tutor extends Person{
	private List<Course> courselist;
	int salary;
	String password;
	
	public int getsalary() {
		return salary;
	}
	
	public void setsalary(int salary) {
        this.salary=salary;
	}
	
	public List<Student> getStudentList(Course c1){
		return null;
		//להחזיר את כל הסטודנטים מהקובץ מאותו קורס
	}
	
	
	public void showStudentInformation() {
		System.out.println("Name:"+getName());
		System.out.println("Id:"+getId());
		System.out.println("Address: "+getAddress());
		System.out.println("Email: "+getEmail());
		System.out.println("Age: "+getDateOfBirth());
		System.out.println("Salary: "+getSalary());
	}
		
		
		public Tutor(String id,String name,String address,String email,String password,String dateOfBirth, int salary) {
		super(id,name,address,email,dateOfBirth);
		this.salary = salary;
		this.password = password;
	}

		public boolean sendRequestChangeDetails(String id,String name, String address,String password, String email) {
			if(this.id!=id)
				return false;
			else {
				if(!name.equals(getName()))
					setName(name);
				if(!address.equals(getAddress()))
					setAddress(address);
				if(!name.equals(getEmail()))
					setEmail(email);
				return true;
			}

			
		}

		public List<Course> getCourselist() {
			return courselist;
		}

		public void setCourselist(List<Course> courselist) {
			this.courselist = courselist;
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
		
}

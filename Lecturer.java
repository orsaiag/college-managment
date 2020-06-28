package college_managment_system;

public class Lecturer extends Person{
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


}


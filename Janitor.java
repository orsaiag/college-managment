package college_managment_system;

public class Janitor extends Person{
	int salary;
	String password;
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Janitor(String id,String name,String address,String password,String email,String dateOfBirth,int salary) {
		super(id,name,address,email,dateOfBirth);
		this.salary=salary;
		this.password=password;
	}
	


	public Janitor(Janitor jan) {super(jan.getId(),jan.getName(),jan.getEmail(),jan.getAddress(),jan.getDateOfBirth());
	this.password=jan.getPassword();
	this.salary=jan.getSalary();
		
	}

	public void showPersonalInformation() {
		System.out.println("Name:"+getName());
		System.out.println("Id:"+getId());
		System.out.println("Address: "+getAddress());
		System.out.println("Email: "+getEmail());
		System.out.println("Age: "+getDateOfBirth());
		System.out.println("Salary: "+getSalary());

	}
	

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public int getSalary() {
		return this.salary;
	}
	
	public boolean sendRequestChangeDetails(String idx,String namex, String addressx, String emailx) {
		boolean value=false;
		if(Person.id!=idx)
			return false;
		else {
			if((namex.equals(getName()))==false) {
				setName(namex);
				value=true;
			}
			if(addressx.equals(getAddress())==false) {
				setAddress(addressx);
			value=true;
			}
			if(emailx.equals(getEmail())==false) {
				setEmail(emailx);
				value=true;
			}
		}
		return value;
	}
	
}

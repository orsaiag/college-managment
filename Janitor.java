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

	public Janitor(String id,String name,String email,String password,String address,String dateOfBirth,int salary) {
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
		System.out.print("STD1 - "+idx+" "+namex+" "+addressx+" "+emailx);
		System.out.print("STD2 - "+this.getId()+" "+this.getName()+" "+this.getAddress()+" "+this.getEmail());
		if(idx.equals(this.getId())==false)
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
		if (value==true)
			System.out.print("TRUEEEE");
		else
			System.out.print("FALSEEE");
		return value;
	}
	
}

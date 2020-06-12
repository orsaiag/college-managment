package college_managment_system;

import java.util.List;
import java.util.ArrayList;

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
	
	public boolean sendRequestChangeDetails(String id,String name, String address, String email) {
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
	
	public void clean() {
		//something
	}
	
}

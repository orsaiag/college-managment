package college_managment_system;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Secratery extends Person{

	int salary;
	String password;
	
	static Secratery secratery;
	
	
	public static Secratery getSecratery(String id, String name,String email, String password,String address, String dateOfBirth, int salary) throws IOException {
		File sec = new File("Secretary.txt");
		if (Controller.controllerSecrateryShowNumberOfRequests("Secretary.txt")<1)
		{
			if (secratery == null)
				secratery = new Secratery(id,name,address,password,email,dateOfBirth,salary);
			FileWriter w=new FileWriter(sec);
			w.append(id+","+name+","+email+","+password+","+address+","+dateOfBirth+","+salary+",\n");
			w.close();
		}
		else
			secratery=null;
		return secratery;
	}
	
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Secratery(String id,String name,String email,String password,String address,String dateOfBirth,int salary) {
		super(id,name,address,email,dateOfBirth);
		this.salary=salary;
		this.password=password;
		
	}
	
	
	public void showPersonalInformation() {
		System.out.println("Name:"+getName());
		System.out.println("Id:"+getId());
		System.out.println("Address: "+getAddress());
		System.out.println("Email: "+getEmail());
		System.out.println("Age: "+ getDateOfBirth());
		System.out.println("Salary: "+getSalary());

	}
	

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public int getSalary() {
		return this.salary;
	}
	

	
}

package college_managment_system;

import java.io.File;
import java.io.IOException;
import java.io.Writer;

public class Secratery extends Person{

	int salary;
	String password;
	
	static Secratery secratery;
	
	
	@SuppressWarnings("null")
	public static Secratery getSecratery(String id, String name,String email, String password,String address, String dateOfBirth, int salary) throws IOException {
		File sec=new File("Secretary.txt");
		if (sec.exists()==false)
		{
			if (secratery == null)
				secratery = new Secratery(id,name,address,password,email,dateOfBirth,salary);
			sec.createNewFile();
			Writer w=null;
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
			if(namex.equals(getEmail())==false) {
				setEmail(emailx);
				value=true;
			}
		}
		return value;
	}
	
	

	
}

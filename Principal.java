package college_managment_system;

import java.io.File;
import java.io.IOException;
import java.io.Writer;

public class Principal extends Person {
	
	int salary; 
	String password;
	
	static Principal principle;
	
	
	@SuppressWarnings("null")
	public static Principal getPrincipal(String id, String name,String email, String password,String address, String dateOfBirth, int salary) throws IOException {
		File pri=new File("Principle.txt");
		if (pri.exists()==false)
		{
			if (principle == null)
				principle = new Principal(id,name,address,password,email,dateOfBirth,salary);
			pri.createNewFile();
			Writer w=null;
			w.append(id+","+name+","+email+","+password+","+address+","+dateOfBirth+","+salary+",\n");
			w.close();
		}
		else
			principle=null;
		return principle;
	}
	
	
	
	public Principal(String id, String name,String email, String password,String address, String dateOfBirth, int salary) {
		super(id,name,address,email,dateOfBirth);
		this.salary = salary;
		this.password=password;
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
package college_managment_system;

public class Tutor extends Person{
	int salary;
	String password;
	
	public int getsalary() {
		return salary;
	}
	
	public void setsalary(int salary) {
        this.salary=salary;
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

		public Tutor(Tutor tut) {
			super(tut.getId(),tut.getName(),tut.getEmail(),tut.getAddress(),tut.getDateOfBirth());
		this.password=tut.getPassword();
		this.salary=tut.getSalary();
			
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

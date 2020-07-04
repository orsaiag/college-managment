package college_managment_system;


public class Student extends Person {
		int numberOfCource;
		String password;
		
public Student(String id,String name, String email,String password,String address,  String dateOfBirth,int numberOfCource) {
	super(id, name,email,address,dateOfBirth);
			this.numberOfCource=numberOfCource;
			this.password=password;
}

	
		
		
		public Student(Student std) { super(std.getId(),std.getName(),std.getEmail(),std.getAddress(),std.getDateOfBirth());
			this.password=std.getPassword();
			this.numberOfCource=std.getNumberOfCource();
	
}




		public void showStudentInformation() {
			System.out.println("Name:"+getName());
			System.out.println(" Id:"+getId());
			System.out.println(" Address: "+getAddress());
			System.out.println(" Email: "+getEmail());
			System.out.println(" DateOfBirth: "+getDateOfBirth());
			System.out.println(" NumberOfCourse: "+getnumberOfCourse());
			
		}
		
	
		
		public int getNumberOfCource() {
			return numberOfCource;
		}




		private int getnumberOfCourse() {
			return numberOfCource;
		}
		


		public void setNumberOfCource(int numberOfCource) {
			this.numberOfCource = numberOfCource;
		}


		public String getPassword() {
		return password;
	}

		public void setPassword(String password) {
			this.password = password;
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

	

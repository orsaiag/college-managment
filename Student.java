package college_managment_system;


//import college_managment_system.Course;
//import college_managment_system.List;
//import college_managment_system.Person;

public class Student extends Person {
		int numberOfCource;
		String password;
		
public Student(String id,String name, String email,String password,String address,  String dateOfBirth,int numberOfCource) {
	super(id, name,email,address,dateOfBirth);
          //כפתור נוסף
	         // this.Course=course;
			//this.Grade=grade;
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
		
		/*
		public void showReports() {
		}
		*/
		
		public int getNumberOfCource() {
			return numberOfCource;
		}




		private int getnumberOfCourse() {
			// TODO Auto-generated method stub
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
		
		

	}

	

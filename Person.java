package college_managment_system;


public abstract class Person {
	
	String id;
	String name;
	String address;
	String email;
	String dateOfBirth;

	
	public Person(String id,String name, String email,String address ,String dateOfBirth) { //ctor
		this.id=id;
		this.address=address;
		this.name=name;
		this.email=email;
		this.dateOfBirth=dateOfBirth;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public void showPersonalInformation() {
		System.out.println("Name: "+getName());
		System.out.println("Id: "+getId());
		System.out.println("Address: "+getAddress());
		System.out.println("Email: "+getEmail());
		System.out.println("DateOfBirth: "+getDateOfBirth());
	}
	
	/*
	public void showReports() {
	}
	*/
	
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

package college_managment_system;


public abstract class Person {
	
	static String id;
	static String name;
	static String address;
	static String email;
	static String dateOfBirth;

	
	public Person(String id,String name, String email,String address ,String dateOfBirth) { //ctor
		Person.id=id;
		Person.address=address;
		Person.name=name;
		Person.email=email;
		Person.dateOfBirth=dateOfBirth;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		Person.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		Person.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		Person.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		Person.email = email;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		Person.dateOfBirth = dateOfBirth;
	}
	
	public void showPersonalInformation() {
		System.out.println("Name: "+getName());
		System.out.println("Id: "+getId());
		System.out.println("Address: "+getAddress());
		System.out.println("Email: "+getEmail());
		System.out.println("DateOfBirth: "+getDateOfBirth());
	}
	

	
	public boolean sendRequestChangeDetails(String id,String name, String address, String email) {
		if(Person.id!=id)
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

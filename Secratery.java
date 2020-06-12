package college_managment_system;

import java.util.List;
import java.util.ArrayList;

public class Secratery extends Person{

	int salary;
	String password;
	
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
		//האם כדי לעשות שליפה פה של מספר הבקשות שיש למזכירה לאשר - כדי שנוכל לבטל את הכפתור
	}
	
	public int showNumberOfUsersForToday() {
		return salary;
		//שליפה מהקובץ כמה אנשים התחברו
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
	
	public void showReports() { //override - show reports of all kind 
		
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
	
	public void approveRequests() {
		// שליפה מהקובץ את כל הבקשות ו"לאשר" אותן ואז למחוק אותן ואולי להוסיף BOOL אם זה הצליח או לא
	}
	
	public boolean addStudent(Person std) {
		//שליפה מהקובץ מספר סטודנט אחרון ואז להוסיף לו אחד STRING STUDENTID
		//לאחר מכן נוסיף לקובץ לשורה של הסדונט את הפרטים השלו ואת המספר סטודנט
		return true;//אם הצליח
		//return false;//אם לא הצליח
	}
	
	public boolean removeStudent(Person std) {
		//שליפה מהקבוץ את המספר שלו, ולאחר מכן למחוק אותו מהקובץ
		return true;//אם הצליח
	//	return false;//אם לא הצליח
	}
	
	public void setNumberCourse(String courseID,int numberofcourse) {
		//אולי עדיף לוותר על הפונקציה הזאת?
	}
	
}

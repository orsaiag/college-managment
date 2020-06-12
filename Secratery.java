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
		//��� ��� ����� ����� �� �� ���� ������ ��� ������� ���� - ��� ����� ���� �� ������
	}
	
	public int showNumberOfUsersForToday() {
		return salary;
		//����� ������ ��� ����� ������
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
		// ����� ������ �� �� ������ �"����" ���� ��� ����� ���� ����� ������ BOOL �� �� ����� �� ��
	}
	
	public boolean addStudent(Person std) {
		//����� ������ ���� ������ ����� ��� ������ �� ��� STRING STUDENTID
		//���� ��� ����� ����� ����� �� ������ �� ������ ���� ��� ����� ������
		return true;//�� �����
		//return false;//�� �� �����
	}
	
	public boolean removeStudent(Person std) {
		//����� ������ �� ����� ���, ����� ��� ����� ���� ������
		return true;//�� �����
	//	return false;//�� �� �����
	}
	
	public void setNumberCourse(String courseID,int numberofcourse) {
		//���� ���� ����� �� �������� ����?
	}
	
}

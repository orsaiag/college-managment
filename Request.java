package college_managment_system;

public class Request {
	
	int requestId;
	Student student;
	
	public int getRequestId() {
		return requestId;
	}
	
	public Student getStudent() {
		return student;
	}
	
	public void updateStudentInformation(Student s, String name, String address, String email) {
		s.name = name;
		s.address = address;
		s.email = email;
	}

}
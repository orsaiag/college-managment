package college_managment_system;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Request {
	
	int requestId;
	
	public int getRequestId() throws IOException {
		return Model.showNumberOfLines("ReqeustInformation.txt")+1;
	}
	

	public void createRequest(int numLines,String id,String name, String email,String address ,String password,  String dateOfBirth,int number) throws IOException {
		BufferedWriter output = new BufferedWriter(new FileWriter("ReqeustInformation.txt",true));
		output.append(getRequestId()+"."+id+','+name+','+email+','+address+','+password+','+dateOfBirth+","+number+",\n");
         output.close();
         System.out.println("Your request has been send to approve");

	}

}
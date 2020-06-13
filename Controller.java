package college_managment_system;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Controller {

	 static Model modelLogin=new Model();

	public static ConnectionStruct controllerLogin(String id,String pass) throws IOException {
		ConnectionStruct answer= Model.modelLogin(id, pass);
		return  answer;	
	}
	
	@SuppressWarnings("static-access")
	public static void controllerConnection(String id,ConnectionStruct connected) throws IOException {
		Object obj1=modelLogin.findWhichTypeOfPerson(connected.type,id);
		switch(connected.type)
		{
		case 1:
		{
			 View.viewStudent((Student) obj1);
			 break;

		}
		case 2:
		{
			View.viewTutor((Student) obj1);
			break;
		}
		case 3:
		{
			View.viewLecturer((Student) obj1);
			break;
		}
		case 4:
		{
			View.viewJanitor((Student) obj1);
			break;
		}
		case 5:
		{
			View.viewSecratery((Secratery) obj1);
			break;
		}
		case 6:
		{
			//View.viewPrinciple((Student) obj1);
			break;
		}
		
	}
	}
	
	//@SuppressWarnings("static-access")
	public static void controllerSecratery(String replaceWith,String id,String fileName) {
		modelLogin.replaceSelected(replaceWith, id, fileName);
	}
	

	public static int controllerSecrateryShowNumberOfRequests() throws IOException
	{
		return modelLogin.showNumberOfLines("ReqeustInformation.txt");
	}
	
	public static String controllerSecrateryShowRequestsToApprove() throws IOException
	{
		return modelLogin.showFile("ReqeustInformation.txt");
	}

	public static void controllerSecrateryDenieRequests() throws IOException {
		modelLogin.deleteFile("ReqeustInformation.txt");
		modelLogin.createFile("ReqeustInformation.txt");
		
	}
	
	
}
	




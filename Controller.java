package college_managment_system;

import java.io.FileNotFoundException;
import java.io.IOException;

@SuppressWarnings("unused")
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
			View.viewTutor((Tutor) obj1);
			break;
		}
		case 3:
		{
			View.viewLecturer((Lecturer) obj1);
			break;
		}
		case 4:
		{
			View.viewJanitor((Janitor) obj1);
			break;
		}
		case 5:
		{
			View.viewSecratery((Secratery) obj1);
			break;
		}
		case 6:
		{
			View.viewPrinciple((Principal) obj1);
			break;
		}
		
	}
	}
	
	@SuppressWarnings("static-access")
	public static void controllerSecratery(String replaceWith,String id,String fileName) {
		modelLogin.replaceSelected(replaceWith, id, fileName);
	}
	

	@SuppressWarnings("static-access")
	public static int controllerSecrateryShowNumberOfRequests(String filename) throws IOException
	{
		return modelLogin.showNumberOfLines(filename);
	}
	
	public static String controllerSecrateryShowRequestsToApprove(String filename) throws IOException
	{
		return modelLogin.showFile(filename);
	}


	public static void controllerSecrateryDenieRequests(String filename) throws IOException {
		modelLogin.deleteFile(filename);
		modelLogin.createFile(filename);
		
	}
	
	
	public static void controllerShowSpecipicLinesFromFile(String id,String filename) throws IOException
	{
		 modelLogin.showSpecipicLinesFromFile(id,filename);
	}

	public static void controllerViewGrades(String id, String filename) throws IOException {
		modelLogin.showGrades(id,filename);
		
	}

	public static void controllershowCoursesITeachOrTutor(String id, String filename) throws IOException {
		modelLogin.showCoursesITeachOrTutor(id,filename);
		
	}

	public static int numOfCoursePerStudent(String id, String filename) throws FileNotFoundException {
		return modelLogin.numOfCoursePerStudent(id,filename);
		
	}

	public static void controllershowStudentPerLecturerOrTutor(String id,String filename) throws FileNotFoundException {
		 modelLogin.showStudentPerLecturerOrTutor(id,filename);
		
	}


	
}
	




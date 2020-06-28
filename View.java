package college_managment_system;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

//1-student
//2-tutor
//3-lecturer
//4-Janitor
//5-Secretary
//6-Principal




public class View {

	@SuppressWarnings({ "unused", "resource" })
	public static void loginView() throws IOException {
    String id;
	String pass;
	int i=0;
  	int type;
  	Scanner sc;
  	ConnectionStruct connection = new ConnectionStruct(0,false);
 	
	sc = new Scanner(System.in);
	System.out.println("Welcome!");
System.out.println("press 1 to login!");
System.out.println("press 2 to exit!");
  	String selectedOption=sc.nextLine();
  	switch(selectedOption)
  	{
  	case "1":
	{
		sc = new Scanner(System.in);
		System.out.println("Enter your ID");
		id = sc.nextLine() ;
		System.out.println("Enter your Password");
		pass = sc.nextLine();
		connection.connection=Controller.controllerLogin(id,pass).connection;
		connection.type=Controller.controllerLogin(id,pass).type;
		connection.errorType=Controller.controllerLogin(id,pass).errorType;
		if(connection.connection==true)
		{
		System.out.println("Connected");
		tenLines();
		
		Controller.controllerConnection(id, connection);
		}
		else
		{
			if(connection.errorType==1)
				System.out.println("Wrong password");
			else
				System.out.println("Wrong ID");
		}
		
	}
  	case "2":
  		System.out.println("GoodBye");
  		System.exit(0);
	}

}

public static void tenLines() {
    for(int z=0;z<=10;z++)
    {
    	System.out.println();
    }
}

@SuppressWarnings({ "resource" })
public static void viewStudent(Student std) throws IOException
{	
	Student std2= new Student(std);
	String editOption = null;
	Scanner sc=null;
    Writer output;
	String selectedOption=null;
	System.out.println("Welcome "+std.getName());
	sc = new Scanner(System.in);

	while(selectedOption!="5") {
		System.out.println();
		System.out.println("press 1 to view personal information!");
		System.out.println("press 2 to edit personal information!");
		System.out.println("press 3 to show grades and overall average!");
		System.out.println("press 4 to add course!");
		System.out.println("press 5 to exit!");
		selectedOption=sc.nextLine();
		switch(selectedOption){
		case "1":
		{
			System.out.println("Your personal information:");
			std.showPersonalInformation();
			break;
		}
		case "2":
		{
			while(editOption!="5")
			{
				System.out.println();
				System.out.println("Which detail do you want to change?");
				System.out.println("1 - Change your Name");
				System.out.println("2 - Change your Email");
				System.out.println("3 - Change your Address");
				System.out.println("4 - Exit editing mode");
				System.out.println("5 - Save and Exit");
				editOption=sc.nextLine();
			switch(editOption)
			{
			case "1":
			{
				System.out.println("Enter your new name:");
				editOption=sc.nextLine();
				std2.setName(editOption);
				break;
			}
			case "2":
			{
				System.out.println("Enter your new email:");
				editOption=sc.nextLine();
				std2.setEmail(editOption);
				break;
			}
			case "3":
			{
				System.out.println("Enter your new address:");
				editOption=sc.nextLine();
				std2.setAddress(editOption);
				break;
			}
			case "4":
			{
				break;
			}
			case "5":
			{
		     output = new BufferedWriter(new FileWriter("ReqeustInformation.txt",true)); 
		     output.append(std2.getId()+','+std2.getName()+','+std2.getEmail()+','+std2.getAddress()+','+std2.getPassword()+','+std2.getDateOfBirth()+','+std2.getNumberOfCource()+",\n");
		     output.close();
		     System.out.println("Your request has been send to approve");
		    break;
			}
		}
			if(editOption.equals("5") || editOption.equals("4"))
				break;
		}
		System.out.println();
		break;
		}
		case "3":
		{
			 Controller.controllerViewGrades(std2.getId(),"Grades.txt");
			 System.out.println();
			 break;
		}
		case "4":
		{
			int numberOfCourse=std.getNumberOfCource(); 
			if(numberOfCourse<Controller.numOfCoursePerStudent(std.getId(),"StudentsAndCourse.txt"))
			{
				 output = new BufferedWriter(new FileWriter("StudentsAndCourse.txt",true));
				 System.out.println("Which course do you want to add? Enter a number 1-4:");
				 System.out.println("1-infi1 , " +"2-algebra , " + "3-CS , " + "4-Java ");
				 int number=sc.nextInt();
				 output.append(std2.getId()+','+number+"\n");
			     output.close();
			     System.out.println("Your added a course succssefully");
			     System.out.println();
			}
			else
				System.out.println("You have reach the limit of courses");
		     break;
		}
		case "5":
		{
			System.out.println("GoodBye");
			System.exit(0);
		}
}
	
	}
}


@SuppressWarnings("resource")
public static void viewTutor(Tutor tut) throws IOException{
	Tutor tut2= new Tutor(tut);
	String editOption = null;
	Scanner sc=null;
    Writer output;
	String selectedOption=null;
	System.out.println("Welcome "+tut.getName());
	sc = new Scanner(System.in);

	while(selectedOption!="5") {
		System.out.println();
		System.out.println("press 1 to view personal information!");
		System.out.println("press 2 to edit personal information!");
		System.out.println("press 3 to show courses!");
		System.out.println("press 4 to show students!");
		System.out.println("press 5 to exit!");
		selectedOption=sc.nextLine();
		switch(selectedOption){
		case "1":
		{
			System.out.println("Your personal information:");
			tut.showPersonalInformation();
			break;
		}
		case "2":
		{
			while(editOption!="5")
			{
				System.out.println();
				System.out.println("Which detail do you want to change?");
				System.out.println("1 - Change your Name");
				System.out.println("2 - Change your Email");
				System.out.println("3 - Change your Address");
				System.out.println("4 - Exit editing mode");
				System.out.println("5 - Save and Exit");
				editOption=sc.nextLine();
			switch(editOption)
			{
			case "1":
			{
				System.out.println("Enter your new name:");
				editOption=sc.nextLine();
				tut2.setName(editOption);
				break;
			}
			case "2":
			{
				System.out.println("Enter your new email:");
				editOption=sc.nextLine();
				tut2.setEmail(editOption);
				break;
			}
			case "3":
			{
				System.out.println("Enter your new address:");
				editOption=sc.nextLine();
				tut2.setAddress(editOption);
				break;
			}
			case "4":
			{
				break;
			}
			case "5":
			{
		     output = new BufferedWriter(new FileWriter("ReqeustInformation.txt",true)); 
		     output.append(tut2.getId()+','+tut2.getName()+','+tut2.getEmail()+','+tut2.getAddress()+','+tut2.getPassword()+','+tut2.getDateOfBirth()+','+tut2.getSalary()+",\n");
		     output.close();
		     System.out.println("Your request has been send to approve");
		    break;
			}
		}
		}
		System.out.println();
		break;
	}
		case "3":	
		{
			Controller.controllershowCoursesITeachOrTutor(tut.getId(), "TutorAndCourse.txt");
			break;
		}
		case "4":
		{
			Controller.controllershowStudentPerLecturerOrTutor(tut.getId(),"TutorAndCourse.txt");
			break;
		}
		case "5":{
			System.out.println("Goodbye");
			System.exit(0);
		}
		
		}
	}
		
	
}


@SuppressWarnings("resource")
public static void viewLecturer(Lecturer lec) throws IOException{
	Lecturer lec2= new Lecturer(lec);
	String editOption = null;
	Scanner sc=null;
    Writer output;
	String selectedOption=null;
	System.out.println("Welcome "+lec.getName());
	sc = new Scanner(System.in);

	while(selectedOption!="6") {
		System.out.println();
		System.out.println("press 1 to view personal information!");
		System.out.println("press 2 to edit personal information!");
		System.out.println("press 3 to show courses!");
		System.out.println("press 4 to show students!");
		System.out.println("press 5 to change grades!");//?
		System.out.println("press 6 to exit!");
		selectedOption=sc.nextLine();
		switch(selectedOption){
		case "1":
		{
			System.out.println("Your personal information:");
			lec.showPersonalInformation();
			break;
		}
		case "2":
		{
			while(editOption!="5")
			{
				System.out.println();
				System.out.println("Which detail do you want to change?");
				System.out.println("1 - Change your Name");
				System.out.println("2 - Change your Email");
				System.out.println("3 - Change your Address");
				System.out.println("4 - Exit editing mode");
				System.out.println("5 - Save and Exit");
				editOption=sc.nextLine();
			switch(editOption)
			{
			case "1":
			{
				System.out.println("Enter your new name:");
				editOption=sc.nextLine();
				lec2.setName(editOption);
				break;
			}
			case "2":
			{
				System.out.println("Enter your new email:");
				editOption=sc.nextLine();
				lec2.setEmail(editOption);
				break;
			}
			case "3":
			{
				System.out.println("Enter your new address:");
				editOption=sc.nextLine();
				lec2.setAddress(editOption);
				break;
			}
			case "4":
			{
				break;
			}
			case "5":
			{
		     output = new BufferedWriter(new FileWriter("ReqeustInformation.txt",true)); 
		     output.append(lec2.getId()+','+lec2.getName()+','+lec2.getEmail()+','+lec2.getAddress()+','+lec2.getPassword()+','+lec2.getDateOfBirth()+','+lec2.getSalary()+",\n");
		     output.close();
		     System.out.println("Your request has been send to approve");
		    break;
			}
		}
		}
		System.out.println();
		break;
	}
		case "3":
		{
			Controller.controllershowCoursesITeachOrTutor(lec.getId(), "LecturerAndCourse.txt");
		break;	
		}
		
		case "4":
		{
			Controller.controllershowStudentPerLecturerOrTutor(lec.getId(),"LecturerAndCourse.txt");
			break;
		}
		case "5":
		{
			break;
		}
		case "6":{
			System.out.println("GoodBye");
			System.exit(0);
		}
		}
	}
	

}


@SuppressWarnings("resource")
public static void viewJanitor(Janitor jan) throws IOException{
	
	Janitor jan2= new Janitor(jan);
	String editOption = null;
	Scanner sc=null;
    Writer output;
	String selectedOption=null;
	System.out.println("Welcome "+jan.getName());
	sc = new Scanner(System.in);

	while(selectedOption!="3") {
		System.out.println();
		System.out.println("press 1 to view personal information!");
		System.out.println("press 2 to edit personal information!");
		System.out.println("press 3 to exit!");
		selectedOption=sc.nextLine();
		switch(selectedOption){
		case "1":
		{
			System.out.println("Your personal information:");
			jan.showPersonalInformation();
			break;
		}
		case "2":
		{
			while(editOption!="5")
			{
				System.out.println();
				System.out.println("Which detail do you want to change?");
				System.out.println("1 - Change your Name");
				System.out.println("2 - Change your Email");
				System.out.println("3 - Change your Address");
				System.out.println("4 - Exit editing mode");
				System.out.println("5 - Save and Exit");
				editOption=sc.nextLine();
			switch(editOption)
			{
			case "1":
			{
				System.out.println("Enter your new name:");
				editOption=sc.nextLine();
				jan2.setName(editOption);
				break;
			}
			case "2":
			{
				System.out.println("Enter your new email:");
				editOption=sc.nextLine();
				jan2.setEmail(editOption);
				break;
			}
			case "3":
			{
				System.out.println("Enter your new address:");
				editOption=sc.nextLine();
				jan2.setAddress(editOption);
				break;
			}
			case "4":
			{
				break;
			}
			case "5":
			{
		     output = new BufferedWriter(new FileWriter("ReqeustInformation.txt",true)); 
		     output.append(jan2.getId()+','+jan2.getName()+','+jan2.getEmail()+','+jan2.getAddress()+','+jan2.getPassword()+','+jan2.getDateOfBirth()+','+jan2.getSalary()+",\n");
		     output.close();
		     System.out.println("Your request has been send to approve");
		    break;
			}
		}
		}
		System.out.println();
	}
		case "3":{
			System.out.println("GoodBye");
			System.exit(0);
		}
}
	}
}


@SuppressWarnings({ "resource" })
public static void viewSecratery(Secratery sec) throws IOException{

	String editOption = null;
	Scanner sc=null;
    String selectedOption=null;
	System.out.println("Welcome "+sec.getName());
	sc = new Scanner(System.in);

	while(selectedOption!="5") {
		System.out.println();
		System.out.println("press 1 to view personal information!");
		System.out.println("press 2 to edit personal information!");
		System.out.println("press 3 to show waiting requests!");
		System.out.println("press 4 to add course to student");//?
		System.out.println("press 5 to exit!");
		selectedOption=sc.nextLine();
		switch(selectedOption){
		case "1":
		{
			System.out.println("Your personal information:");
			sec.showPersonalInformation();
			break;
		}
		case "2":
		{
			while(editOption!="5")
			{
				System.out.println();
				System.out.println("Which detail do you want to change?");
				System.out.println("1 - Change your Name");
				System.out.println("2 - Change your Email");
				System.out.println("3 - Change your Address");
				System.out.println("4 - Exit editing mode");
				System.out.println("5 - Save and Exit");
				editOption=sc.nextLine();
			switch(editOption)
			{
			case "1":
			{
				System.out.println("Enter your new name:");
				editOption=sc.nextLine();
				sec.setName(editOption);
				break;
			}
			case "2":
			{
				System.out.println("Enter your new email:");
				editOption=sc.nextLine();
				sec.setEmail(editOption);
				break;
			}
			case "3":
			{
				System.out.println("Enter your new address:");
				editOption=sc.nextLine();
				sec.setAddress(editOption);
				break;
			}
			case "4":
			{
				break;
			}
			case "5":
			{
			Controller.controllerSecratery(sec.getId()+','+sec.getName()+','+sec.getEmail()+','+sec.getAddress()+','+sec.getPassword()+','+sec.getDateOfBirth()+','+sec.getSalary()+",\n",sec.getId(),"Secretary.txt");
		     System.out.println("Changed");
		    break;
			}
		}
		}
		System.out.println();
	}
		case "3":
		{
			while(editOption!="5")
			{
				System.out.println();
				System.out.println("Which action do you want to do?");
				System.out.println("1 - Show number of requests");
				System.out.println("2 - Show requests");
				System.out.println("3 - Approve & Exit requests");//
				System.out.println("4 - Denie & Exit requests");
				System.out.println("5 - Exit");
				editOption=sc.nextLine();
			switch(editOption)
			{
			case "1":
			{
				System.out.println("The number of requests are: "+Controller.controllerSecrateryShowNumberOfRequests("ReqeustInformation.txt"));
				break;
			}
			case "2":
			{
				System.out.println("The Waiting requests are:");
				System.out.println(Controller.controllerSecrateryShowRequestsToApprove("ReqeustInformation.txt"));
				break;
			}
			case "3":
			{
				System.out.println("Enter your new address:");
				editOption=sc.nextLine();
				sec.setAddress(editOption);
				break;
			}
			case "4":
			{
				Controller.controllerSecrateryDenieRequests("ReqeustInformation.txt");
				System.out.println("The requests were denied.");
				break;
			}
			case "5":
			{
			Controller.controllerSecratery(sec.getId()+','+sec.getName()+','+sec.getEmail()+','+sec.getAddress()+','+sec.getPassword()+','+sec.getDateOfBirth()+','+sec.getSalary()+",\n",sec.getId(),"Secretary.txt");
		     System.out.println("Changed");
		    break;
			}
		}
			
			
		}
		
	
}
	}
	}
	
}


@SuppressWarnings("resource")
public static void viewPrinciple(Principal obj1) throws IOException{

	String editOption = null;
	Scanner sc=null;
    String selectedOption=null;
	System.out.println("Welcome "+obj1.getName());
	sc = new Scanner(System.in);

	while(selectedOption!="5") {
		System.out.println();
		System.out.println("press 1 to view personal information!");
		System.out.println("press 2 to edit personal information!");
		System.out.println("press 3 to show actions for students");//
		System.out.println("press 4 to show actions for workers");//
		System.out.println("press 5 to exit!");
		selectedOption=sc.nextLine();
		switch(selectedOption){
		case "1":
		{
			System.out.println("Your personal information:");
			obj1.showPersonalInformation();
			break;
		}
		case "2":
		{
			while(editOption!="5")
			{
				System.out.println();
				System.out.println("Which detail do you want to change?");
				System.out.println("1 - Change your Name");
				System.out.println("2 - Change your Email");
				System.out.println("3 - Change your Address");
				System.out.println("4 - Exit editing mode");
				System.out.println("5 - Save and Exit");
				editOption=sc.nextLine();
			switch(editOption)
			{
			case "1":
			{
				System.out.println("Enter your new name:");
				editOption=sc.nextLine();
				obj1.setName(editOption);
				break;
			}
			case "2":
			{
				System.out.println("Enter your new email:");
				editOption=sc.nextLine();
				obj1.setEmail(editOption);
				break;
			}
			case "3":
			{
				System.out.println("Enter your new address:");
				editOption=sc.nextLine();
				obj1.setAddress(editOption);
				break;
			}
			case "4":
			{
				break;
			}
			case "5":
			{
			Controller.controllerSecratery(obj1.getId()+','+obj1.getName()+','+obj1.getEmail()+','+obj1.getAddress()+','+obj1.getPassword()+','+obj1.getDateOfBirth()+','+obj1.getSalary()+",\n",obj1.getId(),"Secretary.txt");
		     System.out.println("Changed");
		    break;
			}
		}
		}
		System.out.println();
	}
		case "3":
		{
			while(editOption!="5")
			{
				System.out.println();
				System.out.println("Which action do you want to do?");
				System.out.println("1 - Show number of students");
				System.out.println("2 - Show students information");
				System.out.println("3 - show grades and average");
				System.out.println("4 -  Exit");
				editOption=sc.nextLine();
			switch(editOption)
			{
			case "1":
			{
				System.out.println("The number of students are: "+Controller.controllerSecrateryShowNumberOfRequests("ReqeustInformation.txt"));
				break;
			}
			case "2":
			{
				System.out.println("The students information: ");
				System.out.println(Controller.controllerSecrateryShowRequestsToApprove("Student.txt"));
				break;
			}
			case "3":
			{
				System.out.println("The grades and average information: ");
				System.out.println("Average:" );//add get average function
				System.out.println(Controller.controllerSecrateryShowRequestsToApprove("Grades.txt"));
				break;
			}
			case "4":
			{
				break;
			}
			}
		}
			
			
		}
		
	
}
	}
	}
	
}











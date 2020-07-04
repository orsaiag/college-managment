package college_managment_system;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//1-student
//2-tutor
//3-lecturer
//4-Janitor
//5-Secretary
//6-Principal




public class View {
	 static int numLines=0;

@SuppressWarnings("resource")
public static void loginView() throws IOException {
    String id,pass;
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
	String editOption = "";
	String selectedOption="";
	Scanner sc=null;
	System.out.println("Welcome "+std.getName());
	sc = new Scanner(System.in);
	BufferedWriter output;
	while(selectedOption.equals("5")==false) {
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
			while(editOption.equals("5")==false && editOption.equals("4")==false)
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
			     boolean request= std2.sendRequestChangeDetails(std2.getId(), std2.getName(), std2.getAddress(),std2.getEmail());
			     if (request==true)
			    	 {
			    	 Request re=new Request();
			    	 re.createRequest(numLines,std2.getId(), std2.getName(), std2.getEmail(), std2.getAddress(), std2.getPassword(), std2.getDateOfBirth(), std2.getNumberOfCource());
			    	 }
			     else
			    	 System.out.println("nothing changed");
			    break;
				}
			}
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
	String editOption = "";
	String selectedOption="";
	Scanner sc=null;
	System.out.println("Welcome "+tut.getName());
	sc = new Scanner(System.in);

	while(selectedOption.equals("6")==false) {
		System.out.println();
		System.out.println("press 1 to view personal information!");
		System.out.println("press 2 to edit personal information!");
		System.out.println("press 3 to show courses!");
		System.out.println("press 4 to show students!");
		System.out.println("press 5 to show Reports - Grades");
		System.out.println("press 6 to exit!");
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
			while(editOption.equals("5")==false && editOption.equals("4")==false)
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
			     numLines=(Controller.controllerShowLine("ReqeustInformation.txt"))+1;
			     boolean request= tut2.sendRequestChangeDetails(tut2.getId(), tut2.getName(), tut2.getAddress(),tut2.getEmail());
			     if (request==true)
			    	 {
			    	 Request re=new Request();
			    	 re.createRequest(numLines,tut2.getId(), tut2.getName(), tut2.getEmail(), tut2.getAddress(), tut2.getPassword(), tut2.getDateOfBirth(), tut2.getSalary());
			    	 }
			     else
			    	 System.out.println("nothing changed");
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
		case "5":
		{
			System.out.println("The grades and average information: ");
			Controller.controllerShowGradesOfAllStudents("Grades.txt");
			break;
		}
		case "6":{
			System.out.println("Goodbye");
			System.exit(0);
		}
		
		}
	}
		
	
}


@SuppressWarnings({ "resource" })
public static void viewLecturer(Lecturer lec) throws IOException{
	Lecturer lec2= new Lecturer(lec);
	String editOption = "",num="";
	String selectedOption="";
	Scanner sc=null;
	System.out.println("Welcome "+lec.getName());
	sc = new Scanner(System.in);

	while(selectedOption.equals("7")==false) {
		System.out.println();
		System.out.println("press 1 to view personal information!");
		System.out.println("press 2 to edit personal information!");
		System.out.println("press 3 to show courses!");
		System.out.println("press 4 to show students!");
		System.out.println("press 5 to  add or change grades!");
		System.out.println("press 6 to show reports - Grades");
		System.out.println("press 7 to exit!");
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
			while(editOption.equals("5")==false && editOption.equals("4")==false)
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
		     numLines=(Controller.controllerShowLine("ReqeustInformation.txt"))+1;
		     boolean request= lec2.sendRequestChangeDetails(lec2.getId(), lec2.getName(), lec2.getAddress(),lec2.getEmail());
		     if (request==true)
		    	 {
		    	 Request re=new Request();
		    	 re.createRequest(numLines,lec2.getId(), lec2.getName(), lec2.getEmail(), lec2.getAddress(), lec2.getPassword(), lec2.getDateOfBirth(), lec2.getSalary());
		    	 }
		     else
		    	 System.out.println("nothing changed");
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
			System.out.println("which action do you want to do?");
			System.out.println("press 1 to change existing grade");
			System.out.println("press 2 to add new grade per student");
			num=sc.nextLine();
			switch(num) {
			case"1":{
			String newGrade = null,id=null,oldGrade=null;
			System.out.println("Please enter student id to change his grade");
			Scanner scan = new Scanner(System.in);
			id=scan.nextLine();
			System.out.println("Please enter old grade");
			oldGrade=scan.nextLine();
			System.out.println("Please enter new grade");
			newGrade=scan.nextLine();
			Controller.controllerChaneGrades(id,oldGrade,newGrade);
			break;
			}
			case "2":{
				String id=null,course=null, type=null, grade=null;
				Scanner scan = new Scanner(System.in);
				System.out.println("please enter id (9 digits)");
				id=scan.nextLine();
				System.out.println("please enter which course: 1-infi1, 2-algebra, 3-cs, 4-java ");
				course=scan.nextLine();
				System.out.println("please enter 1-Exam, 2-Quiz ");
				type=scan.nextLine();
				System.out.println("please enter grade ");
				grade=scan.nextLine();
				Controller.controllerAddGrade(id,course,type,grade);
				break;
			}
			}
			break;
		}
		case "6":
		{
			System.out.println("The grades and average information: ");
			Controller.controllerShowGradesOfAllStudents("Grades.txt");
			break;
		}
		case "7":{
			System.out.println("GoodBye");
			System.exit(0);
		}
		}
	}
	

}


@SuppressWarnings("resource")
public static void viewJanitor(Janitor jan) throws IOException{
	
	Janitor jan2= new Janitor(jan);
	String editOption = "";
	String selectedOption="";
	Scanner sc=null;
	System.out.println("Welcome "+jan.getName());
	sc = new Scanner(System.in);

	while(selectedOption.equals("3")==false) {
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
			while(editOption.equals("5")==false && editOption.equals("4")==false)
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
			     numLines=(Controller.controllerShowLine("ReqeustInformation.txt"))+1;
			     boolean request= jan2.sendRequestChangeDetails(jan2.getId(), jan2.getName(), jan2.getAddress(),jan2.getEmail());
			     if (request==true)
			    	 {
			    	 Request re=new Request();
			    	 re.createRequest(numLines,jan2.getId(), jan2.getName(), jan2.getEmail(), jan2.getAddress(), jan2.getPassword(), jan2.getDateOfBirth(), jan2.getSalary());
			    	 }
			     else
			    	 System.out.println("nothing changed");
			    break;
				}
			}
			}
			System.out.println();
			break;
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

	String editOption = "";
	String selectedOption="";
	Scanner sc=null;
	System.out.println("Welcome "+sec.getName());
	sc = new Scanner(System.in);

	while(selectedOption.equals("7")==false) {
		System.out.println();
		System.out.println("press 1 to view personal information!");
		System.out.println("press 2 to edit personal information!");
		System.out.println("press 3 to show action on waiting requests!");
		System.out.println("press 4 to add course to student");
		System.out.println("press 5 to show reports - Grades");
		System.out.println("press 6 to add new worker or student");
		System.out.println("press 7 to exit!");
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
			while(editOption.equals("4")==false)
			{
				System.out.println();
				System.out.println("Which detail do you want to change?");
				System.out.println("1 - Change your Name");
				System.out.println("2 - Change your Email");
				System.out.println("3 - Change your Address");
				System.out.println("4 - Save and Exit");
				editOption=sc.nextLine();
			switch(editOption)
			{
			case "1":
			{
				System.out.println("Enter your new name:");
				editOption=sc.nextLine();
				Controller.controllerSecratery("Secretary.txt",sec.getId(),sec.getName(),editOption);
				sec.setName(editOption);
				break;
			}
			case "2":
			{
				System.out.println("Enter your new email:");
				editOption=sc.nextLine();
				Controller.controllerSecratery("Secretary.txt",sec.getId(),sec.getEmail(),editOption);
				sec.setEmail(editOption);
				break;
			}
			case "3":
			{
				System.out.println("Enter your new address:");
				editOption=sc.nextLine();
				Controller.controllerSecratery("Secretary.txt",sec.getId(),sec.getAddress(),editOption);
				sec.setAddress(editOption);
				break;
			}
			case "4":
			{
			break;
			}
		}
		}
		System.out.println();
		break;
	}
		case "3":
		{
			while(editOption.equals("5")==false)
			{
				System.out.println();
				System.out.println("Which action do you want to do?");
				System.out.println("1 - Show number of requests");
				System.out.println("2 - Show requests");
				System.out.println("3 - Approve & Exit requests");
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
				String numberOfRequest=null,numberOfRequestToAprrove=null;
				System.out.println("The Waiting requests are:");
				System.out.println(Controller.controllerSecrateryShowRequestsToApprove("ReqeustInformation.txt"));
				System.out.println();
				System.out.println("Please enter the number of request you want to approve");
				Scanner scan = new Scanner(System.in);
				numberOfRequestToAprrove=scan.nextLine();
				int num=new Integer(numberOfRequestToAprrove);
				for(int i=0;i<num;i++) {
				System.out.println("Please enter the number of request you want to approve from the list");
				numberOfRequest=scan.nextLine();
				Controller.controllerSecrateryApproveRequests(new Integer(numberOfRequest));
				}
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
				break;
			}		
		}	
		}
	break;
}
		case "4":
		{
			String id=null,oldNumberOfCourses=null,newNumberOfCourses=null;
			System.out.println("Please enter student id to change his numer of courses");
			Scanner scan = new Scanner(System.in);
			id=scan.nextLine();
			System.out.println("Please enter old numer of courses");
			oldNumberOfCourses=scan.nextLine();
			System.out.println("Please enter new numer of courses");
			newNumberOfCourses=scan.nextLine();
			Controller.controllerChangeNumberOfCoursesForStudent(id,oldNumberOfCourses,newNumberOfCourses);
			break;
		}
		case "5":
		{
			System.out.println("The grades and average information: ");
			Controller.controllerShowGradesOfAllStudents("Grades.txt");
			break;
		}
		case "6":
		{
			String id=null,name=null, email=null, password=null, address=null, dateOfBirth=null,number=null,type=null;
			Scanner scan = new Scanner(System.in);
			System.out.println("please enter id (9 digits)");
			id=scan.nextLine();
			System.out.println("please enter name ");
			name=scan.nextLine();
			System.out.println("please enter email ");
			email=scan.nextLine();
			System.out.println("please enter password ");
			password=scan.nextLine();
			System.out.println("please enter address ");
			address=scan.nextLine();
			System.out.println("please enter date of birth DD/MM/YYYY ");
			dateOfBirth=scan.nextLine();
			System.out.println("please enter type of person: 1-student, 2-tutor, 3-lecturer , 4-janitor, 5-secratery ,6-principle");
			type=scan.nextLine();
			int typen=new Integer(type);
			if(typen==1)
				System.out.println("please enter number of courses (one digit)");
			else
				System.out.println("please enter salary ");
			number=scan.nextLine();
			int num=new Integer(number);
			Controller.controllerAddNewStuentOrWorker(typen, id, name, email, password, address, dateOfBirth, num);
			break;
		}
		case "7":
		{
			System.out.println("GoodBye");
			System.exit(0);
		}
	}
	}
	
}


@SuppressWarnings("resource")
public static void viewPrinciple(Principal obj1) throws IOException{

	BufferedWriter output=null;
	String editOption = "";
	String selectedOption="";
	Scanner sc=null;
	System.out.println("Welcome "+obj1.getName());
	sc = new Scanner(System.in);

	while(selectedOption.equals("5")==false) {
		System.out.println();
		System.out.println("press 1 to view personal information!");
		System.out.println("press 2 to edit personal information!");
		System.out.println("press 3 to show actions for students");
		System.out.println("press 4 to show actions for workers");
		System.out.println("press 5 to add new student or worker");
		System.out.println("press 6 to exit!");
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
			while(editOption.equals("5")==false && editOption.equals("4")==false)
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
			     output = new BufferedWriter(new FileWriter("ReqeustInformation.txt",true)); 
			     numLines=(Controller.controllerShowLine("ReqeustInformation.txt"))+1;
			     output.append(numLines+"."+obj1.getId()+','+obj1.getName()+','+obj1.getEmail()+','+obj1.getAddress()+','+obj1.getPassword()+','+obj1.getDateOfBirth()+','+obj1.getSalary()+",\n");
			     output.close();
		    break;
			}
		}
		}
		System.out.println();
		break;
	}
		case "3":
		{
			while(editOption.equals("4")==false)
			{
				System.out.println();
				System.out.println("Which action do you want to do?");
				System.out.println("1 - Show number of students");
				System.out.println("2 - Show students information");
				System.out.println("3 - show reports - Grades");
				System.out.println("4 -  Exit");
				editOption=sc.nextLine();
			switch(editOption)
			{
			case "1":
			{
				System.out.println("The number of students are: "+Controller.controllerSecrateryShowNumberOfRequests("Student.txt"));
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
				Controller.controllerShowGradesOfAllStudents("Grades.txt");
				break;
			}
			case "4":
			{
				break;
			}
			}
		}	
		}
		case "4":
		{
			System.out.println("The Workers information: ");
			System.out.println("Lecturers: ");
			System.out.println(Controller.controllerSecrateryShowRequestsToApprove("Lecturer.txt"));
			System.out.println("Tutor: ");
			System.out.println(Controller.controllerSecrateryShowRequestsToApprove("Tutor.txt"));
			System.out.println("Secretary: ");
			System.out.println(Controller.controllerSecrateryShowRequestsToApprove("Secretary.txt"));
			System.out.println("Janitor: ");
			System.out.println(Controller.controllerSecrateryShowRequestsToApprove("Janitor.txt"));
			break;
		}
		case "5":
		{
			String id=null,name=null, email=null, password=null, address=null, dateOfBirth=null,number=null,type=null;
			Scanner scan = new Scanner(System.in);
			System.out.println("please enter id (9 digits)");
			id=scan.nextLine();
			System.out.println("please enter name ");
			name=scan.nextLine();
			System.out.println("please enter email ");
			email=scan.nextLine();
			System.out.println("please enter password ");
			password=scan.nextLine();
			System.out.println("please enter address ");
			address=scan.nextLine();
			System.out.println("please enter date of birth DD/MM/YYYY ");
			dateOfBirth=scan.nextLine();
			System.out.println("please enter type of person: 1-student, 2-tutor, 3-lecturer , 4-janitor, 5-secratery ,6-principle");
			type=scan.nextLine();
			int typen=new Integer(type);
			if(typen==1)
				System.out.println("please enter number of courses (one digit)");
			else
				System.out.println("please enter salary ");
			number=scan.nextLine();
			int num=new Integer(number);
			Controller.controllerAddNewStuentOrWorker(typen, id, name, email, password, address, dateOfBirth, num);
			break;
		}
		case "6":
		{
			System.out.println("GoodBye");
			System.exit(0);
		}
		
	
}
	}
	}
	
}











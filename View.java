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

	LoginPage login=new LoginPage();

	@SuppressWarnings({ "unused", "resource", "null" })
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
			System.out.println(connection.type);
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

@SuppressWarnings({ "resource", "null" })
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
		}
		System.out.println();
	}
	
}
	}
}


public static void viewTutor(Student std) throws IOException{
	
}




public static void viewLecturer(Student std) throws IOException{


}



public static void viewJanitor(Student std) throws IOException{

}


@SuppressWarnings({ "resource", "static-access" })
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
		System.out.println("press 4 to add course to student");
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
				System.out.println("3 - Approve & Exit requests");
				System.out.println("4 - Denie & Exit requests");
				System.out.println("5 - Exit");
				editOption=sc.nextLine();
			switch(editOption)
			{
			case "1":
			{
				System.out.println("The number of requests are: "+Controller.controllerSecrateryShowNumberOfRequests());
				break;
			}
			case "2":
			{
				System.out.println("The Waiting requests are:");
				System.out.println(Controller.controllerSecrateryShowRequestsToApprove());
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
				Controller.controllerSecrateryDenieRequests();
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


public static void viewPrinciple(Student std) throws IOException{
	
}
}










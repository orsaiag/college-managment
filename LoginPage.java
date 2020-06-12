package college_managment_system;
import java.io.BufferedWriter;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner; // Import the Scanner class to read text files


//1-student
//2-tutor
//3-lecturer
//4-Janitor
//5-Secretary
//6-Principal

public class LoginPage {

		  @SuppressWarnings({ "null", "resource" })
		public static void main(String[] args) throws IOException {
		    try {
		    	String id;
		    	String pass;
		    	char idvalidate[]=new char[9];////validation to id-from file
		    	char passvali[]=null;//validation to password- from file
		    	char array[];//all the line from User.txt
		    	int i=0;
		    	int type;
		    	int countid=0,countpass=0;
		    	boolean found=false;
		    	int countdot=0;
		    	Scanner sc;
		    	
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
			      File cuurentUser = new File("User.txt");//open file User
			      Scanner myReader = new Scanner(cuurentUser);//scan the first line fron User.txt
			      while (myReader.hasNextLine()) {//if there is a next line
			    	i=0;
			        String data = myReader.nextLine();
			        array=new char[data.length()];
			    	data.getChars(0, data.length(), array, 0);
			        while(array[i]!=',' && i<9)
			        {
			        	idvalidate[countid]=array[i];
			        	i++;
			        	countid++;
			        }
			        countid=0;
			        if(id.equals(new String(idvalidate)))
			        {
			        	found=true;
			        	i++;
			        	while(array[i]!=',')
			        	{
			        		countpass++;
				        	i++;
			        	}
			        	
			        	i-=countpass;
			        	passvali=new char[countpass];
			        	countpass=0;
			        	
			        	while(array[i]!=',')
			        	{
				        	passvali[countpass++]=array[i];
				        	i++;
			        	}
			        	countpass=0;
			        	if(pass.equals(new String(passvali)))
				        {
			        		System.out.println("Connected");
			        		i++;
			        		type=new Integer(array[i])-48;
			        		switch(type)
			        		{
			        		case 1:
			        		{
			        			@SuppressWarnings("unused")
								Student student=(Student) getObjectFromFile(type,id,"Student.txt");
			        		    for(int z=0;z<=10;z++)
			        		    {
			        		    	System.out.println();
			        		    }
			        		    viewStudent(student);
			        			break;
			        		}
			        		case 2:
			        		{
			        			@SuppressWarnings("unused")
								Tutor tutor=(Tutor) getObjectFromFile(type,id,"Tutor.txt");
			        		    for(int z=0;z<=10;z++)
			        		    {
			        		    	System.out.println();
			        		    }
			        			break;
			        		}
			        		case 3:
			        		{
			        			@SuppressWarnings("unused")
			        			Lecturer lecturer=(Lecturer) getObjectFromFile(type,id,"Lecturer.txt");
			        		    for(int z=0;z<=10;z++)
			        		    {
			        		    	System.out.println();
			        		    }
			        			break;
			        		}
			        		case 4:
			        		{
			        			@SuppressWarnings("unused")
			        			Janitor janitor=(Janitor) getObjectFromFile(type,id,"Janitor.txt");
			        		    for(int z=0;z<=10;z++)
			        		    {
			        		    	System.out.println();
			        		    }
			        			break;
			        		}
			        		case 5:
			        		{
			        			@SuppressWarnings("unused")
			        			Secratery secretary=(Secratery) getObjectFromFile(type,id,"Secretary.txt");
			        		    for(int z=0;z<=10;z++)
			        		    {
			        		    	System.out.println();
			        		    }
			        			break;
			        		}
			        		case 6:
			        		{
			        			@SuppressWarnings("unused")
			        			Principal principle=(Principal) getObjectFromFile(type,id,"Principle.txt");
			        		    for(int z=0;z<=10;z++)
			        		    {
			        		    	System.out.println();
			        		    }
			        			break;
			        		}
			        		}
			        		break;
				        }
			        	else
			        	{
			        		System.out.println("Wrong password");
			        		break;
			        	}
			        }
			      }
			      if(found==false)
			      {
			    	  System.out.println("Wrong ID");
			      }
			      myReader.close();
			      break;
		    	}
			    case "2":
			    {
			    	System.out.println("GoodBye");
			    	break;
			    }
		    	}	
		    	
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		  
		    for(int z=0;z<=10;z++)
		    {
		    	System.out.println();
		    }
		    
		  }


public static Object getObjectFromFile(int type,String id,String file) {
	int count=0,i=0,j=0;
	Object obj1 = null;
	String info[]=new String[7];
	char infodata[]=null;
	try {

	File currentUser = new File(file);//open file User
	 Scanner myReader = new Scanner(currentUser);
     while (myReader.hasNextLine() && j<7) {
    	 char data[]= myReader.nextLine().toCharArray();
    	// String data= myReader.nextLine(); 
    	 i=0;
    	 count=0;
    	 while(j<7) 
    	 {
    		 count=0;
    		 while(data[i]!=',')
    		 {
    			 count++;
    			 i++;		 
    		 }
    		 i-=count;
    		 infodata=new char[count];
    		 count=0;
    		 while(data[i]!=',')
    		 {
    			 infodata[count++]=data[i++];
    		 }
    		 i++;
    		  if((id.equals(new String(infodata)))==false && j==0)
    		 {
    			// j=0;
    			 break;
    		 }
    		 info[j]=String.copyValueOf(infodata);
    		 j++;
    	 }
    	 	
     }
     myReader.close();
     switch(type)
 	{
 	case 1:	
 		{
 		Student object=new Student(id,info[1],info[2],info[3],info[4],info[5],(new Integer(info[6])));
 		obj1=(Object)object;
 		return (Object)object;
 		}
 	case 2:
 	{
 		Tutor object=new Tutor(id,info[1],info[2],info[3],info[4],info[5],(new Integer(info[6])));
 		obj1=(Object)object;
 		return (Object)object;
 	}
 	case 3:
 	{
 		Lecturer object=new Lecturer(id,info[1],info[2],info[3],info[4],info[5],(new Integer(info[6])));
 		obj1=(Object)object;
 		return (Object)object;
 	}
 	case 4:
 	{
 		Janitor object=new Janitor(id,info[1],info[2],info[3],info[4],info[5],(new Integer(info[6])));
 		obj1=(Object)object;
 		return (Object)object;
 	}
 	case 5:
 	{
 		Secratery object=new Secratery(id,info[1],info[2],info[3],info[4],info[5],(new Integer(info[6])));
 		obj1=(Object)object;
 		return (Object)object;
 	}
 	case 6:
 	{
 		Principal object=new Principal(id,info[1],info[2],info[3],info[4],info[5],(new Integer(info[6])));
 		obj1=(Object)object;
 		return (Object)object;
 	}
 	}
} catch (FileNotFoundException e)
	{
	System.out.println("An error occurred.");
    e.printStackTrace();
  }
	return obj1;
	
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
}

		




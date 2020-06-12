package college_managment_system;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class testreadfile {
	  @SuppressWarnings({ "null", "resource" })
	public static void main(String[] args) {
	    try {
	    	String id;
	    	String pass;
	    	char idvalidate[]=new char[9];
	    	char passvali[]=null;
	    	char array[];
	    	int i=0;
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
	    		sc = new Scanner(System.in);
	    		System.out.println("Enter your ID");
		    	id = sc.nextLine() ;
		    	System.out.println("Enter your Password");
		    	pass = sc.nextLine();
		      File myObj = new File("Student.txt");
		      File cuurentUser = new File("User.txt");
		      Scanner myReader = new Scanner(cuurentUser);
		      while (myReader.hasNextLine()) {
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
		        	while(countdot!=4)
		        	{
		        		if(array[i]==',')
		        			countdot++;
		        		i++;
		        	}
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
		      else
		      {
		    	  
		      }
		      myReader.close();
	    	}
	    	 
	    	
	    	
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	  }
	}
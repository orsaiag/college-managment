package college_managment_system;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Model {

	public static ConnectionStruct modelLogin(String id,String pass) throws IOException {

    	char idvalidate[]=new char[9];////validation to id-from file
    	char passvali[]=null;//validation to password- from file
    	char array[];//all the line from User.txt
    	int i=0;
    	int countid=0,countpass=0;
    	boolean found=false;
    	ConnectionStruct connection=new ConnectionStruct(0, false);
    	
		File cuurentUser = new File("User.txt");//open file User
	      Scanner myReader = new Scanner(cuurentUser);//scan the first line from User.txt
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
	        	myReader.close();
	        	i++;
	        	if(pass.equals(new String(passvali)))
		        {
	        		connection.connection=true;
	        		connection.type=new Integer(array[i])-48;
	        		return connection;
		        }
	        	else
	        	{
	        		connection.connection=false;
	        		connection.errorType=1;
	        		
	        		break;
	        	}
	        }
	      if(found==false)
	      {
	    	  connection.connection=false;
	    	  connection.errorType=2;
	      }      
	}
		return connection;

	}

public static Object findWhichTypeOfPerson(int type,String id) throws IOException {
	
	Object obj1 = null;
	
	switch(type)
	{
	case 1:
	{
		return getObjectFromFile(type,id,"Student.txt");

	}
	case 2:
	{
		return getObjectFromFile(type,id,"Tutor.txt");
	}
	case 3:
	{
		return getObjectFromFile(type,id,"Lecturer.txt");
	}
	case 4:
	{
		return getObjectFromFile(type,id,"Janitor.txt");
	}
	case 5:
	{
		return getObjectFromFile(type,id,"Secretary.txt");
	}
	case 6:
	{
		return LoginPage.getObjectFromFile(type,id,"Principle.txt");
	}
	}
	return obj1;
}



public static void replaceSelected(String replaceWith, String id,String fileName) {
    try {
        // input the file content to the StringBuffer "input"
        BufferedReader file = new BufferedReader(new FileReader(fileName));
        StringBuffer inputBuffer = new StringBuffer();
        String line;

        while ((line = file.readLine()) != null) {
            inputBuffer.append(line);
            inputBuffer.append('\n');
        }
        file.close();
        String inputStr = inputBuffer.toString();

        // logic to replace lines in the string (could use regex here to be generic)
            inputStr = inputStr.replace(line , replaceWith ); 

        // write the new string with the replaced line OVER the same file
        FileOutputStream fileOut = new FileOutputStream(fileName);
        fileOut.write(inputStr.getBytes());
        fileOut.close();

    } catch (Exception e) {
        System.out.println("Problem reading file.");
    }
}

public static int showNumberOfLines(String filename) throws IOException
{
    BufferedReader reader = new BufferedReader(new FileReader(filename));
    int lines = 0;
    while (reader.readLine() != null) lines++;
    reader.close();
    return lines;
}

public String showFile(String filename) throws IOException {
    BufferedReader file = new BufferedReader(new FileReader(filename));
    StringBuffer inputBuffer = new StringBuffer();
    String line;

    while ((line = file.readLine()) != null) {
        inputBuffer.append(line);
        inputBuffer.append('\n');
    }
    file.close();
    return inputBuffer.toString();
}

public void deleteFile(String filename) {
	
	File file = new File(filename);//open file User
	file.delete();
}

@SuppressWarnings("unused")
public void createFile(String filename) throws IOException {
	File file = new File(filename);
	file.createNewFile();
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




}
	
	
	
	
	
	



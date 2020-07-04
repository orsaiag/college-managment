package college_managment_system;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
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
		return getObjectFromFile(type,id,"Principle.txt");
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

public void createFile(String filename) throws IOException {
	File file = new File(filename);
	file.createNewFile();
}

public boolean deleteSpecificLineFromFile(String filename,String lineToRemove) throws IOException {
    File inputFile = new File(filename);
    File tempFile = new File("myTempFile.txt");

    BufferedReader reader = new BufferedReader(new FileReader(inputFile));
    BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
    int numLines=1;
    String currentLine;

    while((currentLine = reader.readLine()) != null) {
        // trim newline when comparing with lineToRemove
        String trimmedLine = currentLine.trim();
        if(trimmedLine.equals(lineToRemove)) continue;
        writer.write(numLines+"."+currentLine.substring(2) + System.getProperty("line.separator"));
        numLines++;
    }
    writer.close(); 
    reader.close(); 

   inputFile.delete();
   boolean successfulRename=tempFile.renameTo(inputFile);
   tempFile.delete();
   return successfulRename;

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


public void showSpecipicLinesFromFile(String id,String filename) throws IOException { 
	File file =new File(filename);
    Scanner in = null;
    try {
        in = new Scanner(file);
        while(in.hasNext())
        {
            String line=in.nextLine();
            if(line.contains(id))
                System.out.println(line);
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
	
}
}


public void showGrades(String id,String filename) throws IOException {
/*
 * there are no 100, only 99 and below!
 * exam is 80% from the grade and quiz is 20% from grade:
 * 1-EXAM
* 2-QUIZ

 * the course are:
1-infi1
2-algebra
3-CS
4-Java
*/
	 System.out.println("Grades and overall average:");
	 System.out.println();
	File file =new File(filename);
	char[] lineArray=new char[17];
    Scanner in = null;
    int sum=0;
    try {
        in = new Scanner(file);
        while(in.hasNext())
        {
            String line=in.nextLine();
            if(line.contains(id))
            {
            	lineArray=line.toCharArray();
            	int number1=new Integer(lineArray[14])-48;
            	int number2=new Integer(lineArray[15])-48;
            switch(lineArray[10])
            {
            case '1':
            {
            	 System.out.print("Infi1- ");
            	 break;
            }
            case '2':
            {
                 System.out.print("Algebra- ");
                 break;
            }
            case '3':
            {
            	System.out.print("CS- ");
            	break;
            }
            case'4':
            {
            	System.out.print("Java- ");
            	break;
            }
            	
            
        }
            switch(lineArray[12])
            {
            case '1':
            {
            	sum+=(number1*10+number2)*0.8;
            	System.out.println("Exam- "+number1+number2);
            	
            	break;
            }
            case '2':
            {
            	sum+=(number1*10+number2)*0.2;
            	System.out.println("Quiz- "+number1+number2);
            	break;
            }
            }
            }
        }
        System.out.println();
		 System.out.println("Over all average: "+sum);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
}
}


public void showCoursesITeachOrTutor(String id,String filename) throws IOException {//add the courses according to "course.txt"
/*
the course are:
1-infi1
2-algebra
3-CS
4-Java
*/
	 System.out.println("The courses I teach are:");
	File file =new File(filename);
	char[] lineArray=new char[12];
    Scanner in = null;
    try {
        in = new Scanner(file);
        while(in.hasNext())
        {
            String line=in.nextLine();
            if(line.contains(id))
            {
            	lineArray=line.toCharArray();
            switch(lineArray[10])
            {
            case '1':
            {
            	 System.out.println("Infi1");
            	 break;
            }
            case '2':
            {
                 System.out.println("Algebra");
                 break;
            }
            case '3':
            {
            	System.out.println("CS");
            	break;
            }
            case'4':
            {
            	System.out.println("Java");
            	break;
            }
            	
            
        }
        }
        }
        System.out.println();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
}
}


@SuppressWarnings("resource")
public int numOfCoursePerStudent(String id,String filename) throws FileNotFoundException {
	File file =new File(filename);
    Scanner in = null;
    int counter=0;
     in = new Scanner(file);
      while(in.hasNext())
        {
            String line=in.nextLine();
            if(line.contains(id))
            {
            	counter++;
            	
            }
        }
	return counter;

}


@SuppressWarnings({ "resource" })
public void showStudentPerLecturerOrTutor(String id,String filename) throws FileNotFoundException {
	/*
	the course are:
	1-infi1
	2-algebra
	3-CS
	4-Java
	*/
	 System.out.println("My student are:");
	 String StudentId;
	 File fileTeacher =new File(filename);
	File fileStudent =new File("StudentsAndCourse.txt");
	char[] lineArrayTeach=new char[10];
    Scanner in = null;
    File file =new File("Student.txt");
	Scanner inn = new Scanner(file);
	int counter=0;
   try {
	   in = new Scanner(fileTeacher);
       while(in.hasNext())
       {
           String line=in.nextLine();
           if(line.contains(id))//id of teacher
           {
        	   lineArrayTeach=line.toCharArray();
           switch(lineArrayTeach[10])
           {
           case '1':
           {
        	   counter=0;
           	 System.out.println("Infi1:");
           	inn = new Scanner(fileStudent);//open file of student and the courses 
             while(inn.hasNext())
             {
                String lineS=inn.nextLine();
                 if(lineS.contains(",1"))//if the student study the first course
                 {
                	 counter++;
                	 StudentId = lineS.substring(0, 9);
                	 Student stud=new Student( (Student) getObjectFromFile(1,StudentId,"Student.txt"));
                   	 System.out.println(stud.getName());
           }
             }
             if(counter==0)
             {
          	   System.out.println("There are no students in this course");
             }
             break;
           }

           case '2':
           {
        	   counter=0;
             	 System.out.println("Algebra:");
             	inn = new Scanner(fileStudent);//open file of student and the courses 
                while(inn.hasNext())
                {
                   String lineS=inn.nextLine();
                    if(lineS.contains(",2"))//if the student study the first course
                    {
                    	counter++;
                   	 StudentId = lineS.substring(0, 9);
                   	 Student stud=new Student( (Student) getObjectFromFile(1,StudentId,"Student.txt"));
                   	 System.out.println(stud.getName());
                    }
                 
                }
                if(counter==0)
                {
             	   System.out.println("There are no students in this course");
                }
                break;
           }
           case '3':
           {
        	   counter=0;
            	 System.out.println("CS:");
            	inn = new Scanner(fileStudent);//open file of student and the courses 
               while(inn.hasNext())
               {
                  String lineS=inn.nextLine();
                   if(lineS.contains(",3"))//if the student study the first course
                   {
                	   counter++;
                  	 StudentId = lineS.substring(0, 9);
                  	Student stud=new Student( (Student) getObjectFromFile(1,StudentId,"Student.txt"));
                  	 System.out.println(stud.getName());
                   }
               }
               if(counter==0)
               {
            	   System.out.println("There are no students in this course");
               }
               break;
          }
           case '4':
           {
        	   counter=0;
           	 System.out.println("Java:");
            inn = new Scanner(fileStudent);//open file of student and the courses 
               while(inn.hasNext())
               {
                  String lineS=inn.nextLine();
                   if(lineS.contains(",4"))//if the student study the first course
                   {
                	   counter++;
                  	 StudentId = lineS.substring(0, 9);
                  	Student stud=new Student( (Student) getObjectFromFile(1,StudentId,"Student.txt"));
                  	 System.out.println(stud.getName());
                   }
                   
               }
               if(counter==0)
               {
            	   System.out.println("There are no students in this course");
               }
               break;
          }
       }
       }
       }
       System.out.println();
       } catch (FileNotFoundException e) {
           e.printStackTrace();
}
	
}

  
public static void modifyFile(String filePath,String id, String oldString, String newString)
{
        File fileToBeModified = new File(filePath);
        String oldContent = "";
        BufferedReader reader = null;
        FileWriter writer = null;
        String newContent=null;
        try
        {
            reader = new BufferedReader(new FileReader(fileToBeModified));
            //Reading all the lines of input text file into oldContent
            String line = reader.readLine(); 
            while (line != null) 
            {
            	
            	if(line.contains(id)){
            		if(line.contains(","+oldString))
            			oldContent = oldContent + line.replace(","+oldString, ","+newString) + System.lineSeparator(); 
            		else
            			oldContent = oldContent + line + System.lineSeparator(); 
            	}
            	else
        			oldContent = oldContent + line + System.lineSeparator(); 
                line = reader.readLine();
            	
            }
            //Replacing oldString with newString in the oldContent
            newContent = oldContent.replaceFirst(oldString, newString);
            //Rewriting the input text file with newContent
            writer = new FileWriter(fileToBeModified);
            writer.write(newContent);
            System.out.println("Changed successfully");
        }
        catch (IOException e)
        {
        	System.out.println("Filed to change");
            e.printStackTrace();
        }
        finally
        {
            try
            {
                //Closing the resources
                reader.close();
                writer.close();
            } 
            catch (IOException e) 
            {
            	System.out.println("Filed to change");
                e.printStackTrace();
            }
        }
    }

public void ApproveRequests(int numberOfRequest) throws FileNotFoundException {
    File file = new File("ReqeustInformation.txt");
    File fileUderTofindType = new File("User.txt");
    File fileToModify =null;
    BufferedReader readerFile = null,readerType=null,readerFileObject=null;
    FileWriter writer = null;
    String newContent=null, id=null,oldString=null;
	int type = 0;
    String oldContent = "",filePerObject=null;
	char array[]=new char[2];
    try
    {
    	readerFile = new BufferedReader(new FileReader(file));
        //Reading all the lines of input text file into oldContent
        String line = readerFile.readLine(); 
        while (line != null) 
        {
        	if(line.contains(numberOfRequest+".")){
        		id=line.substring(2, 11);
        		readerType=new BufferedReader(new FileReader(fileUderTofindType));
        		String lineType = readerType.readLine();
                while (lineType != null) 
                {
                	if(lineType.contains(id))
                	{
                	    lineType.getChars(lineType.length()-1, lineType.length(), array, 0);
               	    	type=new Integer(array[0])-48;     
        		      break;
                	}
                	lineType=readerType.readLine();
                }
        		readerType.close();
        		switch(type)
        		{
        		case 1:
        		{
        			fileToModify= new File("Student.txt");
        			filePerObject="Student.txt";
        			break;

        		}
        		case 2:
        		{
        			fileToModify= new File("Tutor.txt");
        			filePerObject="Tutor.txt";
        			break;
        		}
        		case 3:
        		{
        			fileToModify= new File("Lecturer.txt");
        			filePerObject="Lecturer.txt";
        			break;
        		}
        		case 4:
        		{
        			fileToModify= new File("Janitor.txt");
        			filePerObject="Janitor.txt";
        			break;
        		}
        		case 5:
        		{
        			fileToModify= new File("Secretary.txt");
        			filePerObject="Secretary.txt";
        			break;
        		}
        		case 6:
        		{
        			fileToModify= new File("Principle.txt");
        			filePerObject="Principle.txt";
        			break;
        		}
        		}
            	readerFileObject = new BufferedReader(new FileReader(fileToModify));
        		String lineObjects = readerFileObject.readLine();
                while (lineObjects != null) 
                {
                	if(lineObjects.contains(id))
                	{
                		modifyFile(filePerObject,id,lineObjects,line.substring(2,line.length()-1));
                		oldContent = oldContent + lineObjects.replaceAll(lineObjects,line.substring(2,line.length())) + System.lineSeparator(); 
                		oldString=lineObjects;
                	}
                	else
                		oldContent = oldContent + lineObjects + System.lineSeparator(); 
                	lineObjects = readerFileObject.readLine();

        	}
            	readerFileObject.close();
                break;
        	}
        	line = readerFile.readLine(); 
        }
        //Replacing oldString with newString in the oldContent
       newContent = oldContent.replace(oldString, line.substring(2,line.length()));
        //Rewriting the input text file with newContent
        writer = new FileWriter(fileToModify);
        writer.write(newContent);
		deleteFile("ReqeustInformation.txt");	
    	readerFile.close();
    	writer.close();
	    deleteSpecificLineFromFile("ReqeustInformation.txt",line);		 
    }
    catch (IOException e)
    {
    	System.out.println("Filed to change");
        e.printStackTrace();
    }
	
}

@SuppressWarnings("resource")
public String showFirstNameByIDFromFile(String id,String filename) throws FileNotFoundException
{
	String studentName="";
	File file=new File(filename);
    Scanner inn = new Scanner(file);//open file of student and the courses 
    while(inn.hasNext())
    {
       String lineS=inn.nextLine();
        if(lineS.contains(id))//if the student study the first course
        {
       	 	Student stud=new Student( (Student) getObjectFromFile(1,id,"Student.txt"));
       	 	studentName=stud.getName();
        }
    }
    return studentName;
}


@SuppressWarnings("resource")
public String showCourseNameByIDFromFile(String number,String filename) throws FileNotFoundException
{
	String courseName="";
	File file=new File(filename);
    Scanner inn = new Scanner(file);//open file of student and the courses 
    while(inn.hasNext())
    {
       String lineS=inn.nextLine();
        if(lineS.contains(number+','))//if the student study the first course
        {
       	 	courseName=lineS.substring(0, lineS.length());
        }
    }
    return courseName;
}

@SuppressWarnings({ "resource" })
public void showGradesOfAllStudents(String filename) throws IOException {
	String line="",name="",studentID="",courseName="";
	int courseCounter=1,sumQ=0,sumE=0,counter=0,grade=0;
	double average=0;
	File file=new File(filename);
	Scanner in=new Scanner(file);
	for(courseCounter=1;courseCounter<showNumberOfLines("Course.txt");courseCounter++)
	{
		courseName=showCourseNameByIDFromFile(courseCounter+"","Course.txt").substring((2));
		in=new Scanner(file);
		System.out.println("Course: "+ courseName);
		sumQ=0;
		sumE=0;
		average=0;
		counter=0;
		while(in.hasNext())
		{
			line=in.nextLine();
			if(line.substring(10,11).equals(courseCounter+""))
			{
				counter++;
				studentID=line.substring(0,9);
				name=showFirstNameByIDFromFile(studentID,"Student.txt");
				System.out.print("ID: "+studentID+" ,");
				System.out.print("Name: "+name+" ,");
				grade= new Integer(line.substring(14));
				if(line.substring(12,13).equals("1"))
				{
					System.out.print("Exam ,");
					sumE+=grade;
				}
				else
				{
					System.out.print("Quiz , Grade: ");
					sumQ+=grade;
				}
				System.out.println(grade);
			}
		}
		if(counter==0)
		{
			System.out.println("Total Average is : "+0);
		}
		else 
		{
			average=(((sumE*0.8)+(sumQ*0.2))/counter);
			System.out.println("Total Average is : "+average);
		}
	}
}

//add new function of person exists

@SuppressWarnings({ "unused" })
public void addNewStuentOrWorker(int type,String id,String name, String email,String password,String address ,String dateOfBirth,int number) throws IOException
{
	if(id.length()==9 && dateOfBirth.indexOf('/', 2)==0 && dateOfBirth.indexOf('/', 5)==0)
	{
		//use the exists function
	String filename=null;
	Object obj1=null;
	User.UserBuilder u = null;
    switch(type)
	{
	case 1:
	{
		filename="Student.txt";
		u=new User.UserBuilder(id,password,"1");
		u.name(name)
		.email(email)
		.address(address)
		.email(email)
		.number(number+"")
		.build();
		break;

	}
	case 2:
	{
		filename="Tutor.txt";
		u=new User.UserBuilder(id,password,"2");
		u.name(name)
		.email(email)
		.address(address)
		.email(email)
		.number(number+"")
		.build();
		break;
	}
	case 3:
	{
		filename="Lecturer.txt";
		u=new User.UserBuilder(id,password,"3");
		u.name(name)
		.email(email)
		.address(address)
		.email(email)
		.number(number+"")
		.build();
		break;
	}
	case 4:
	{
		filename="Janitor.txt";
		u=new User.UserBuilder(id,password,"4");
		u.name(name)
		.email(email)
		.address(address)
		.email(email)
		.number(number+"")
		.build();
		break;
	}
	case 5:
	{
		filename="Secretary.txt";
		u=new User.UserBuilder(id,password,"5");
		u.name(name)
		.email(email)
		.address(address)
		.email(email)
		.number(number+"")
		.build();
		break;
	}
	case 6:
	{
		filename="Principle.txt";
		u=new User.UserBuilder(id,password,"6");
		u.name(name)
		.email(email)
		.address(address)
		.email(email)
		.number(number+"")
		.build();
		break;
	}

}
   if(u!=null) {
	System.out.println("Added successfully");
   }
   else
	   System.out.println("You can't add this type of person");
	}
	else
		  System.out.println("Worng Id or date of birth");

}


@SuppressWarnings("resource")
public void addGrade(String id, String course, String type, String grade) throws IOException {
	File file=new File("Student.txt");
	boolean student=false;
    Scanner inn = new Scanner(file);//open file of student and the courses 
    while(inn.hasNext())
    {
       String lineS=inn.nextLine();
        if(lineS.contains(id))//if the student study the first course
        {
        	student=true;
        }
    }
    if(student) {
	if(type.equals("1")) 
    	new Exam(id,course,grade);
    else
    	new Quiz(id,course,grade);
}
    else
    	System.out.println("There is no student with this id");
}





}



	
	
	
	
	
	

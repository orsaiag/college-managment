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
           	 System.out.println("Infi1:");
           	inn = new Scanner(fileStudent);//open file of student and the courses 
             while(inn.hasNext())
             {
                String lineS=inn.nextLine();
                 if(lineS.contains(",1"))//if the student study the first course
                 {
                	 StudentId = lineS.substring(0, 9);
                	 Student stud=new Student( (Student) getObjectFromFile(1,StudentId,"Student.txt"));
                   	 System.out.println(stud.getName());
             break;
           }
             }
           }

           case '2':
           {
             	 System.out.println("Algebra:");
             	inn = new Scanner(fileStudent);//open file of student and the courses 
                while(inn.hasNext())
                {
                   String lineS=inn.nextLine();
                    if(lineS.contains(",2"))//if the student study the first course
                    {
                   	 StudentId = lineS.substring(0, 9);
                   	 Student stud=new Student( (Student) getObjectFromFile(1,StudentId,"Student.txt"));
                   	 System.out.println(stud.getName());
                    }
                }
                break;
           }
           case '3':
           {
            	 System.out.println("CS:");
            	inn = new Scanner(fileStudent);//open file of student and the courses 
               while(inn.hasNext())
               {
                  String lineS=inn.nextLine();
                   if(lineS.contains(",3"))//if the student study the first course
                   {
                  	 StudentId = lineS.substring(0, 9);
                  	Student stud=new Student( (Student) getObjectFromFile(1,StudentId,"Student.txt"));
                  	 System.out.println(stud.getName());
                   }
               }
               break;
          }
           case '4':
           {
           	 System.out.println("Java:");
            inn = new Scanner(fileStudent);//open file of student and the courses 
               while(inn.hasNext())
               {
                  String lineS=inn.nextLine();
                   if(lineS.contains(",4"))//if the student study the first course
                   {
                  	 StudentId = lineS.substring(0, 9);
                  	Student stud=new Student( (Student) getObjectFromFile(1,StudentId,"Student.txt"));
                  	 System.out.println(stud.getName());
                   }
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
}



	
	
	
	
	
	

package college_managment_system;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class User {

    //All final attributes
    private final String name; // optional
    private final String id; // required
    private final String dateOfBirth; // optional
    private final String email; // optional
    private final String address; // optional
	private final String number; // optional
	private final String password; // required
	private final String type;// required
 
    private User(UserBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.dateOfBirth = builder.dateOfBirth;
        this.email = builder.email;
        this.address = builder.address;
        this.number=builder.number;
        this.password=builder.password;
        this.type=builder.type;
        
    }
 


	//All getter, and NO setter to provde immutability
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getdateOfBirth() {
        return dateOfBirth;
    }
    public String getEmail() {
        return email;
    }
    public String getAddress() {
        return address;
    }
    
    public String getNumber() {
        return number;
    }
    public String getPassword() {
        return password;
    }
    public String getType() {
        return type;
    }
    
 
    @Override
    public String toString() {
        return this.id+","+this.name+","+this.email+","+this.address+","+this.dateOfBirth+","+this.password+","+this.number+",\n";
    }
    
    
    
    public static class UserBuilder {

		private final String id;
        private final String password;
        private final String type;
        private String dateOfBirth;
        private String email;
        private String address;
    	private String number;
    	private String name;

        public UserBuilder(String id, String password,String type) {
            this.id = id;
            this.password = password;
            this.type = type;
        }
        public UserBuilder dateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }
        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }
        public UserBuilder address(String address) {
            this.address = address;
            return this;
        }
        
        public UserBuilder number(String number) {
            this.number = number;
            return this;
        }
        
        public UserBuilder name(String name) {
            this.name = name;
            return this;
        }
        
        
        //Return the finally consrcuted User object
        public User build() throws IOException {
            User user =  new User(this);
            String filename=null;
            if(validateUserObject(user).connection==true)
            {
            	//use the model function to check if exists
            	System.out.println("already exists with this id");
            	return user;
            }
            else
            {
            	switch(user.getType())
            	{
            	case "1":
            	{
            		filename="Student.txt";
            		break;

            	}
            	case "2":
            	{
            		filename="Tutor.txt";
            		break;
            	}
            	case "3":
            	{
            		filename="Lecturer.txt";
            		break;
            	}
            	case"4":
            	{
            		filename="Janitor.txt";
            		break;
            	}
            	case "5":
            	{
            		filename="Secretary.txt";
            		break;
            	}
            	case "6":
            	{
            		filename="Principle.txt";
            		break;
            	}

            }
            	 BufferedWriter output = new BufferedWriter(new FileWriter(filename,true));
            	 output.append(user+"");
            	 output.close();
            	 BufferedWriter u = new BufferedWriter(new FileWriter("User.txt",true)); 
            	 u.append(user.getId()+","+user.getPassword()+","+user.getType()+"\n");
            	 u.close();
            	return user;
            }
        }
        
        
        private ConnectionStruct validateUserObject(User user) throws IOException {
        	return Controller.controllerLogin(user.getId(),user.getPassword());
	
        }
}
    

}
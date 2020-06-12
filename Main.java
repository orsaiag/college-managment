package college_managment_system;

public class Main {

	//public static void main(String[] args) {
		Lecturer l=new Lecturer("313562779","or","ithak sada 33 bat yam","orsaiag1@gmail.com","23/5/1995",6000);
		l.showPersonalInformation();
		System.out.println();
		System.out.println(l.sendRequestChangeDetails("3", "or saiag","ithak sada 33 bat yam","orsaiag1@gmail.com"));
		l.showPersonalInformation();
		System.out.println();
		System.out.println(l.sendRequestChangeDetails("313562779", "or saiag","ithak sada 33 bat yam","orsaiag1@gmail.com"));
		l.showPersonalInformation();
		
		
		
		//Student student=Student.builder()
				
		
	}

}

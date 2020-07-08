package college_managment_system;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ControllerTest {



	private Controller controllerTest;

	
	@Before
	public void setUpMethod() {
		System.out.println("setUp");
		controllerTest = new Controller();
	}
	

	@After
	public void tearDownMethod() {
		System.out.println("tearDownMethod");
		controllerTest = new Controller();
	}


	@SuppressWarnings({ "static-access" })
	@Test
	public void login() throws IOException {
		System.out.println("loginTest");
		Assert.assertTrue(controllerTest.controllerLogin("333333333", "3333").connection);//OK id and password
		Assert.assertFalse(controllerTest.controllerLogin("112222222", "1111").connection);//id not exists
		Assert.assertFalse(controllerTest.controllerLogin("111111111", "111").connection);//wrong password
	}
	
	 @SuppressWarnings({ "static-access"})
	@Test
	public void addGrade() throws IOException {
		System.out.println("ADD GRADE");
        Assert.assertNotNull("Not Null", controllerTest.controllerAddGrade("122", "1", "1", "99"));//wrong id
		Assert.assertSame("ok",true,controllerTest.controllerAddGrade("123456789", "1", "1", "99"));//added successfully
		Assert.assertNotSame("ok",false, controllerTest.controllerAddGrade("987654321", "1", "1", "70"));//added successfully
        Assert.assertNotSame("not Success",true, controllerTest.controllerAddGrade("123456789", "1", "1", "200"));//wrong grade
		Assert.assertSame("not Success",false,Controller.controllerAddGrade("123456789", "1","2","-90"));//wrong grade
	}
	
	@Test
	public void addNewPerson() throws IOException {
		System.out.println("ADD New Person");
		//wrong id
		Assert.assertFalse(Controller.controllerAddNewStuentOrWorker(1, "122", "test", "testvjcj", "1221", "gfgdgd", "11/11/1111", 2000));
		//wrong date
		Assert.assertFalse(Controller.controllerAddNewStuentOrWorker(1, "122222222", "test", "testvjcj", "1221", "gfgdgd", "11", 2000));
		//wrong type of person-singelton
		Assert.assertFalse(Controller.controllerAddNewStuentOrWorker(5, "112222222", "test", "testvjcj", "1221", "gfgdgd", "11/11/1111", 2000));
		//Okay
		Assert.assertTrue(Controller.controllerAddNewStuentOrWorker(3, "111112311", "test", "testvjcj", "1221", "gfgdgd", "11/11/1111", 2000));

	}
	
	@SuppressWarnings("static-access")
	@Test
	public void CheckIfObjectExists() throws IOException {
	System.out.println("check person");
	Assertions.assertThrows(FileNotFoundException.class,()->{
		controllerTest.controllerCheckIfObjectExists("111111111","Janito.txt");
	});
	Assertions.assertDoesNotThrow(()->{
		boolean result=controllerTest.controllerCheckIfObjectExists("123456789","Student.txt");
		Assertions.assertTrue(result);
	});
	}
	

	public static void main(String[] args) throws IOException {


	}

}

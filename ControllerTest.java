package college_managment_system;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class ControllerTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}
	/**
	 * In case of method setup
	 */
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


	@SuppressWarnings({ "static-access", "null" })
	@Test
	public void login() throws IOException {
		System.out.println("loginTest");
		ConnectionStruct connection=null;
		connection.connection=true;
		connection.type=5;
		Assert.assertSame("Success",connection, controllerTest.controllerLogin("333333333", "3333"));	
		connection.connection=false;
		Assert.assertSame("not Success",connection, controllerTest.controllerLogin("112222222", "1111"));
		Assert.assertSame("not Success",connection, controllerTest.controllerLogin("11", "1"));
		connection.type=1;
		connection.connection=true;
		Assert.assertSame("Success",connection, controllerTest.controllerLogin("123456789", "1234"));
	}
	

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws IOException {
		Controller controllerT = new Controller();
		System.out.println(controllerT.controllerLogin("333333333", "3333"));
		System.out.println(controllerT.controllerLogin("222222", "3333"));
		System.out.println(controllerT.controllerLogin("11", "1"));
		
		


	}

}

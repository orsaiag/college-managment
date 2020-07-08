package college_managment_system;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Controller {

	static Model modelLogin = new Model();

	public static ConnectionStruct controllerLogin(String id, String pass) throws IOException {
		ConnectionStruct answer = Model.modelLogin(id, pass);
		return answer;
	}

	@SuppressWarnings("static-access")
	public static void controllerConnection(String id, ConnectionStruct connected) throws IOException, CloneNotSupportedException {
		Object obj1 = modelLogin.findWhichTypeOfPerson(connected.type, id);
		switch (connected.type) {
		case 1: {
			View.viewStudent((Student) obj1);
			break;

		}
		case 2: {
			View.viewTutor((Tutor) obj1);
			break;
		}
		case 3: {
			View.viewLecturer((Lecturer) obj1);
			break;
		}
		case 4: {
			View.viewJanitor((Janitor) obj1);
			break;
		}
		case 5: {
			View.viewSecratery((Secratery) obj1);
			break;
		}
		case 6: {
			View.viewPrinciple((Principal) obj1);
			break;
		}

		}
	}

	@SuppressWarnings("static-access")
	public static String controllerSecratery(String filename, String id, String oldString, String newString) {
		return modelLogin.modifyFile(filename, id, oldString, newString);
	}

	@SuppressWarnings("static-access")
	public static int controllerSecrateryShowNumberOfRequests(String filename) throws IOException {
		return modelLogin.showNumberOfLines(filename);
	}

	public static String controllerSecrateryShowRequestsToApprove(String filename) throws IOException {
		return modelLogin.showFile(filename);
	}

	public static void controllerSecrateryDenieRequests(String filename) throws IOException {
		modelLogin.deleteFile(filename);
		modelLogin.createFile(filename);

	}

	public static String controllerShowSpecipicLinesFromFile(String id, String filename) throws IOException {
		return modelLogin.showSpecipicLinesFromFile(id, filename);
	}

	public static String controllerViewGrades(String id, String filename) throws IOException {
		return modelLogin.showGrades(id, filename);

	}



	public static int numOfCoursePerStudent(String id, String filename) throws FileNotFoundException {
		return modelLogin.numOfCoursePerStudent(id, filename);

	}

	public static String controllershowStudentPerLecturerOrTutor(String id, String filename)
			throws FileNotFoundException {
		return modelLogin.showStudentPerLecturerOrTutor(id, filename);

	}

	@SuppressWarnings("static-access")
	public static String controllerChaneGrades(String id, String oldGrade, String newGrade) throws IOException {
		return modelLogin.modifyFile("Grades.txt", id, oldGrade, newGrade);
	}

	public static void controllerSecrateryApproveRequests(int numberOfRequest) throws IOException {
		modelLogin.ApproveRequests(numberOfRequest);
	}

	@SuppressWarnings("static-access")
	public static void controllerChangeNumberOfCoursesForStudent(String id, String oldString, String newString)
			throws IOException {
		modelLogin.modifyFile("Student.txt", id, oldString, newString);
	}

	@SuppressWarnings("static-access")
	public static int controllerShowLine(String filename) throws IOException {
		return modelLogin.showNumberOfLines(filename);
	}

	public static String controllerShowGradesOfAllStudents(String filename) throws IOException {
		return modelLogin.showGradesOfAllStudents(filename);
	}

	public static boolean controllerAddNewStuentOrWorker(int type, String id, String name, String email,
			String password, String address, String dateOfBirth, int number) throws IOException {
		return modelLogin.addNewStuentOrWorker(type, id, name, email, password, address, dateOfBirth, number);
	}

	public static boolean controllerAddGrade(String id, String course, String type, String grade) throws IOException {
		return modelLogin.addGrade(id, course, type, grade);

	}

	public static boolean controllerCheckIfObjectExists(String id, String filename) throws FileNotFoundException {
		return modelLogin.checkIfObjectExists(id, filename);

	}

	@SuppressWarnings("static-access")
	public static Student collegeGetObjectFromFile(int i, String string, String string2) {
		// TODO Auto-generated method stub
		return (Student) modelLogin.getObjectFromFile(i, string, string2);
	}

}

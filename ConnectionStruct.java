package college_managment_system;

public class ConnectionStruct {

	int type;
	boolean connection;
	int errorType=1;
	
	
	public ConnectionStruct(int type,boolean connection) {
		this.connection=connection;
		this.type=type;
	
	}
	
	public int getErrorType() {
		return errorType;
	}

	public void setErrorType(int errorType) {
		this.errorType = errorType;
	}

	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public boolean isConnection() {
		return connection;
	}
	public void setConnection(boolean connection) {
		this.connection = connection;
	}

}

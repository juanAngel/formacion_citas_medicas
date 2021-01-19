package me.formacion.mock;

public class DBMock {
	private static DBMock instance;
	private DBMock() {
		// TODO Auto-generated constructor stub
	}
	public static DBMock getInstance() {
		if(instance == null)
			instance = new DBMock();
		return instance;
	}

}

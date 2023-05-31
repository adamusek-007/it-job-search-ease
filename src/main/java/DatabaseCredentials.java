package main.java;

public class DatabaseCredentials {

	public static final String userName = "root";
	public static final String userPassword = "";
	public static final String dbName = "job_offers";
	protected static String dbAddr = "localhost";
	protected static String dbPort = "3306";
	protected static final String dbURL = "jdbc:mysql://" + dbAddr + ":" + dbPort + "/" + dbName;

}

package main.java;

public class DatabaseCredentials {

	public static final String userName = "root";
	public static final String userPassword = "";
	public static final String dbName = "job_offers";
	private static String dbAddr = "localhost";
	private static String dbPort = "3306";
	public static final String dbURL = "jdbc:mysql://" + dbAddr + ":" + dbPort + "/" + dbName;

}

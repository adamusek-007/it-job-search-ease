package main.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseOperator {

	private static String databaseUserName = "root";
	private static String databasePassword = "";
	private static String databaseName = "job_offers";
	private static String databaseURL = "jdbc:mysql://localhost:3306/" + databaseName;

	static Connection databaseConnection = null;
	
	protected static ResultSet companiesWebsites = null;

//	public static void loopOverResultAndPrint(ResultSet sqlQueryResult) {
//		try {
//			while (sqlQueryResult.next()) {
//				String oneRowData = "";
//				for (int i = 1; i <= 1; i++) {
//					oneRowData += sqlQueryResult.getString(i);
//				}
//				System.out.println(oneRowData);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	public static ResultSet executeQueryWithReturn(String query) {
		try {
			Statement sqlStatment;
			sqlStatment = databaseConnection.createStatement();
			return sqlStatment.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void executeQuery(String query) {
		try {
			Statement sqlStatment;
			sqlStatment = DatabaseOperator.databaseConnection.createStatement();
			ResultSet sqlQueryResult;
			sqlQueryResult = sqlStatment.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void getBoardsDataFromDatabase() {
		companiesWebsites = executeQueryWithReturn("SELECT `job_board_name`, `job_board_link` FROM `job_boards_info`");
	}

	public static void checkIsDriverInstalled() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public static void setUpConnectionWithDatabase() {
		try {
			databaseConnection = DriverManager.getConnection(databaseURL, databaseUserName,
					databasePassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
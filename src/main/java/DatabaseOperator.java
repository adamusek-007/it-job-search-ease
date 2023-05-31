package main.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.HashMap;

public class DatabaseOperator {

	static Connection databaseConnection = null;
	protected static ResultSet companiesWebsites = null;
	protected static Map<String, String> jobBoardsData = new HashMap<>();

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
		ResultSet companiesWebsites = executeQueryWithReturn(
				"SELECT `job_board_name`, `job_board_link` FROM `job_boards_info`");

		try {
			while (companiesWebsites.next()) {
				String jobBoardName = companiesWebsites.getString("job_board_name");
				String jobBoardWebsite = companiesWebsites.getString("job_board_link");
				jobBoardsData.put(jobBoardName, jobBoardWebsite);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		DatabaseCredentials dbCredentials = new DatabaseCredentials();
		try {
			databaseConnection = DriverManager.getConnection(dbCredentials.dbURL, dbCredentials.userName,
					dbCredentials.userPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
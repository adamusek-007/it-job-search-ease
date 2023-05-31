package main.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DatabaseOperator {

	private static Connection databaseConnection = null;
	protected static ResultSet companiesWebsites = null;
	
//	Export this shit to JobBoard Class
	protected static Map<String, String> jobBoardsData = new HashMap<>();
	protected static Set<String> jobBoardsNames = jobBoardsData.keySet();

	// TODO Refactor this fn
	public static void getBoardsDataFromDatabase() {
		ResultSet companiesWebsites = executeQueryWithResultReturn(
				"SELECT `job_board_name`, `job_board_link`, `job_board_instructions` FROM `job_boards_info`");

		try {
			while (companiesWebsites.next()) {
				String jobBoardName = companiesWebsites.getString("job_board_name");
				String jobBoardWebsite = companiesWebsites.getString("job_board_link");
				jobBoardsData.put(jobBoardName, jobBoardWebsite);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(3);
		}
	}

	public static ResultSet executeQueryWithResultReturn(String query) {
		try {
			Statement sqlStatment;
			sqlStatment = databaseConnection.createStatement();
			return sqlStatment.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(4);
		}
		return null;
	}

	public static void executeQuery(String query) {
		try {
			Statement sqlStatment;
			sqlStatment = DatabaseOperator.databaseConnection.createStatement();
			sqlStatment.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(5);
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
		try {
			databaseConnection = DriverManager.getConnection(DatabaseCredentials.dbURL, DatabaseCredentials.userName,
					DatabaseCredentials.userPassword);
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(2);
		}
	}

}
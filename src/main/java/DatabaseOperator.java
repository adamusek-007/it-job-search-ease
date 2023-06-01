package main.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DatabaseOperator {

	private static Connection databaseConnection = null;
	protected static ResultSet companiesWebsites = null;

//	Export this shit to JobBoard Class
//	protected static Map<String, String> jobBoardsData = new HashMap<>();
//	protected static Set<String> jobBoardsNames = jobBoardsData.keySet();

	public static ArrayList<JobBoard> getBoardsDataFromDatabase() {
		String boardsSelectingQuery = "SELECT * FROM `job_boards_info`";
		ResultSet companiesWebsites = executeQueryReturn(boardsSelectingQuery);
		ArrayList<JobBoard> boardsData = new ArrayList<>();
		try {
			while (companiesWebsites.next()) {
				String name = companiesWebsites.getString("job_board_name");
				String link = companiesWebsites.getString("job_board_link");
				String id = companiesWebsites.getString("job_board_id");
				String instructions = companiesWebsites.getString("job_board_instructions");
				int idInt = Integer.valueOf(id);
				JobBoard board = new JobBoard(idInt, name, link, instructions);
				boardsData.add(board);
			}
			return boardsData;
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(3);
		}
		return null;
	}

	public static ResultSet executeQueryReturn(String query) {
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
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
	private static ResultSet jobBoards = null;

	public static ArrayList<JobBoard> getBoardsDataFromDatabase() {
		String boardsSelectingQuery = "SELECT * FROM `job_boards_info`";
		jobBoards = executeQueryReturn(boardsSelectingQuery);
		ArrayList<JobBoard> boardsData = new ArrayList<>();
		try {
			return getArrayListOfBoards(boardsData);
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(3);
		}
		return null;
	}

	private static ArrayList<JobBoard> getArrayListOfBoards(ArrayList<JobBoard> boardsData)
			throws SQLException {
		while (jobBoards.next()) {
			int id;
			String  name, link, instructions;
			id = jobBoards.getInt("job_board_id");
			name = jobBoards.getString("job_board_name");
			link = jobBoards.getString("job_board_link");
			instructions = jobBoards.getString("job_board_instructions");
			JobBoard board = new JobBoard(id, name, link, instructions);
			boardsData.add(board);
		}
		return boardsData;
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
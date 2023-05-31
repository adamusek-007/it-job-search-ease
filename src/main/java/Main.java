package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		DatabaseOperator.checkIsDriverInstalled();
		DatabaseOperator.setUpConnectionWithDatabase();
		ArrayList<Object> jobsBoardsList = new ArrayList<>();
		jobsBoardsList = DatabaseOperator.getBoardsDataFromDatabase();
		
		
//		jobsBoardsList.add(new JobBoard());
//		TODO - WTF here down
//		Set<String> jobBoardsNames = DatabaseOperator.jobBoardsNames;
//		for (String jobBoardName : jobBoardsNames) {
//			System.out.println(jobBoardName);
//		}

//		try {
//			ResultSet companies = DatabaseOperator.companiesWebsites;
//			Main.webDriver = createWebDriver();
//			while (companies.next()) {
//				String jobBoardName = companies.getString("job_board_name");
//				String jobBoardLink = companies.getString("job_board_link");
//				System.out.println("Skanowanie: " + jobBoardName);
////				openWebsite(webDriver, jobBoardLink, "visible");
////				openWebsite(webDriver, jobBoardLink, "must-proceed-searching");
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		Main.webDriver.close();
	}

}

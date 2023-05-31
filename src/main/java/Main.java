package main.java;

import java.util.Set;


public class Main {

	public static void main(String[] args) {
		DatabaseOperator.checkIsDriverInstalled();
		DatabaseOperator.setUpConnectionWithDatabase();
		DatabaseOperator.getBoardsDataFromDatabase();
		
		Set<String> jobBoardsNames = DatabaseOperator.jobBoardsData.keySet();

		for (String j : jobBoardsNames) {
			System.out.println(j);
		}

//		try {
//			ResultSet companies = DatabaseOperator.companiesWebsites;
//			Main.webDriver = createWebDriver();
//			while (companies.next()) {
//				String jobBoardName = companies.getString("job_board_name");
//				String jobBoardLink = companies.getString("job_board_link");
//				System.out.println("Skanowanie: " + jobBoardName);
////				TODO
////				openWebsite(webDriver, jobBoardLink, "visible");
////				openWebsite(webDriver, jobBoardLink, "must-proceed-searching");
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		Main.webDriver.close();
	}

}

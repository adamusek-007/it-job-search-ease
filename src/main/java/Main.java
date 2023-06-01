package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Main {

	public static void main(String[] args) {
		DatabaseOperator.checkIsDriverInstalled();
		DatabaseOperator.setUpConnectionWithDatabase();
		ArrayList<JobBoard> jobsBoardsList = new ArrayList<>();

		jobsBoardsList = DatabaseOperator.getBoardsDataFromDatabase();
		if (jobsBoardsList.size() > 0) {
			MyWebDriverOperator.createWebDriver();
			for (int i = 0; i < jobsBoardsList.size(); i++) {
				JobBoard jobBoard = jobsBoardsList.get(i);
				ArrayList<Job> jobsList = openJobBoard(jobBoard);
			}
		}
		MyWebDriverOperator.closeWebDriver();
	}

	private static ArrayList<Job> openJobBoard(JobBoard jobBoard) {
		WebDriver webDriver = MyWebDriverOperator.driver;
		String link = jobBoard.link;
		List<String> procedures = jobBoard.instructionsToExecute;
		webDriver.get(link);
		for (int i = 0; i < procedures.size(); i = i + 2) {
			String step = procedures.get(i);
			String path = procedures.get(i + 1);
			WebElement elementToBeProceeded = webDriver.findElement(By.xpath(path));
			switch (step) {
			case "click":
				elementToBeProceeded.click();
				break;
			case "typeIn":
				elementToBeProceeded.sendKeys(null);
				break;
			case "scan":
				ArrayList<Job> jobList = findJobs();
			}
		}
		return null;
	}

	private static ArrayList<Job> findJobs() {
		// TODO Auto-generated method stub
		return null;
	}

}

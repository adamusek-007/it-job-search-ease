package main.java;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Main {

	private static WebDriver webDriver;

	public static void main(String[] args) {
		DatabaseOperator.checkIsDriverInstalled();
		DatabaseOperator.setUpConnectionWithDatabase();
		DatabaseOperator.getBoardsDataFromDatabase();
		
		try {
			ResultSet companies = DatabaseOperator.companiesWebsites;
			Main.webDriver = createWebDriver();
			while (companies.next()) {
				String jobBoardName = companies.getString("job_board_name");
				String jobBoardLink = companies.getString("job_board_link");
				System.out.println("Skanowanie: " + jobBoardName);
				openWebsite(webDriver, jobBoardLink, "visible");
				openWebsite(webDriver, jobBoardLink, "must-proceed-searching");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

//		1. Get job boards 
//		2. Open the board job
//		3. Look for the searching phrase
//		4. Get the jobs details
//		if(job !exists) {
//			5. Insert into db
//		}
		
		
		Main.webDriver.close();
	}

	private static void openWebsite(WebDriver driver, String link) {

		driver.get(link);
		String path = "//div[@class='jobs']//child::div[contains(@class,'jobs__wrapper')]/child::div";

		List<WebElement> listOfJobs = driver.findElements(By.xpath(path));
		path = "//div[@class='jobs']//child::div[contains(@class,'jobs__wrapper')]/child::div[:number:]";
		int jobCount = listOfJobs.size();

		for (int i = 1; i <= jobCount; i++) {
			String jobTitle, jobTechStack, jobEarning, jobLocalisation, jobLink;

			String iteratorStr = String.valueOf(i);
			String fullxPath = path.replaceAll(":number:", iteratorStr);

			String xPathToJobTitle = fullxPath + "/child::div//child::h4";
			String xPathToJobTechStack = fullxPath + "//child::li[@class='technology']/span";
			String xPathToJobLocalisation = fullxPath + "//child::li[@class='location']/span";
			String xPathToJobEarning = fullxPath + "//child::li[@class='price'][2]/span";
			String xPathToJobLink = fullxPath + "/child::div/child::a";

			jobTitle = find(xPathToJobTitle, "");
			jobTechStack = find(xPathToJobTechStack, "");
			jobLocalisation = find(xPathToJobLocalisation, "");
			jobEarning = find(xPathToJobEarning, "");
			jobLink = find(xPathToJobLink, "");
			
			String[] jobStuff = new String[] {jobTitle, jobTechStack, jobLocalisation, jobEarning, jobLink};
			
			for (String wtf : jobStuff) {
				System.out.println(wtf);
			}
		}
	}

	public static String find(String any, String type) {
		WebDriver driver = Main.webDriver;
		if (type == "attr:title") {
			return driver.findElement(By.xpath(any)).getAttribute("title");
		} else if (type == "attr:href") {
			return driver.findElement(By.xpath(any)).getAttribute("href");
		} else {
			return driver.findElement(By.xpath(any)).getText();
		}
	}

	private static WebDriver createWebDriver() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("enable-automation");
		options.addArguments("--headless");
		options.addArguments("--window-size=1920,1080");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-extensions");
		options.addArguments("--dns-prefetch-disable");
		options.addArguments("--disable-gpu");
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chrome-driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		return driver;
	}
}

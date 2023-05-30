package main.java;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
	
	private static WebDriver webDriver;

	public static void main(String[] args) {
		Main.webDriver = createWebDriver();
		openWebsite(webDriver);
		Main.webDriver.close();
	}

	private static void openWebsite(WebDriver driver) {
		driver.get("https://www.rst.software/join-us");
		
		String path = "//div[@class='jobs']//child::div[contains(@class,'jobs__wrapper')]/child::div";
		List<WebElement> listOfJobs = driver.findElements(By.xpath(path));
		
		int jobCount = listOfJobs.size();
		for (int i = 1; i >= jobCount; i++) {
			String jobTitle, jobTechStack, jobEarning, localisation;
			jobTitle = find(path + i + "/child::div//child::h4", "");
			jobTitle = driver.findElement(By.xpath(path + i + "/child::div//child::h4")).getText();
			jobTechStack = driver.findElement(By.xpath(path + i + "//ul/li[@class='technology']")).getText();
		}

	}

	public static String find(String any, String type) {
		WebDriver driver = Main.webDriver;
		if(type == "attr:title") {
			return driver.findElement(By.xpath(any)).getAttribute("title");
		}else {
			return driver.findElement(By.xpath(any)).getText();
		}
	}

	private static WebDriver createWebDriver() {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chrome-driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}
}

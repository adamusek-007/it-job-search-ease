package test.java;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.ArrayList;

import main.java.JobBoard;

public class TestJobBoardObject {
	
	JobBoard jobBoard = new JobBoard(1, "website.com", "https://website.com", "click`//div[@id='root']/div[1]//child::button//span[contains(text(),'More filters')]/parent::button;click`//div[@role='presentation']//child::div[contains(@style,'opacity: 1')]//child::div[contains(text(),'Seniority')]/following-sibling::div[1]//child::span[contains(text(),'Junior')]/parent::button;click`//div[@role='presentation']//child::div[contains(@style,'opacity: 1')]//child::span[contains(text(),'Show offers')]/parent::a;");

	@Test
	public void testId() {
		assertEquals(jobBoard.id,1);
	}
	
	@Test
	public void testName() {
		assertEquals(jobBoard.name, "website.com");
	}
	
	@Test 
	public void testWebsite() {
		assertEquals(jobBoard.link, "https://website.com");
	}
	
	@Test
	public void testInstructions() {
		List<String> supossedList = new ArrayList<>();
		supossedList.add("click`//div[@id='root']/div[1]//child::button//span[contains(text(),'More filters')]/parent::button");
		supossedList.add("click`//div[@role='presentation']//child::div[contains(@style,'opacity: 1')]//child::div[contains(text(),'Seniority')]/following-sibling::div[1]//child::span[contains(text(),'Junior')]/parent::button");
		supossedList.add("click`//div[@role='presentation']//child::div[contains(@style,'opacity: 1')]//child::span[contains(text(),'Show offers')]/parent::a");
		assertEquals(jobBoard.instructionsToExecute, supossedList);
	}

}

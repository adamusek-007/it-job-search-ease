package main.java;

import java.util.ArrayList;
import java.util.List;

public class JobBoard {

	public int id;
	public String name = "";
	public String link = "";
	public List<String> instructionsToExecute;

	public JobBoard(int id, String name, String link, String instructions) {
		this.id = id;
		this.name = name;
		this.link = link;
		this.instructionsToExecute = createListOfInstructions(instructions);
	}

	private List<String> createListOfInstructions(String instructions) {
		List<String> instructionsList = new ArrayList<>();
		String[] arrayOfInstructions;
		if (instructions != null) {
			if (instructions.contains(";")) {
				arrayOfInstructions = instructions.split(";");
				for (String instruction : arrayOfInstructions) {
					instructionsList.add(instruction);
				}
			}
		}
		return instructionsList;
	}
}

package main.java;

public class Job {
	String title;
	String[] techStack;
	String earnings;
	String localisation;
	String link;
	String company;
	String boardId;

	public void setJobTitle(String jobTitle) {
		title = jobTitle;
	}

	public void setJobTechStack(String[] arrayWithTechStack) {
		techStack = arrayWithTechStack;
	}

	public void setJobEarnings(String jobEarnings) {
		earnings = jobEarnings;
	}

	public void setJobLocalisation(String jobLocal) {
		localisation = jobLocal;
	}

	public void setJobLink(String jobLink) {
		link = jobLink;
	}

	public void setJobCompany(String jobCompany) {
		company = jobCompany;
	}

	public void setJobBoardId(String id) {
		boardId = id;
	}

}

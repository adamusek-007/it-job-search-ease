package main.java;

public class Job {

	private String title;
	private String[] techStack;
	private String earnings;
	private String localisation;
	private String link;
	private String company;
	private String boardId;

	public String getJobTitle() {
		return this.title;
	}

	public String[] getTechStack() {
		return techStack;
	}

	public String getEarnings() {
		return earnings;
	}

	public String getLocalisation() {
		return localisation;
	}

	public String getLink() {
		return link;
	}

	public String getCompany() {
		return company;
	}

	public String getBoardId() {
		return boardId;
	}

	public void setJobTitle(String jobTitle) {
		this.title = jobTitle;
	}

	public void setJobTechStack(String[] arrayWithTechStack) {
		this.techStack = arrayWithTechStack;
	}

	public void setJobEarnings(String jobEarnings) {
		this.earnings = jobEarnings;
	}

	public void setJobLocalisation(String jobLocal) {
		this.localisation = jobLocal;
	}

	public void setJobLink(String jobLink) {
		this.link = jobLink;
	}

	public void setJobCompany(String jobCompany) {
		this.company = jobCompany;
	}

	public void setJobBoardId(String id) {
		this.boardId = id;
	}

}

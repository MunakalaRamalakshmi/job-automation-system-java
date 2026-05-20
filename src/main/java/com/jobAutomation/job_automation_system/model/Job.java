package com.jobAutomation.job_automation_system.model;

public class Job {

	private String title;
	private String description;
	private String url;
	
	
	public Job(String title, String description, String url) {
		this.title=	title;
		this.description = description;
		this.url = url;
	}


	public String getUrl() {
		return url;
	}

	

	public String getTitle() {return title; }
	public String getDescription() {return description;}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
}

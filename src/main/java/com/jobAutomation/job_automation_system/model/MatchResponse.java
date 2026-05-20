package com.jobAutomation.job_automation_system.model;

public class MatchResponse {
	private int score;
	private String recommendation;
	
	public MatchResponse(int score) {
		this.score = score;
		
		if (score>=80) {
			this.recommendation = "Strong Match - Apply Immediately";
			
		}else if (score>=50) {
			this.recommendation = "Moderate Match - Review Job";
		}
		else {
			this.recommendation = "Low Match - Skip";
		}
	}
	
	public int getScore() {
		return score;
	}
	
	public String getRecommendation() {
		return recommendation;
	}

}

package com.jobAutomation.job_automation_system.service;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class JobMatcherService {
	private final Map<String, Integer> skillWeights = Map.of(
			"java", 30,
			"selenium", 30,
			"api", 20,
			"sql", 20
			
			);
			
			
			
	
	
	
	public int calculateMatchScore(String jobDescription) {
		if (jobDescription == null || jobDescription.isEmpty()) { 
			return 0;
		}
	
	
	int score = 0;

	//private String jobDescription;
	
	String text = jobDescription.toLowerCase();
	
	for (Map.Entry<String, Integer> entry : skillWeights.entrySet() ) {
		if (text.contains(entry.getKey())) {
			score += entry.getValue(); // equal weight destribution
			
		}
		
	}
	return Math.min(score, 100);
	
}}

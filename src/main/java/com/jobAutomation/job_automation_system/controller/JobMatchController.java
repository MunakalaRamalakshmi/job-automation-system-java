package com.jobAutomation.job_automation_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobAutomation.job_automation_system.model.MatchResponse;
import com.jobAutomation.job_automation_system.service.JobMatcherService;

@RestController
@RequestMapping("/match")
public class JobMatchController {
	
	@Autowired
	private JobMatcherService matcherService;
	
	@PostMapping
	public int getMatchScore(@RequestBody String jobDescription) {
		return matcherService.calculateMatchScore(jobDescription);
		
	}
	
	
	@PostMapping("/v2")
	public MatchResponse getMatch(@RequestBody String jobDescription) {
		int score = matcherService.calculateMatchScore(jobDescription);
		
		return  new MatchResponse(score);
	}

}

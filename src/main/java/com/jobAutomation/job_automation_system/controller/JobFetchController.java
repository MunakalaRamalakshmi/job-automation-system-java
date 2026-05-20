package com.jobAutomation.job_automation_system.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobAutomation.job_automation_system.model.Job;
import com.jobAutomation.job_automation_system.service.JobFetcherService;
import com.jobAutomation.job_automation_system.service.JobMatcherService;
import com.jobAutomation.job_automation_system.service.SeleniumJobParserService;

@RestController
public class JobFetchController {

	@Autowired
	private JobFetcherService fetcherService;
	
	@Autowired
	private SeleniumJobParserService parserService;
	@Autowired
	private JobMatcherService matcherService;
	
	
	@GetMapping ("/fetch-jobs")
	public List<String > fetchJobs() throws IOException{
		return fetcherService.fetchJobLinks();
	}
	
	
	   
    @GetMapping("/scan-jobs")
    public void scanJobs() throws Exception {
    	List<String> links = fetcherService.fetchJobLinks();
    	for(String link:links) {
    		Job job = parserService.parseJob(link);
    		
    		int score = matcherService.calculateMatchScore(job.getDescription());
    		
    		System.out.println("-------------------------------");
    		System.out.println("Title: "+ job.getTitle());
    		
    		System.out.println("\nDescription: ");
    		
    		System.out.println(
    				job.getDescription()
    				.substring(0, Math.min(500, job.getDescription().length()))
    				
    				
    				);
    		System.out.println("Match Score: "+ score);
    		
    		System.out.println(job.getUrl());
    		
    		if (score >= 70) {
    			
    			System.out.println(" *****Apply to This Job********");
    			
    		}
    		
    		System.out.println("-------------------------------");
    	}
    	
    }
}

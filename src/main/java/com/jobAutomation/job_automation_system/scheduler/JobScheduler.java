package com.jobAutomation.job_automation_system.scheduler;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.jobAutomation.job_automation_system.model.Job;
import com.jobAutomation.job_automation_system.service.JobFetcherService;
import com.jobAutomation.job_automation_system.service.JobMatcherService;
import com.jobAutomation.job_automation_system.service.NotificationService;
import com.jobAutomation.job_automation_system.service.SeleniumJobParserService;

@Component
public class JobScheduler {

	@Autowired 
	private JobFetcherService fetcherservice;
	
	@Autowired
	private SeleniumJobParserService parserService;
	
	@Autowired
	private JobMatcherService matcherService;
	
	@Autowired NotificationService notifications;
	
	
		@Scheduled(fixedRate = 3600000)
	public void monitorJobs() {
		System.out.println("*********Running Job Scan********");
		
		Set<String> processedJobs = new HashSet<>();
		
		
		  try {

	            List<String> links =
	                    fetcherservice.fetchJobLinks();

	            for (String link : links) {
	            	
	            	if (processedJobs.contains(link)) {
	            		continue;
	            	}
	            	 processedJobs.add(link);
	                Job job =
	                        parserService.parseJob(link);

	                int score =
	                        matcherService.calculateMatchScore(
	                                job.getDescription());

	                System.out.println("--------------------------------");
	                System.out.println("TITLE: " + job.getTitle());
	                System.out.println("MATCH SCORE: " + score);
	                System.out.println(job.getUrl());

	                if (score >= 70) {
	                   notifications.notify(job,score);
	                    
	                }
	            }

	        } catch (Exception e) {
	            System.out.println("❌ Scheduler Failed");
	            e.printStackTrace();
	        }
		
		
	}
	
	
}

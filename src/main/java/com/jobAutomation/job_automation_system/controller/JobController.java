package com.jobAutomation.job_automation_system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobAutomation.job_automation_system.model.Job;

@RestController
public class JobController {

    @GetMapping("/job")
    public Job getSampleJob() {
		return new Job("QA Automation Engineer",
				" Looking for Selenium API testing experience", "url");
		
        
    }
    
 
    
    
    
    
    
}
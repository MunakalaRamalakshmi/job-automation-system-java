package com.jobAutomation.job_automation_system.service;

import org.springframework.stereotype.Service;

import com.jobAutomation.job_automation_system.model.Job;

@Service
public class NotificationService {

	public void notify(Job job, int score) {
		
		System.out.println("\n **** JOB ALERT ****");
		System.out.println(" Title: "+ job.getTitle());
		System.out.println("Description: "+ job.getDescription());
		System.out.println("url: "+job.getUrl());
		System.out.println("Score: "+score);
	}
}

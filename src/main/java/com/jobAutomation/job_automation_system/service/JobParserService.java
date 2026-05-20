package com.jobAutomation.job_automation_system.service;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import com.jobAutomation.job_automation_system.model.Job;

@Service
public class JobParserService {

	public Job parseJob(String url) throws IOException {
		
		Document doc = Jsoup.connect(url)
				.userAgent("Mozilla/5.0")
				.get();
		
		String title = doc.select("h1").text();
		
		String description = doc.select("div[data-testid=jobDescriptionHtml]").text();
		System.out.println("Debug Desc Langth: "+description.length());
		
		return new Job(title, description, url);
		
	}
}

package com.jobAutomation.job_automation_system.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class JobFetcherService {
	
	public List<String> fetchJobLinks() throws IOException  {
		
		List<String> jobLinks = new ArrayList<>();
		
		String url = "https://www.dice.com/jobs?q=QA+Automation";
		
		Document doc = Jsoup.connect(url)
				.userAgent("Mozilla/5.0")
				.timeout(10000)
				.get();
		
		Elements jobs = doc.select("a[data-testid=job-search-job-detail-link]");
		
		
		for (Element job:jobs) {
			
			String link = job.absUrl("href");
			
			if (!link.isEmpty()) {
				jobLinks.add(link);
			}
		}
		
		
		return jobLinks;
		
	}

}

package com.jobAutomation.job_automation_system.service;

import org.springframework.stereotype.Service;

import com.jobAutomation.job_automation_system.model.Job;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Service
public class SeleniumJobParserService {

	public Job parseJob(String url) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");
		
		WebDriver driver = new ChromeDriver(options);
		
		try {
			
			driver.get(url);
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			
			WebElement titleElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
			
			String title = titleElement.getText();
			
			
			String description = driver.findElement(By.tagName("body")).getText();
			return new Job(title, description, url);
			
		}
		catch (Exception e) {
			e.printStackTrace();
	
		
		return new Job("Error", "FAILED","link");
	
		}finally {
			driver.quit();
		}
	
	
	
	
	
	}
	
	
	
}

package com.actitime.generic;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ListenerImplementation extends BaseClass implements ITestListener {

	public void onTestFailure(ITestResult result) {
		
		String name = result.getName();
		String time = LocalDateTime.now().toString();
		String ssname = name+time;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}
		TakesScreenshot ss= (TakesScreenshot) driver;
		File src=ss.getScreenshotAs(OutputType.FILE);
		File dest=new File("./target/screenshots/"+ssname+".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			
		
		}
	
	}

	
	
}

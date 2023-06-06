package com.actitime.generic;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestListener;
import org.testng.ITestResult;




public class ListenerImplementation extends BaseClass implements ITestListener {

	public void onTestFailure(ITestResult result) {
		
		String name = result.getName();
		LocalDateTime now = LocalDateTime.now();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd__HH-mm");

        // Format the LocalDateTime using the formatter
        String formattedDateTime = now.format(formatter);

		
		String ssname = name+"__"+formattedDateTime;
		System.out.println("ScreenShotName: "+ssname);
		
		
		TakesScreenshot ss= (TakesScreenshot) driver;
		File src=ss.getScreenshotAs(OutputType.FILE);
		File dest=new File("./target/screenshots/"+ssname+".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			
		
		}
	
	}

	
	
}

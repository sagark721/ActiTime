package com.actitime.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebDriverCommonLib extends BaseClass {
	public WebDriverWait wait=new WebDriverWait(driver, 15);

	public void waitForPageLoad() {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	public void maximize() {
		driver.manage().window().maximize();
	}
	
	public void waitUntilVisibilityOf(WebElement wb ) {
		wait.until(ExpectedConditions.visibilityOf(wb));
	}
}

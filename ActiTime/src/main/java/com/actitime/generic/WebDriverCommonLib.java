package com.actitime.generic;

import java.util.concurrent.TimeUnit;

public class WebDriverCommonLib extends BaseClass {

	public void waitForPageLoad() {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	public void maximize() {
		driver.manage().window().maximize();
	}
}

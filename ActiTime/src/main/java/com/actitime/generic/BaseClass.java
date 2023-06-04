package com.actitime.generic;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.actitime.pom.LoginPage;


public class BaseClass {
	
	static {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
	}

	public static WebDriver driver=new ChromeDriver();
	public FileLib f=new FileLib();
	
	@BeforeClass
	public void openBrowser() throws IOException {
		String url = f.readPropertyData("url");
		driver.get(url);
		WebDriverCommonLib wdc=new WebDriverCommonLib();
		wdc.waitForPageLoad();
		wdc.maximize();
	}
	
	
	@BeforeMethod
	public void login() throws IOException {
		LoginPage lp=new LoginPage(driver);
		 String un = f.readPropertyData("un");
		 String pwd = f.readPropertyData("pwd");
		lp.setLogin(un,pwd);
	}
	
	
	
}

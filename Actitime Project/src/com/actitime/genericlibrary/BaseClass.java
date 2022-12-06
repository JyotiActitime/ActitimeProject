package com.actitime.genericlibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.actitime.objectrepository.HomePage;
import com.actitime.objectrepository.LoginPage;

public class BaseClass {
	
	static {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	
	
	@BeforeSuite
	public void databaseconnection() {
		Reporter.log("database connected",true);
		
	}
	@AfterSuite
	public void databasedisconnected() {
		Reporter.log("database disconnected",true);
	}
	
	public static WebDriver driver;

	@BeforeClass
	public void launchBrowser() throws IOException {
		driver=new ChromeDriver();
		readDataFromPropertyFile data=new readDataFromPropertyFile();
		String Url = data.readdatafromproperty("url");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(Url);
		Reporter.log("launch Browser",true);
		}
	@AfterClass
	public void closebrowser() {
	
		driver.close();
	}
	@BeforeMethod
	public void login() throws IOException {
		readDataFromPropertyFile data=new readDataFromPropertyFile();
		String url = data.readdatafromproperty("url");
		String un = data.readdatafromproperty("username");
		String pw = data.readdatafromproperty("password");
		driver.get(url);
		LoginPage lp=new LoginPage(driver);
		lp.logintoActitime(un, pw);
	}
	@AfterMethod 
	public void logout() {
		HomePage hp=new HomePage(driver);
		hp.logout();
	}

}

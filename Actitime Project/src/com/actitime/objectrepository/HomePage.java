package com.actitime.objectrepository;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(id="logoutLink")
	private WebElement logoutlnk;
	
	@FindBy(xpath="//div[.='Tasks']")
	private WebElement tasklnk;
	
	@FindBy(xpath="[.='Reports']")
	private WebElement reportlnk;
	
	@FindBy(xpath="//div[.='Users']")
	private WebElement userlnk;
	
  public HomePage (WebDriver driver) {
	  PageFactory.initElements(driver, this);
		
	}

  public WebElement getLogoutlnk() {
	return logoutlnk;
  }

  public WebElement getTasklnk() {
	return tasklnk;
  }

  public WebElement getReportlnk() {
	return reportlnk;
  }

  public WebElement getUserlnk() {
	return userlnk;
 }
  
  //Generic Methods

  public void logout() {
	logoutlnk.click();
  }

  public void report() {
	reportlnk.click();
 }
  
  public void user() {
	  userlnk.click();
  }
  
  public void task() {
	  tasklnk.click();
  }


}

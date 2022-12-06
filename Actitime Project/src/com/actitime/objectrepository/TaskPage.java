package com.actitime.objectrepository;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.genericlibrary.ReadDataFromExcel;

public class TaskPage {
	@FindBy(xpath="//div[.='Add New']")
	private WebElement addnewbtn;
	
	@FindBy(xpath="//div[.='+ New Customer']")
	private WebElement newcustomer;
	
	@FindBy(xpath="(//input[@placeholder='Enter Customer Name'])[2]")
	private WebElement custname;
	
	@FindBy(xpath="//textarea[@placeholder='Enter Customer Description']")
	private WebElement desc;
	
	@FindBy(xpath="//div[text()='- Select Customer -']")
	private WebElement drop;
	
	@FindBy(xpath="//div[@class='itemRow cpItemRow ']/../div[2]")
	private WebElement bbc;
	
	@FindBy(xpath="//div[.='Create Customer']")
	private WebElement create;
	
	
	public TaskPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		}

	public WebElement getAddnewbtn() {
		return addnewbtn;
	}

	public WebElement getNewcustomer() {
		return newcustomer;
	}
	
	
	public WebElement getCustname() {
		return custname;
	}
	
	
	
	public WebElement getCreate() {
		return create;
	}

	
	
	public WebElement getDesc() {
		return desc;
	}

	public WebElement getBbc() {
		return bbc;
	}

	public WebElement getDrop() {
		return drop;
	}

	public void addnew() throws EncryptedDocumentException, IOException, InterruptedException {
		
		ReadDataFromExcel r=new ReadDataFromExcel();
		String cust= r.readDataFromExcel("Sheet1", 1, 1);

		
		addnewbtn.click();
		newcustomer.click();
		Thread.sleep(2000);
		custname.sendKeys(cust);
		
		
		desc.sendKeys("Banking");
		
		drop.click();
		bbc.click();
		create.click();
		
		
		
	}
	

}

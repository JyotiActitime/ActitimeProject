package com.actitime.testScript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.genericlibrary.BaseClass;
import com.actitime.objectrepository.HomePage;
import com.actitime.objectrepository.TaskPage;

@Listeners(com.actitime.genericlibrary.ListnerImplementation.class)
public class CreateCustomer extends BaseClass {
	
	@Test
	public void createcustomer() throws EncryptedDocumentException, IOException, InterruptedException {
		HomePage hp=new HomePage(driver);
		hp.task();
		TaskPage tp= new TaskPage(driver);
		tp.addnew();
		hp.logout();
		
		
	}

}

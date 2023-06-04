package com.actitime.testscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.actitime.generic.BaseClass;
import com.actitime.pom.HomePage;
import com.actitime.pom.TaskPage;

@Listeners(com.actitime.generic.ListenerImplementation.class)
public class CustomerModule extends BaseClass {

	@Test
	public void testCreateCustomer() throws EncryptedDocumentException, IOException {
		Reporter.log("Creating Customer");
		
		TaskPage tp= new TaskPage(driver);
		HomePage hp=new HomePage(driver);
		
		hp.setTaskTab();
		
		
		tp.setAddNewBtn();
		
		tp.setNewCustBtn();
		
		String custName = f.readExcelData("Customer", 9, 0);
		tp.setCustNameTxb(custName);
		
		String desc = f.readExcelData("Customer", 1, 1);
		tp.setDescriptionTxb(desc);
		
		String exproj = f.readPropertyData("existingProject");
		tp.setExistingProject(exproj);
		
		tp.setCreateCustBtn();
		
		String actName=tp.getActCustName();
		
		//Assert.assertEquals(custName, actName);
		
	}
}

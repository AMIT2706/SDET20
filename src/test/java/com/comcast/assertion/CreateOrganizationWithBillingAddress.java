package com.comcast.assertion;


import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.vtiger.comcast.genericutilities.BaseClass;
import com.vtiger.comcast.genericutilities.JavaUtility;
import com.vtiger.comcast.pomrepositorylib.CreateNewOrganizationPage;
import com.vtiger.comcast.pomrepositorylib.HomePage;
import com.vtiger.comcast.pomrepositorylib.OrganizationInfo;
import com.vtiger.comcast.pomrepositorylib.Organizations;


public class CreateOrganizationWithBillingAddress extends BaseClass {

	@Test
	public void CreateOrganizationWithBillingAddressTest() throws Throwable {

		
		int randomInt = jLib.getRanDomNumber();

		String OrgName = eLib.getDataFromExcel("TESTDATA", 2, 2) + randomInt;

		String BillingAdd = eLib.getDataFromExcel("TESTDATA", 2, 3);

		HomePage homepage = new HomePage(driver);
		homepage.getOrganizationslink().click();

		Organizations orgpage = new Organizations(driver);
		orgpage.getCreateOrgImg().click();

		CreateNewOrganizationPage cno = new CreateNewOrganizationPage(driver);
		cno.createorgbilladd(OrgName, BillingAdd);

		OrganizationInfo orginfopage = new OrganizationInfo(driver);
		 boolean actSuccessfulMsg = orginfopage.getSuccessfulMsg().getText().contains(OrgName);

	//	if (actSuccessfulMsg.contains(OrgName)) {
		Assert.assertTrue(actSuccessfulMsg);

	
   //  SoftAssert soft =  new  SoftAssert();
    // soft.assertEquals(actSuccessfulMsg, OrgName);
   //  
      
     
	// System.out.println("OrgName::OrgName Created Successfully");
		//else {
          // assertTrue(false);
			// System.out.println("OrgName:: OrgName Not Created Successfully");
			// }

			String actualBillingAdd = orginfopage.getBillingInfo().getText();

			// if (actualBillingAdd.equals(BillingAdd))

			// System.out.println("Billing Address::Billing Address is Verified
			// Successfully");
			// else
			// System.out.println("Billing Address:: Billing Address is Not Verfied
			// Successfully");

			Assert.assertEquals(actualBillingAdd, BillingAdd);	
}
}
	

package vtigercrm;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.comcast.genericutilities.BaseClass;
import com.vtiger.comcast.genericutilities.ExcelUtility;
import com.vtiger.comcast.genericutilities.FileUtitlity;
import com.vtiger.comcast.genericutilities.JavaUtility;
import com.vtiger.comcast.genericutilities.WebDriverUtility;
import com.vtiger.comcast.pomrepositorylib.CreateNewOrganizationPage;
import com.vtiger.comcast.pomrepositorylib.HomePage;
import com.vtiger.comcast.pomrepositorylib.Login;
import com.vtiger.comcast.pomrepositorylib.OrganizationInfo;
import com.vtiger.comcast.pomrepositorylib.Organizations;

public class CreateOrganizationWithBillingAddressTest extends BaseClass{


@Test
public  void CreateOrganizationWithBillingAddressTest() throws Throwable {

	
	
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
	
	Assert.assertTrue(actSuccessfulMsg);
//
//	if (actSuccessfulMsg.contains(OrgName)) {
//		System.out.println("OrgName::OrgName Created Successfully");
//	} else {
//
//		System.out.println("OrgName:: OrgName Not Created Successfully");
//	}

	String actualBillingAdd = orginfopage.getBillingInfo().getText();

//	if (actualBillingAdd.equals(BillingAdd))
//		System.out.println("Billing Address::Billing Address is Verified Successfully");
//	else 
//		System.out.println("Billing Address:: Billing Address is Not Verfied  Successfully");
       assertEquals(actualBillingAdd, BillingAdd);
}	
	
}
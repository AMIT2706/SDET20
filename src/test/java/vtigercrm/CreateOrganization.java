package vtigercrm;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.util.Strings;

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

@Listeners(com.vtiger.comcast.genericutilities.ListenerImplementationClass.class)
public class CreateOrganization extends BaseClass {

	@Test(groups = "regressiontesting")
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
		Assert.assertTrue(actSuccessfulMsg);
		
//		SoftAssert soft = new SoftAssert();
//		soft.assertTrue(actSuccessfulMsg);
//		soft.assertAll();
		

//		if (actSuccessfulMsg.contains(OrgName)) {
//			//System.out.println("OrgName::OrgName Created Successfully");
//		} else {
//
//			System.out.println("OrgName:: OrgName Not Created Successfully");
//		}

		String actualBillingAdd = orginfopage.getBillingInfo().getText();

		assertEquals(actualBillingAdd, BillingAdd);
//
//		if (actualBillingAdd.equals(BillingAdd))
//			System.out.println("Billing Address::Billing Address is Verified Successfully");
//		else 
//			System.out.println("Billing Address:: Billing Address is Not Verfied  Successfully");
	}

	@Test(groups = "regionalregresssiontesting")

	public void CreateOrganizationWithoutShippingAddTest() throws Throwable {

		int randomInt = jLib.getRanDomNumber();
		String OrgName = eLib.getDataFromExcel("TESTDATA", 1, 2) + randomInt;
		String IndustriesType = eLib.getDataFromExcel("TESTDATA", 1, 3);

		HomePage homepage = new HomePage(driver);
		homepage.getOrganizationslink().click();

		Organizations orgpage = new Organizations(driver);
		orgpage.getCreateOrgImg().click();

		CreateNewOrganizationPage cno = new CreateNewOrganizationPage(driver);
		cno.createOrg(OrgName, IndustriesType);

		OrganizationInfo orginfopage = new OrganizationInfo(driver);
		boolean actSuccessfulMsg = orginfopage.getSuccessfulMsg().getText().contains(OrgName);
		Assert.assertTrue(actSuccessfulMsg);

//
//		if (actSuccessfulMsg.contains(OrgName)) {
//			System.out.println("OrgName::OrgName is  Created Successfully");
//		} else {
//			System.out.println("OrgName:: OrgName is Not Created Successfully");
//		}

		String actualIndustryType = orginfopage.getIndustryTypeInfo().getText();
		assertEquals(actualIndustryType, IndustriesType);

//		if (actualIndustryType.equals(IndustriesType)) {
//
//			System.out.println("IndustriesType::IndustriesType is Verified Successfully");
//		} else {
//			System.out.println("IndustriesType:: IndustriesType is Not Verfied  Successfully");
//		}
	}

	@Test(groups = "smoketesting")

	public void CreateOrganizationWithShippingAddressTest() throws Throwable {
		int randomInt = jLib.getRanDomNumber();

		String OrgName = eLib.getDataFromExcel("TESTDATA", 3, 2) + randomInt;

		String ShippingAdd = eLib.getDataFromExcel("TESTDATA", 3, 3);

		HomePage homepage = new HomePage(driver);
		homepage.getOrganizationslink().click();

		Organizations orgpage = new Organizations(driver);
		orgpage.getCreateOrgImg().click();

		CreateNewOrganizationPage cno = new CreateNewOrganizationPage(driver);
		cno.createorgshipadd(OrgName, ShippingAdd);

		OrganizationInfo orginfopage = new OrganizationInfo(driver);
		boolean actSuccessfulMsg = orginfopage.getSuccessfulMsg().getText().contains(OrgName);
		Assert.assertTrue(actSuccessfulMsg);

//		if (actSuccessfulMsg.contains(OrgName)) {
//			System.out.println("OrgName::OrgName Created Successfully");
//		} else {
//
//			System.out.println("OrgName:: OrgName Not Created Successfully");
//		}
		String actualShippingAdd = orginfopage.getShippingInfo().getText();

		assertEquals(actualShippingAdd, ShippingAdd);

//		if (actualShippingAdd.equals(ShippingAdd)) {
//			System.out.println("Shipping Address:Shipping Address is Verified Successfully");
//		} else {
//
//			System.out.println("Shipping Address::Shipping Address is Not Verfied  Successfully");
//		}

	}
}
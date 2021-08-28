package vtigercrm;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
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

public class CreateOrganizationWithoutShippingAdd extends BaseClass {

	// public static void main(String[] args) throws Throwable {
	@Test
	public  void CreateOrganizationWithoutShippingAddTest() throws Throwable {

		
		
		int randomInt = jLib.getRanDomNumber();

		

		String OrgName = eLib.getDataFromExcel("TESTDATA", 1, 2) + randomInt;
		String IndustriesType = eLib.getDataFromExcel("TESTDATA", 1, 3) ;


		HomePage homepage = new HomePage(driver);
		homepage.getOrganizationslink().click();

		Organizations orgpage = new Organizations(driver);
		orgpage.getCreateOrgImg().click();

		CreateNewOrganizationPage cno = new CreateNewOrganizationPage(driver);
		cno.createOrg(OrgName, IndustriesType);
		
		OrganizationInfo orginfopage = new OrganizationInfo(driver);
		boolean actSuccessfulMsg = orginfopage.getSuccessfulMsg().getText().contains(OrgName);
		assertTrue(actSuccessfulMsg);

//		if (actSuccessfulMsg.contains(OrgName)) {
//			System.out.println("OrgName::OrgName is  Created Successfully");
//		} else {
//
//			System.out.println("OrgName:: OrgName is Not Created Successfully");
//		}

		String actualIndustryType = orginfopage.getIndustryTypeInfo().getText();
		Assert.assertEquals(actualIndustryType, IndustriesType);

//		if (actualIndustryType.equals(IndustriesType)) {
//			System.out.println("IndustriesType::IndustriesType is Verified Successfully");
//		} else {
//
//			System.out.println("IndustriesType:: IndustriesType is Not Verfied  Successfully");
		}}


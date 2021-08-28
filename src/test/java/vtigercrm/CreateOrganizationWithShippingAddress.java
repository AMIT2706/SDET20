package vtigercrm;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Random;
import java.util.concurrent.TimeUnit;

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

public class CreateOrganizationWithShippingAddress extends BaseClass{

	//public static void main(String[] args) throws Throwable {
	
	@Test
	
	public void CreateOrganizationWithShippingAddressTest() throws Throwable {

	
		int randomInt = jLib.getRanDomNumber();


		String OrgName = eLib.getDataFromExcel("TESTDATA", 3, 2) + randomInt;

	String ShippingAdd = eLib.getDataFromExcel("TESTDATA", 3, 3) ;

		
	

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
//		
		}
	}


	

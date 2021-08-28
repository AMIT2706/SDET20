package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.vtiger.comcast.genericutilities.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility {

	public CreateNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "accountname")
	private WebElement OrgNameEdt;

	@FindBy(name = "industry")
	private WebElement industrydd;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;

	@FindBy(name = "bill_street")
	private WebElement billaddress;

	@FindBy(name = "ship_street")
	private WebElement shipaddress;

	public void createOrg(String OrgName, String IndustriesType) {
		OrgNameEdt.sendKeys(OrgName);
		select(industrydd, IndustriesType);
		 SaveBtn.click();
	}

	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getShipaddress() {
		return shipaddress;
	}

	public WebElement getIndustrydd() {
		return industrydd;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public void createorgbilladd(String OrgName, String BillingAdd) {
		OrgNameEdt.sendKeys(OrgName);
		billaddress.sendKeys(BillingAdd);
		SaveBtn.click();
	}

	public void createorgshipadd(String OrgName, String ShippingAdd) {
		OrgNameEdt.sendKeys(OrgName);
		shipaddress.sendKeys(ShippingAdd);
		SaveBtn.click();
	}
}

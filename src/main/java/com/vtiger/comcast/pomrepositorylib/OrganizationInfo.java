package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfo {

	public OrganizationInfo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@id='dtlview_Industry']/font")
	private WebElement IndustryTypeInfo;
	
	
	public WebElement getIndustryTypeInfo() {
		return IndustryTypeInfo;
	}


	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement SuccessfulMsg;

	public WebElement getSuccessfulMsg() {
		return SuccessfulMsg;
	}


	@FindBy(xpath = "//span[@id='dtlview_Billing Address']")
	private WebElement BillingInfo;

	public WebElement getBillingInfo() {
		return BillingInfo;
	}

	@FindBy(xpath = "//span[@id='dtlview_Shipping Address']")

	private WebElement ShippingInfo;

	public WebElement getShippingInfo() {
		return ShippingInfo;
	}

} 
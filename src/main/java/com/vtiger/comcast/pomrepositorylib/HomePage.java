    package com.vtiger.comcast.pomrepositorylib;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

import com.vtiger.comcast.genericutilities.WebDriverUtility;

	     public class HomePage extends WebDriverUtility{
	    	 
	      WebDriver driver;
		   public HomePage(WebDriver driver) {
			   this.driver=driver;
		   PageFactory.initElements(driver, this);
			}
			
			
			@FindBy(linkText="Organizations")
			private WebElement Organizationslink;
		
			
			@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
			private WebElement administraterImg;
			
			@FindBy(linkText="Sign Out")
			private WebElement signOutLink;

			public WebElement getOrganizationslink() {
				return Organizationslink;
			}

			public WebElement getAdministraterImg() {
				return administraterImg;
			}

			public WebElement getSignOutLink() {
				return signOutLink;
			}
			
		    public void logout() {
		    	
			mouseOver(driver, administraterImg);
		        signOutLink.click();
		            }
	}

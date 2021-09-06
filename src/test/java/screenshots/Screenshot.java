package screenshots;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Screenshot {
	WebDriver driver ;
	
	ExtentHtmlReporter reporter;
	ExtentReports reports;
	ExtentTest test;
	
	@BeforeSuite 
	public  void configBs() {
		System.out.println("====================connect to DB==============");
		
		reporter= new  ExtentHtmlReporter("./ExtentReports/SDET20.html");
		reporter.config().setDocumentTitle("practice");
		reporter.config().setTheme(Theme.DARK);
		reports = new ExtentReports();
		reports.attachReporter(reporter);
		
		
		
	}
	
	@BeforeClass
	
	public void configBc() {
		driver= new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
	}
	
	@BeforeMethod
	public void configBM() {
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("270621");
	driver.findElement(By.id("submitButton")).click();
	}
	
	@Test
	
	 public void getTitle() {
	test=reports.createTest("getTitle");
	 String homepageTitle = driver.getTitle();
	 Assert.assertEquals(homepageTitle,"Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM");
	 driver.findElement(By.linkText("Organizations")).click();
	 String orgpageTitle = driver.getTitle();
	 Assert.assertEquals(orgpageTitle,"Administrator - Organizations - vtiger CRM 5 - Commercial Open Source CRM" );
	}
			 
	 @AfterMethod
	 
	 public void configAM() {
	new Actions(driver).moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
	 driver.findElement(By.linkText("Sign Out")).click();
	 }
		
	 @AfterClass
	 void configAc() {
		 driver.quit();
	}
	 
	 @AfterSuite
	 void configAS() {
		 reports.flush();
	System.out.println("==close db ===");
	 }
}
		

	
	
	
	
	
	



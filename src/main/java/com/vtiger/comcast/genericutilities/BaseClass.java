package com.vtiger.comcast.genericutilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.vtiger.comcast.pomrepositorylib.HomePage;
import com.vtiger.comcast.pomrepositorylib.Login;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver sDriver;
	
       /*Object Creation for Lib*/
		public JavaUtility jLib = new JavaUtility();
		public WebDriverUtility wLib = new WebDriverUtility();
		public FileUtitlity fLib = new FileUtitlity();
		public ExcelUtility eLib = new ExcelUtility();
	
	 @BeforeSuite(groups= {"smoketesting","regressiontesting"})
	
	public void configBS() {
		System.out.println("========================connect to DB========================");
	}
		
	@BeforeClass(groups= {"smoketesting","regressiontesting"})
	public void configBC() {
		
		System.out.println("=============Launch the Browser=======");
		driver = new ChromeDriver();
		wLib.waitUntilPageLoad(driver);
		wLib.maximizeBrowser(driver);
		sDriver=driver;

	}


   //@Parameters("Browser")
//@BeforeClass
//public void configBC(String Browser) {
//	System.out.println("=====Launching Browser=======");
//	// Object creation for Utilities
//	if(Browser.equals("chrome")) {
//		driver=new ChromeDriver();
//	}else if(Browser.equals("firefox")) {
//		driver=new FirefoxDriver();
//	}else if(Browser.equals("msedge")) {
//		driver=new EdgeDriver();
//	}
//	
//	wLib.maximizeBrowser(driver);
//	wLib.waitUntilPageLoad(driver);
//}


	
	@BeforeMethod(groups= {"smoketesting","regressiontesting"})
	public void configBM() throws Throwable {
		/*common Data*/
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		String URL = fLib.getPropertyKeyValue("url");
		String BROWSER = fLib.getPropertyKeyValue("browser");
		/* Navigate to app*/
		   driver.get(URL);
	        /* step 1 : login */
	        Login loginPage = new Login(driver);
	        loginPage.loginToApp(USERNAME, PASSWORD);
	}
	
	
	@AfterMethod(groups= {"smoketesting","regressiontesting"})
	public void configAM() {
		
	      /*step 6 : logout*/
		HomePage homePage = new HomePage(driver);
        homePage.logout();
	}
	
	@AfterClass(groups= {"smoketesting","regressiontesting"})
	public void configAC() {
		System.out.println("=============Close the Browser=======");
		driver.quit();
	}
	
	@AfterSuite(groups= {"smoketesting","regressiontesting"})
	public void configAS() {
		System.out.println("========================close DB========================");
	}
}



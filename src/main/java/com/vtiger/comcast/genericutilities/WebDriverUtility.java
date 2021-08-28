package com.vtiger.comcast.genericutilities;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class contains webdriver specific generic methods
 * 
 * @author JEEVA
 *
 */
public class WebDriverUtility {
	/**
	 * This method is used to maximize the browser
	 * 
	 * @param driver
	 */
	public void maximizeBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * This method waits for 20 sec for page loading
	 * 
	 * @param driver
	 */
	public void waitUntilPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	/**
	 * This method waits for 20 sec for the element to be visible
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitForElementVisibility(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method waits for the element to be clicked, it's a custom wait created
	 * to avoid elemenInterAceptable Exception
	 * 
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitAndClick(WebElement element) throws InterruptedException {
		int count = 0;
		while (count < 20) {
			try {
				element.click();
				break;
			} catch (Throwable e) {
				Thread.sleep(1000);
				count++;
			}
		}
	}

	/**
	 * This methods enables user to handle dropdown using visible text
	 * 
	 * @param element
	 * @param option
	 */
	public void select(WebElement element, String option) {
		Select sel = new Select(element);
		sel.selectByVisibleText(option);
	}

	/**
	 * This methods enables user to handle dropdown using index
	 * 
	 * @param element
	 * @param index
	 */
	public void select(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	/**
	 * This method will perform mouse over action
	 * 
	 * @param driver
	 * @param element
	 */
	public void mouseOver(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}

	/**
	 * This method performs right click operation
	 * 
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();

	}

	/**
	 * This method helps to switch from one wondow to another
	 * 
	 * @param driver
	 * @param partialWinTitle
	 */

	public void switchToWindow(WebDriver driver, String partialWinTitle) {
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();

		while (it.hasNext()) {
			String winId = it.next();
			String title = driver.switchTo().window(winId).getTitle();
			if (title.contains(partialWinTitle)) {
				break;

			}
		}
	}

	/**
	 * Accept alert
	 * 
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * Cancel Alert
	 * 
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * This method used for scrolling action in a webpage
	 * 
	 * @param driver
	 * @param element
	 */
	public void scrollToWebElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0," + y + ")", element);
	}

	/**
	 * This method used switch to frames in a webpage using webElement
	 * 
	 * @param driver
	 * @param index
	 */
	public void switchFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void switchFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * This method used switch to frames in a webpage using Id or Name
	 * 
	 * @param driver
	 * @param idOrName
	 */
	public void switchFrameId(WebDriver driver, WebElement idOrName) {
		driver.switchTo().frame(idOrName);
	}

	/**
	 * 
	 * @param driver
	 * @param screenShotName
	 */
	public void takeScreenShot(WebDriver driver, String screenShotName) throws Throwable {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ScreeenShot/" + screenShotName + ".PNG");
		Files.copy(src, dest);
	}

	/**
	 * pass enter Key in to Browser
	 * 
	 * @param driver
	 */
	public void passEnterKey(WebDriver driver) {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
}

package com.vtiger.comcast.genericutilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementationClass implements ITestListener {
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		EventFiringWebDriver eWebDriver = new EventFiringWebDriver(BaseClass.sDriver);
		File srcFile = eWebDriver.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File("./screenshot/"+methodName+".PNG"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

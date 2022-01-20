package com.crm.comcast.GenericUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ListenerImpClass extends BaseClass implements ITestListener {

	public void onTestFailure(ITestResult result) {

		String testCaseName = result.getMethod().getMethodName();

		// Take screenshot of failed testcases

		EventFiringWebDriver event = new EventFiringWebDriver(BaseClass.sdriver);
		File source = event.getScreenshotAs(OutputType.FILE);
		File destination = new File("./errorshot/" + testCaseName + ".png");
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

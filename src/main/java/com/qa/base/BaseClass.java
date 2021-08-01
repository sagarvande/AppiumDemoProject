package com.qa.base;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseClass {
	
	static AndroidDriver<AndroidElement> driver;
	static AppiumDriverLocalService service;
	public BaseClass() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@BeforeTest
	
	public static AndroidDriver<AndroidElement> setUp() throws MalformedURLException
	{
		//Set apk path
		
		File dir=new File ("src");
		File appPath=new File(dir, "General-Store.apk");
		
		//Setup capabilities
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.APP, appPath.getAbsolutePath());
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Emulator");
		capabilities.setCapability("noReset", true);
		 driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		return driver;

	}

	//User defined functions
	//Scroll till the element and click 

	public static void Scroll(String countryName)
	{
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + countryName + "\"));").click();
	}
	
	public void sendKeys(MobileElement e, String txt)
	{
	e.sendKeys(txt);	
	}

	public void click(MobileElement e)
	{
	e.click();	
	}
	public void waitForVisibility(MobileElement e) {

		// Wait is constant and it's value is initialized in TestUtils class

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(e));

	}
	
	public static void startAppiumServer() {

		service=AppiumDriverLocalService.buildDefaultService();
		service.start();
		//return service;
	}
public static void captureScreenshot() throws IOException

{
	File srcfile=/*((TakesScreenshot)driver)*/driver.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(srcfile, new File("C:\\screenshots\\defect.png"));
}
	
}

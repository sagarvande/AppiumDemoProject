package com.qa.tests;
import com.qa.base.BaseClass;
import com.qa.pages.HomeScreen;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class HomeTest extends BaseClass{

		//static String countryName="Brazil";

@Test(dataProvider="getDataFromDataProvider")	
public static void VerifyTitle(String name,String country) throws MalformedURLException {
	//startAppiumServer();
	HomeScreen hs=new HomeScreen();
	hs.enterName(name);
	hs.openCountrydropdown();
	hs.selectCountry(country);
	//hs.clickOnLetsShopButton();
}

@DataProvider
public Object[][] getDataFromDataProvider()
{
	Object[][] data=new Object [3][2];
	data[0][0]="sagar";
	data[0][1]="Canada";
	data[1][0]="rahul";
	data[1][1]="Bhutan";
	data[2][0]="Sachin";
	data[2][1]="Brazil";
	return data;
	
}

}



package com.qa.pages;

import com.qa.base.BaseClass;
import com.qa.utils.CommonUtilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomeScreen extends BaseClass{

	/*
	 * @AndroidFindBy(id="com.androidsample.generalstore:id/toolbar_title") private
	 * MobileElement homeScreenTitle;
	 */
@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
private MobileElement nameInputField;

@AndroidFindBy(id="com.androidsample.generalstore:id/spinnerCountry")
private MobileElement countryDropdown;

@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
private MobileElement letsShopButton;


public void enterName(String userName)
{
	waitForVisibility(nameInputField);
	sendKeys(nameInputField,userName);

}

public void openCountrydropdown()
{
	waitForVisibility(countryDropdown);
	click(countryDropdown);
}

public void selectCountry(String countryName)
{
Scroll(countryName);
}

public void clickOnLetsShopButton()
{
click(letsShopButton);	

}


}
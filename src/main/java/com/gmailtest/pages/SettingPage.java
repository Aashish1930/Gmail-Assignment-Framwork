package com.gmailtest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gmailtest.base.TestBase;

public class SettingPage extends TestBase {

	public SettingPage(){
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//*[@class=\"dt\"]")
	WebElement SettingLogo;
	
	
	
	
	
	
	public boolean SettingLogoTest(){
		return SettingLogo.isDisplayed();
	}
	
	
	


}

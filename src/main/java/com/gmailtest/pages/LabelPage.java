package com.gmailtest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;

import com.gmailtest.base.TestBase;

import bsh.org.objectweb.asm.Label;

public class LabelPage extends TestBase{

	public  LabelPage(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\":mc\"]")
	WebElement TestingLabel;
	
	
	
	//@FindBy(xpath="//*[@id=\":od.na\"]")
		@FindBy(xpath="//input[@id=':m2.na']")
		WebElement LabelName;
		
		@FindBy(xpath="//button[@name='ok']")
		WebElement Create;
		
		
	
	
	public void TestingLabel(){
		TestingLabel.click();
	}
	
	
	public void CreateLable(){
		LabelName.sendKeys("Testing1");
		Create.click();
	}
	
	
	
	
	
	
	
}

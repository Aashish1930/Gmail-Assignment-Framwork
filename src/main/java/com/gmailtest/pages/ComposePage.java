package com.gmailtest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gmailtest.base.TestBase;

public class ComposePage extends TestBase {

	
	public ComposePage() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(className = "vO")
	WebElement SendTo;
	
	@FindBy(className = "aoT")
	WebElement Subject;

	@FindBy(className = "Am")
	WebElement MassageBody;

	@FindBy(className = "aoO")
	WebElement sendbtn;  
	
	@FindBy(xpath="//*[@id=\":lz\"]")
	WebElement CheckSentButton;
	
	
	
	public void sendmail(String sendTo, String subject, String Massegebody) {

		SendTo.sendKeys(sendTo);
		Subject.sendKeys(subject);
		MassageBody.sendKeys(Massegebody);
		sendbtn.click();

	}



	public void CheckSentButton() throws InterruptedException {
	
		Thread.sleep(5000);;
		CheckSentButton.click();
		
	}



	
	
	
	

}

	
	
	
	


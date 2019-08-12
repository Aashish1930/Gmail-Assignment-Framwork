package com.gmailtest.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gmailtest.base.TestBase;

public class UnReadMailPage extends TestBase {
	
	public UnReadMailPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(className = "zE")
	List<WebElement> unreademail;

	public void CountUnreadMAil() {

		/*
		 * for (int i = 0; i < unreademail.size(); i++) { System.out.println(
		 * unreademail.get(i).getText()); if
		 * (inbox1.get(i).getText().equals("Support")) //to click on a specific
		 * mail. { unreademail.get(i).click();
		 * 
		 * } }
		 */System.out.println("UN-READ MAIL COUNT IS  " + unreademail.size());

	}

}

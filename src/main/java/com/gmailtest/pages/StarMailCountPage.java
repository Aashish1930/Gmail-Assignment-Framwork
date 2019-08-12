package com.gmailtest.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gmailtest.base.TestBase;

public class StarMailCountPage extends TestBase {

	public StarMailCountPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "	//*[@class=\"T-KT T-KT-Jp\"]")
	List<WebElement> StarMAil;

	public void CountAllStarMaill() {

		int count = 0;
		for (int i = 0; i < StarMAil.size(); i++) {
			count++;
		}
		System.out.println("All Starred Mail Count is " + count);

	}

}

package com.gmailtest.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gmailtest.base.TestBase;

public class AllMailPage extends TestBase {

	public AllMailPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\":lk\"]")
	WebElement click;

	@FindBy(xpath = "//*[@class=\"yW\"]")
	List<WebElement> inbox1;

	public void CountReadMAil() throws InterruptedException {

		int count = 0;
		boolean flag = true;
		int i = 0;
		try {

			while (click.isEnabled() == flag) {

				for (i = 0; i < inbox1.size(); i++) {
					System.out.println(inbox1.get(i).getText());
					count++;
				}
				System.out.println(" count is " + count);
				if (i < 50) {
					flag = false;
				} else {
					Thread.sleep(20000);
					click.click();
					Thread.sleep(10000);
				}

			}
			System.out.println("All Read Mail is " + count);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

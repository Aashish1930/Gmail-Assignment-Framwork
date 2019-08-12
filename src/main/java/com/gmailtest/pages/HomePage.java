package com.gmailtest.pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gmailtest.base.TestBase;

public class HomePage extends TestBase {

	WebDriverWait wait = new WebDriverWait(driver, 10);

	public HomePage() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//*[@class=\"T-I J-J5-Ji T-I-KE L3\"]")
	WebElement Compose;

	@FindBy(xpath = "//*[@class=\"gb_la\"]")
	WebElement homelogo;

	@FindBy(xpath = "	//div[@class='TN bzz aHS-bnt']//div[@class='aio UKr6le']")
	WebElement InboxButton;

	@FindBy(xpath = "//*[@id=\"gb\"]/div[2]/div[3]/div/div[2]/div/a/span")
	WebElement Abtn;

	@FindBy(xpath = "//*[contains(text(),'Aashish Mehta') and @class='gb_ab gb_bb']")
	WebElement usernamelabel;

	@FindBy(xpath = "//*[@class=\"gb_3 gb_6f gb_eg gb_Ne gb_pb\"]")
	WebElement signoutbtn;

	@FindBy(xpath = "//*[@class=\"T-I J-J5-Ji T-I-KE L3\"]")
	WebElement compose;

	@FindBy(xpath = "//*[@aria-label=\"Search mail\"]")
	WebElement SearchBoxMail;

	@FindBy(xpath = "//*[@class=\"gb_kf gb_lf\"]")
	WebElement Searchclick;

	@FindBy(xpath = "//*[@class=\"brg\"]")
	List<WebElement> AllAtatchmentMAil;

	@FindBy(xpath = "//div[@class='asa']")
	WebElement SettingMenu;

	@FindBy(xpath = "//*[@id=\"ms\"]/div")
	WebElement Setting;

	@FindBy(xpath = "//*[@class=\"CJ\"]")
	WebElement more;

	@FindBy(xpath = "//a[contains(text(),'Create new label')]")
	WebElement CreateLabel;

	@FindBy(xpath = "//*[@id=\":3j\"]")
	WebElement MoveMassegeSalect;

	@FindBy(xpath = "//*[@id=\":30\"]")
	WebElement MoveToLabel;

	@FindBy(xpath = "//div[contains(text(),'Work')]")
	WebElement ClickOnTestingLabel;

	@FindBy(xpath = "//*[@id=\":lv\"]")
	WebElement Starred;
	
	

	public String verifyHomePageTitle() {
		LoginPage lp = new LoginPage();
		return driver.getTitle();
	}

	public boolean verifyuser() {
		Abtn.click();
		return usernamelabel.isDisplayed();
	}

	public boolean validatehomeLogo() {
		return homelogo.isDisplayed();
	}

	public AllMailPage InboxMail() {

		InboxButton.click();
		return new AllMailPage();

	}

	// ------------------------------------------------------------------------------------------------------------------------

	public void signout() {
		Abtn.click();
		signoutbtn.click();
	}

	// ------------------------------------------------------------------------------------------------------------------------

	public StarMailCountPage ClickStatMail() {
		Starred.click();
		return new StarMailCountPage();

	}

	// -------------------------------------------------------------------------------------------------------------------

	public ComposePage clickOncompose() {

		Compose.click();

		return new ComposePage();

	}
	// ------------------------------------------------------------------------------------------------

	public void CheckSpecificMasseage(String search) {

		SearchBoxMail.sendKeys(search);

		Searchclick.click();

	}

	// ---------------------------------------------------------------------------------------------------------------

	public void checkAllAtatchmentMAil() {
		int count = 0;
		for (int i = 0; i < AllAtatchmentMAil.size(); i++) {
			System.out.println(AllAtatchmentMAil.get(i).getText());
			count++;
		}

		System.out.println("All Atatchment Mail Count is:" + count);
	}

	// ------------------------------------------------------------------------------------------
	// 17. To verify that Settings page is displayed properly

	public SettingPage SettingVerify() {
		SettingMenu.click();
		Setting.click();
		return new SettingPage();

	}

	// ----------------------------------------------------------------------------------------------
	// 18. To verify that the new label is properly created

	public LabelPage CreateLabel() throws InterruptedException {
		more.click();
		CreateLabel.click();
		return new LabelPage();

	}

	// -----------------------------------------------------------------------------------
	/*
	 * 19. To verify that emails are moved from source label to target label
	 * (Folders) Verification - Select an email or emails to be moved as below
	 */

	public LabelPage MoveTextMasseage() throws InterruptedException {
		MoveMassegeSalect.click();
		MoveToLabel.click();
		Thread.sleep(5000);
		ClickOnTestingLabel.click();
		return new LabelPage();

	}

}

/*
 * if (inbox1.get(i).getText().equals("Support")) // to click on a // specific
 * // mail. { inbox1.get(i).click(); sum++;
 * 
 * }
 */ // count++;

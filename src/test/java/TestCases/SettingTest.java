package TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.gmailtest.base.TestBase;
import com.gmailtest.pages.HomePage;
import com.gmailtest.pages.LoginPage;
import com.gmailtest.pages.SettingPage;

public class SettingTest extends TestBase {

	HomePage homepage;
	SettingPage setting;
	LoginPage loginpage;
	
	public SettingTest() {
		super();
	}

	@BeforeClass
	public void setup() throws Exception {
		initilization();
		homepage = new HomePage();
		setting = new SettingPage();
		loginpage= new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}

	@Test
	public void SettingLogoTest() {
		setting=homepage.SettingVerify();
		boolean flag = setting.SettingLogoTest();
		if (flag = true) {
			System.out.println("Logo presented");
			Assert.assertTrue(true, "logo is presented");
		} else {
			Assert.assertFalse(false, "logo is not presented");
		}
	}
	
	@AfterClass
	public void close() throws InterruptedException{
		Thread.sleep(5000);
		driver.quit();
	}
	
	
}

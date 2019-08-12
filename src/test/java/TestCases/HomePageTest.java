package TestCases;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gmailtest.base.TestBase;
import com.gmailtest.pages.HomePage;
import com.gmailtest.pages.LoginPage;
import com.gmailtest.testutils.TestUtil;

public class HomePageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws Exception {
		initilization();
		loginpage = new LoginPage();
		homepage = new HomePage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));

	}
	
		
	

	@Test
	public void CountAllAttatchmentMail() {
		homepage.checkAllAtatchmentMAil();
	}

	@Test
	public void SignOut() {
		homepage.signout();

	}

	@Test
	public void SearchMassege() {
		homepage.CheckSpecificMasseage("amitkumarprasad935@gmail.com ");
	}

	@Test
	public void VerifySetting() {
		homepage.SettingVerify();
	}

	@AfterMethod
	public void close() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

}
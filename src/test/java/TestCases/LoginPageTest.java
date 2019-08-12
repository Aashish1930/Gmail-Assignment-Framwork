package TestCases;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gmailtest.base.TestBase;
import com.gmailtest.pages.HomePage;
import com.gmailtest.pages.LoginPage;
import com.gmailtest.testutils.TestUtil;

public class LoginPageTest extends TestBase {

	LoginPage LOGINPAGE;
	HomePage homepage;

	public LoginPageTest()  {
		super();
	}

	@BeforeClass
	public void setup() throws Exception {
		initilization();
		LOGINPAGE = new LoginPage();
		homepage = new HomePage();
	}

	
	@BeforeMethod
	public void checkTestSkip(Method method) {

		String testName = method.getName();
		System.out.println("NAME IS :-"+testName);

		if (!TestUtil.isTestCaseRunnable(xls, testName)) {
			
			System.out.println(" Skiped");
		throw new SkipException("Skipping the case as set to No");
	
		} else {
			System.out.println("Not Skip");
			
		}
	}
		
	
	
	@Test
	public void LoginPageTitleTest() {
		String title = LOGINPAGE.validateTitle();
		Assert.assertEquals(title, "Gmail");
		System.out.println("title validate");

	}

	@Test
	public void validatelogo() {
		boolean flag = LOGINPAGE.validateLogo();
		Assert.assertTrue(flag);
		System.out.println("logo validate ");
		driver.quit();
	}

	@Test
	public void signin() throws InterruptedException {

		homepage = LOGINPAGE.login(prop.getProperty("username"), prop.getProperty("password"));

	}


	@AfterClass
	public void close() throws InterruptedException{
		Thread.sleep(5000);
		driver.quit();
	}
}
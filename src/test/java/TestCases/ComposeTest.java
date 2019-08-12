package TestCases;

import java.lang.reflect.Method;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gmailtest.base.TestBase;
import com.gmailtest.pages.ComposePage;
import com.gmailtest.pages.HomePage;
import com.gmailtest.pages.LoginPage;
import com.gmailtest.testutils.TestUtil;

public class ComposeTest extends TestBase {

	LoginPage LOGINPAGE;
	HomePage homepage;
	ComposePage compose;

	String sheetName = "Sheet1";

	public ComposeTest() {
		super();
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
	
	
	
	
	
	@BeforeClass
	public void setup() throws Exception {
		initilization();

		LOGINPAGE = new LoginPage();
		homepage = new HomePage();
		compose = new ComposePage();
		homepage = LOGINPAGE.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority = 1)
	public void start() {
		compose = homepage.clickOncompose();

	}

	@Test(priority = 2, dataProvider = "getTestData")
	public void sendingmail(String SendTo, String subject, String Massegebody) {
		compose.sendmail(SendTo, subject, Massegebody);
		System.out.println("sending mail Done");
	}

	@DataProvider
	public Object[][] getTestData() throws InvalidFormatException {
		Object data[][] = TestUtil.getTestData(sheetName);
		System.out.println(data);
		return data;
	}

	@Test(priority = 2)
	public void checkSentAMail() throws InterruptedException {
		compose.CheckSentButton();
	}


	@AfterClass
	public void close() throws InterruptedException{
		Thread.sleep(5000);
		driver.quit();
	}
}

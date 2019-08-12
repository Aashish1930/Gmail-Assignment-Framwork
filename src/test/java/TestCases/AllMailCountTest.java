package TestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.gmailtest.base.TestBase;
import com.gmailtest.pages.AllMailPage;
import com.gmailtest.pages.HomePage;
import com.gmailtest.pages.LoginPage;

public class AllMailCountTest extends TestBase {

	HomePage homepage;
	LoginPage loginpage;
	AllMailPage allMail;

	public AllMailCountTest() {
		super();
	}

	@BeforeClass
	public void setup() throws Exception {
		initilization();
		homepage = new HomePage();
		loginpage = new LoginPage();
		allMail = new AllMailPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));

	}
	
	@Test
	public void AllMAilCount() throws InterruptedException{
		
		allMail=homepage.InboxMail();
		allMail.CountReadMAil();
		
		
		
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
	
	

}

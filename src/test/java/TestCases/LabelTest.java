package TestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.gmailtest.base.TestBase;
import com.gmailtest.pages.HomePage;
import com.gmailtest.pages.LabelPage;
import com.gmailtest.pages.LoginPage;

public class LabelTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	LabelPage labelpage;

	public LabelTest() {
		super();
	}

	@BeforeClass
	public void setup() throws Exception {
		initilization();
		homepage = new HomePage();
		loginpage = new LoginPage();
		labelpage = new LabelPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test
	public void Checklabel() throws InterruptedException{
		labelpage=homepage.MoveTextMasseage();
		labelpage.TestingLabel();
	}

	
	@Test
	public void CreateLabel() throws InterruptedException{
		labelpage=homepage.CreateLabel();
		labelpage.CreateLable();
	}

	@AfterClass
	public void close() throws InterruptedException{
		Thread.sleep(5000);
		driver.quit();
	}
	
	
}

package TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.gmailtest.base.TestBase;
import com.gmailtest.pages.AllMailPage;
import com.gmailtest.pages.HomePage;
import com.gmailtest.pages.LoginPage;
import com.gmailtest.pages.StarMailCountPage;

public class StarMailCountTest extends TestBase{
	
	
	HomePage homepage;
	LoginPage loginpage;
	StarMailCountPage StarMail;

	public StarMailCountTest() {
		super();
	}

	@BeforeClass
	public void setup() throws Exception {
		initilization();
		homepage = new HomePage();
		loginpage = new LoginPage();
		StarMail = new StarMailCountPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));

	}
	
	@Test
	public void CountStarMail(){

		StarMail=homepage.ClickStatMail();
		StarMail.CountAllStarMaill();
		
		
	}
	
	@BeforeClass
	public void TearDown(){
		driver.quit();
	}
	
	
	

}

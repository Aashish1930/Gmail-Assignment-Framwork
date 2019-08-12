package TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.gmailtest.base.TestBase;
import com.gmailtest.pages.AllMailPage;
import com.gmailtest.pages.HomePage;
import com.gmailtest.pages.LoginPage;
import com.gmailtest.pages.UnReadMailPage;

public class UnReadMailTest extends TestBase {

	HomePage homepage;
	LoginPage loginpage;
	UnReadMailPage Mail;

	public UnReadMailTest() {
		super();
	}

	@BeforeClass
	public void setup() throws Exception {
		initilization();
		homepage = new HomePage();
		loginpage = new LoginPage();
		Mail = new UnReadMailPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test
	public void countUnreadmail() {
		Mail.CountUnreadMAil();
	}

}

package com.gmailtest.base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.log4testng.Logger;

import com.gmailtest.testutils.ExcelApiTest;
import com.gmailtest.testutils.TestUtil;
import com.gmailtest.testutils.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static Logger log = Logger.getLogger(TestBase.class);
	public static EventFiringWebDriver e_driver;
	public static WebDriverEventListener listener;
	public static  ExcelApiTest xls;

	public TestBase() {

		try {
			prop = new Properties();
			
			FileInputStream f = new FileInputStream(
					"C:\\New folder (2)\\Selenium Project\\GmailTest\\src\\main\\java\\com\\gmail\\config\\config.properties");
			prop.load(f);
			log.info("properties file pass");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public static void initilization() throws Exception {
		
		 xls= new ExcelApiTest("C:\\Users\\Aashish\\Desktop\\Test1.xlsx");
			
		//String browsername = prop.getProperty("firefox");
		if (prop.getProperty("browser").equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"E:\\selenium\\firefox update driver\\geckodriver-v0.24.0-win32\\geckodriver.exe");
			driver = new FirefoxDriver();
			System.out.println("Firefox is Load");

		} else if (prop.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"E:\\selenium\\chrome update driver virsion 75\\chromedriver_win32(1)\\chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("Load chrome");
			log.info("browser lounched ");
			
				}
		
		
		e_driver = new EventFiringWebDriver(driver);
		listener = new WebEventListener();
		e_driver.register(listener);
		driver = e_driver;


		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLECIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}

}

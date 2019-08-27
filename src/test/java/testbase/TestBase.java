package testbase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import utilities.ReadConfig;

public class TestBase {

	ReadConfig readconfig = new ReadConfig();

	public WebDriver driver;
	public String baseURL= readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();

	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {



		logger = Logger.getLogger("gurukula");
		PropertyConfigurator.configure("log4j.properties");

		if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readconfig.getchromePath());
			driver = new ChromeDriver();
			logger.info("chrome browser opened");
		}
		else if(br.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver", readconfig.getfirefoxPath());
			driver = new FirefoxDriver();
			logger.info("firefox browser opened");
		}

		driver.manage().window().maximize();
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get(baseURL);
		logger.info("URL is opened");



	}

	@AfterClass
	public void tearDown() {

		//driver.close(); 
		driver.quit();

	}

}

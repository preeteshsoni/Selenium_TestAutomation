package testbase;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import utilities.ReadConfig;

/**
 * This class deals with all the common functions used by all the pages. This
 * class is responsible for loading the configurations from properties files,
 * Initialising the WebDriver, Implicit Waits and capture screenshots
 */

public class TestBase {

	ReadConfig readconfig = new ReadConfig();

	public WebDriver driver;
	public String baseURL = readconfig.getApplicationURL();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();

	public static Logger logger;

	/**
	 * This method runs before each test class and initialise driver and wait
	 */
	
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String browser) {

		logger = Logger.getLogger("gurukula");

		try {
			PropertyConfigurator.configure("log4j.properties");

			if (browser.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", readconfig.getchromePath());
				driver = new ChromeDriver();
				logger.info("chrome browser opened");
			} else if (browser.equals("firefox")) {

				System.setProperty("webdriver.gecko.driver", readconfig.getfirefoxPath());
				driver = new FirefoxDriver();
				logger.info("firefox browser opened");
			}

			driver.manage().window().maximize();

			// Implicit wait
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			driver.get(baseURL);
			logger.info("URL is opened");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	/**
	 * This method runs after each test class and kills driver
	 */
	
	@AfterClass
	public void tearDown() {

		// driver.close();
		 driver.quit();

	}

	/**
	 * This method captures screenshot and saves in screenshot folder
	 */
	public void captureScreen(WebDriver driver, String testCasename) throws IOException {
		
		try {
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		File source = takeScreenShot.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + testCasename + ".png");
		FileUtils.copyFile(source, target);
		}
		catch(IOException e) {
			e.printStackTrace();
		}

	}

}

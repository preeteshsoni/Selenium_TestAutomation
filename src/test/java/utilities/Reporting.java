package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * Listener class used to generate Extent reports
 */

public class Reporting extends TestListenerAdapter {
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;

	public void onStart(ITestContext testContext) {

		try {
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
			String repName = "Test-Report-" + timeStamp + ".html";

			// specify location of the report
			htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/" + repName);
			htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");

			extent = new ExtentReports();

			extent.attachReporter(htmlReporter);
			extent.setSystemInfo("Host name", "localhost");
			extent.setSystemInfo("Environemnt", "QA");
			extent.setSystemInfo("user", "admin");

			// Title of report
			htmlReporter.config().setDocumentTitle("Gurukula Test Project");

			// name of the report
			htmlReporter.config().setReportName("Functional Test Automation Report");

			// location of the chart
			htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
			htmlReporter.config().setTheme(Theme.DARK);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void onTestSuccess(ITestResult tr) {
		// create new entry in report
		logger = extent.createTest(tr.getName());

		// send the passed information to the report with GREEN color highlighted
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}

	public void onTestFailure(ITestResult tr) {
		String screenshotPath;
		File file = null;
		try {
			// create new entry in report
			logger = extent.createTest(tr.getName());

			// send the passed information to the report with GREEN color highlighted
			logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));

			screenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" + tr.getName() + ".png";

			file = new File(screenshotPath);

			if (file.exists()) {
				logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult tr) {

		// create new entry in report
		logger = extent.createTest(tr.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}

	public void onFinish(ITestContext testContext) {
		extent.flush();
	}
}

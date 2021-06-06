package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import datahelpers.CaptureScreenshot;
import io.cucumber.testng.AbstractTestNGCucumberTests;

public class TestBase extends AbstractTestNGCucumberTests{

	public static WebDriver driver;
	String ChromePath = System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe";
	String fireFoxPath = System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe";
	String phantomPath = System.getProperty("user.dir") + "\\Drivers\\phantomjs.exe";
	String URL = "https://www.nopcommerce.com/en";

	@BeforeSuite
	@Parameters({"browser"})
	public void setupEnv(@Optional("chrome") String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ChromePath);
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", fireFoxPath);
			driver = new FirefoxDriver();
		}
		
		//Headless testing 
		else if(browserName.equalsIgnoreCase("headless"))
		{
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setJavascriptEnabled(true);
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, 
					phantomPath);
			String[] PhantomArgs = {"--web-security==no","--ignore-ssl-errors=yes"};
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, PhantomArgs);
			driver = new PhantomJSDriver(caps);
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		driver.navigate().to(URL);
	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
	
	//Take screenshots when test cases fail and add it to screenshots folder 
	@AfterMethod
	public void screenshotOnFailure(ITestResult result) 
	{
		if (result.getStatus() == ITestResult.FAILURE)
		{
			System.out.println("Failed!");
			System.out.println("Taking Screenshot....");
			CaptureScreenshot.captureScreenshot(driver, result.getName());
		}
	}
	
}

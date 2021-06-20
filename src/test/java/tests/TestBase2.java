package tests;

import java.net.MalformedURLException;
import java.net.URI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.net.Urls;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.cucumber.java.Before;

public class TestBase2 {
	public static String URL = "https://www.nopcommerce.com/en";
	protected ThreadLocal<RemoteWebDriver> driver = null;
	
	@BeforeClass
	@Parameters({"browser"})
	public void setUp(String browser) throws MalformedURLException
	{
		driver = new ThreadLocal<>();
		//Desired Capabilities is a class in Selenium used to set properties of browsers
		DesiredCapabilities caps = new DesiredCapabilities();
		//class is used to set the property of a test environment like device name, OS name and version, browser name and version, absolute path of the app under test (the .apk file of the Android app under test),
		//app Activity (in Android) and appPackage(in Java).
		caps.setCapability("browserName", browser);
		driver.set(new RemoteWebDriver(new java.net.URL("http://localhost:4444/wd/hub"), caps));
		getDriver().navigate().to(URL);
	}
	public WebDriver getDriver()
	{
		return driver.get();
	}
	@AfterClass
	public void stop()
	{
		getDriver().quit();
		driver.remove();
	}
}

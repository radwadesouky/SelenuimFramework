package tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.RegistrationPage;

public class TestRegistrationPageParallel extends TestBase2 {
	HomePage homeObj;
	RegistrationPage registerObj;
	WebElement menu,registerLink;

	@DataProvider(name = "registration_testdata")
	public static Object[][] userData() {
		return new Object[][] {
			{ "radwa", "QC", "usertest4321","radwamostaf4321@gmail.com", "radwamostaf4321@gmail.com", "123456", "123456"
			},
			{ "radwa", "tester", "usertest9876","radwamostaf9876@gmail.com", "radwamostaf9876@gmail.com", "123456", "123456"
			} };
	}

	@Test(dataProvider="registration_testdata")
	public void setRegistrationInfoTest(String name,String lastname,String user,String email,String confirmMail , String pass , 
			String confirmPass ) throws InterruptedException {
		homeObj = new HomePage(getDriver());
		homeObj.builder = new Actions(getDriver());
		homeObj.openRegisterPage();
		registerObj = new RegistrationPage(getDriver());
		registerObj.registrationInfo(name,lastname,user,email,confirmMail,pass,confirmPass);
		// Thread.sleep(2000);
		assertTrue(registerObj.successMsg.getText().contains("Almost done!"));
		clickRegisterLinkAfterRegister();
	}
	public void clickRegisterLinkAfterRegister()
	{
		menu = getDriver().findElement(By.xpath("//*[@id=\"2-page\"]/body/div[6]/header/div/div[3]/div[1]/ul/li[2]/a"));
		registerLink = getDriver().findElement(By.xpath("//*[@id=\"2-page\"]/body/div[6]/header/div/div[3]/div[1]/ul/li[2]/ul/li[2]/a"));
		Actions builder = new Actions(getDriver());
		builder.contextClick(menu).moveToElement(registerLink).click().build().perform();
	}

}

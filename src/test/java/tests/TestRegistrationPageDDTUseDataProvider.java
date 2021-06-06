package tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.RegistrationPage;

public class TestRegistrationPageDDTUseDataProvider extends TestBase {

	HomePage homeObj;
	RegistrationPage registerObj;
	WebElement menu,registerLink;

	@DataProvider(name = "registration_testdata")
	public static Object[][] userData() {
		return new Object[][] {
			{ "radwa", "Moustafa", "usertest2342","radwamostaf4332@gmail.com", "radwamostaf4332@gmail.com", "123456", "123456"
			},
			{ "radwa", "test", "usertest242113","radwamostaf209123@gmail.com", "radwamostaf209123@gmail.com", "123456", "123456"
			} };
	}

	@Test(dataProvider="registration_testdata")
	public void setRegistrationInfoTest(String name,String lastname,String user,String email,String confirmMail , String pass , 
			String confirmPass ) throws InterruptedException {
		homeObj = new HomePage(driver);
		homeObj.builder = new Actions(driver);
		homeObj.openRegisterPage();
		registerObj = new RegistrationPage(driver);
		registerObj.registrationInfo(name,lastname,user,email,confirmMail,pass,confirmPass);
		// Thread.sleep(2000);
		assertTrue(registerObj.successMsg.getText().contains("Almost done!"));
		clickRegisterLinkAfterRegister();
	}
	public void clickRegisterLinkAfterRegister()
	{
		menu = driver.findElement(By.xpath("//*[@id=\"2-page\"]/body/div[6]/header/div/div[3]/div[1]/ul/li[2]/a"));
		registerLink = driver.findElement(By.xpath("//*[@id=\"2-page\"]/body/div[6]/header/div/div[3]/div[1]/ul/li[2]/ul/li[2]/a"));
		Actions builder = new Actions(driver);
		builder.contextClick(menu).moveToElement(registerLink).click().build().perform();
	}


}

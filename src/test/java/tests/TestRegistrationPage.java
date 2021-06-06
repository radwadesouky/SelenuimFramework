package tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.RegistrationPage;

public class TestRegistrationPage extends TestBase {

	HomePage homeObj;
	RegistrationPage registerObj;

	@Test
	public void setRegistrationInfoTest() throws InterruptedException {
		homeObj = new HomePage(driver);
		homeObj.builder = new Actions(driver);
		homeObj.openRegisterPage();
		registerObj = new RegistrationPage(driver);
		registerObj.registrationInfo("Radwa", "Desouky", "test4433", "radwamostafa42211@gmail.com",
				"radwamostafa42211@gmail.com", "123456", "123456");
		//Thread.sleep(2000);
	 assertTrue(registerObj.successMsg.getText().contains("Almost done!"));
	}

}

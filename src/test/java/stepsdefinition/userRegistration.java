package stepsdefinition;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.RegistrationPage;
import tests.TestBase;

public class userRegistration extends TestBase{
	HomePage homeObject ; 
	RegistrationPage registerObject ; 

	@Given("^user should be in home page$")
	public void the_user_in_the_home_page() throws Throwable {
		homeObject = new HomePage(driver); 
		homeObject.builder = new Actions(driver);
		
	}
	@When("user click on register link")
	public void user_click_on_register_link() {
		homeObject.openRegisterPage();
	}
	@When("user enters data {string}, {string}, {string}, {string},{string}, {string}, {string}")
	public void user_enters_data(String firstname, String lastname, String username, String email, String confirmEmail, 
			String pass, String confirmPass) {
		registerObject = new RegistrationPage(driver);
		registerObject.registrationInfo(firstname, lastname, username, email,
				confirmEmail, pass, confirmPass);
	   
	}
	
	@Then("The registration page will be displayed success message")
	public void the_registration_page_will_be_displayed_success_message() {
		 assertTrue(registerObject.successMsg.getText().contains("Almost done!"));
	}

}

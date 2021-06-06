package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends PageBase{

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="FirstName")
	WebElement firstName;
	
	@FindBy(id="LastName")
	WebElement lastName;
	
	@FindBy(id="Email")
	WebElement email;
	
	@FindBy(id="ConfirmEmail")
	WebElement confirmEmail;
	
	@FindBy(id="Username")
	WebElement username;
	
	@FindBy(id="Password")
	WebElement password;
	
	@FindBy(id="ConfirmPassword")
	WebElement confirmPassword;
	
	@FindBy(id="Details_CompanyIndustryId")
	WebElement mycompany;
	Select companyOptions = new Select(mycompany);
	
	@FindBy(id="Details_CompanyRoleId")
	WebElement activity;
	Select activityOptions = new Select(activity);
	
	@FindBy(id="Details_CompanySizeId")
	WebElement people;
	Select peopleOptions = new Select(people);
	
	@FindBy(id="Details_WebsitesDevelopmentPeriodId")
	WebElement websites;
	Select websitesOptions = new Select(websites);
	
	@FindBy(xpath="//*[@id=\"register-page\"]/body/div[6]/section/div/div/div/div/div/div[2]/form/div/div[3]/div[10]/div[2]/div[1]/label")
	WebElement radioBtn;
	
	@FindBy(xpath = "//*[@id=\"2-page\"]/body/div[6]/section/div/div/div/div/div/div[2]/div/h2")
	public WebElement successMsg;
	
	@FindBy(id="register-button")
	WebElement registerBtn;
	

	public void registrationInfo(String firstname , String lastname ,String user,String e_mail,String confirmE_mail,String Pass ,
			String confirmPass )
	{
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		email.sendKeys(e_mail);
		confirmEmail.sendKeys(confirmE_mail);
		username.sendKeys(user);
		password.sendKeys(Pass);
		confirmPassword.sendKeys(confirmPass);
		companyOptions.selectByIndex(1);
		activityOptions.selectByIndex(1);
		peopleOptions.selectByIndex(1);
		completeRegistrationInfo();
	}
	public void completeRegistrationInfo()
	{
		try {
		websitesOptions.selectByIndex(2);
		radioBtn.click();
		registerBtn.click();
		}
		catch (Exception e) {
			e.getMessage();
		}
	}
}

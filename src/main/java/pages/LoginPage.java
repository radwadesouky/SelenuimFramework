package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="Password")
	WebElement password;
	
	@FindBy(id="Username")
	WebElement userName;
	
	@FindBy(xpath="//*[@id=\"login-page\"]/body/div[6]/section/div/div/div/div/div/div[2]/div[1]/div[2]/form/div[2]/div[4]/input")
	WebElement loginBtn;
	
	@FindBy(xpath = "//*[@id=\"login-page\"]/body/div[6]/section/div/div/div/div/div/div[2]/div[1]/div[2]/form/div[3]/div[3]/div/label")
	public WebElement checkBox;
	
	public void login(String username,String pass)
	{
	   userName.sendKeys(username);	
	   password.sendKeys(pass);
	   loginBtn.click();
	}
	
	

}

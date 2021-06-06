package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class HomePage extends PageBase {
	
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//*[@id=\"en-page\"]/body/div[6]/header/div/div[3]/div[1]/ul/li[2]/a")
	WebElement menu;
	
	@FindBy(xpath = "//*[@id=\"en-page\"]/body/div[6]/header/div/div[3]/div[1]/ul/li[2]/ul/li[2]/a")
	WebElement registerLink;
	
	@FindBy(xpath ="//*[@id=\"en-page\"]/body/div[6]/header/div/div[3]/div[1]/ul/li[2]/ul/li[1]/a")
	WebElement loginLink;
	
	
	public Actions builder ;
	public void openRegisterPage() {
		builder.contextClick(menu).moveToElement(registerLink).click().build().perform();
	}
	public void openLoginPage() {
		builder.contextClick(menu).moveToElement(loginLink).click().build().perform();
	}
	

}

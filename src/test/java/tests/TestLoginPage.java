package tests;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import testdata.ExcelReader;

public class TestLoginPage extends TestBase{
	HomePage homeObj;
	LoginPage loginObj;
	
	@DataProvider(name = "loginData")
	public Object[][] getLoginData() throws IOException
	{
		ExcelReader ER = new ExcelReader();
		return ER.getExcelData();
	}
	
	@Test(dataProvider="loginData")
	public void testLogin(String username , String pass)
	{
		homeObj = new HomePage(driver);
		homeObj.builder = new Actions(driver);
		homeObj.openLoginPage();
		loginObj = new LoginPage(driver);
		loginObj.login(username, pass);
		assertFalse(loginObj.checkBox.isSelected());
	}
}

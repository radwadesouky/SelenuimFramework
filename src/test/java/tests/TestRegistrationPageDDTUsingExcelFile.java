package tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.RegistrationPage;
import testdata.ExcelReader;

public class TestRegistrationPageDDTUsingExcelFile extends TestBase {

	HomePage homeObj;
	RegistrationPage registerObj;

	@DataProvider(name="testdataExcel")
	public Object[][] userRegistaerData() throws IOException
			{
		      // Get data from excel reader
		      ExcelReader data=new ExcelReader();
		      return data.getExcelData();
			}
	@Test(dataProvider="testdataExcel")
	public void setRegistrationInfoTest(String name,String lastname,String user,String email,String confirmMail , String pass , 
			String confirmPass ) throws InterruptedException {
		homeObj = new HomePage(driver);
		homeObj.builder = new Actions(driver);
		homeObj.openRegisterPage();
		registerObj = new RegistrationPage(driver);
		registerObj.registrationInfo(name,lastname,user,email,confirmMail,pass,confirmPass);
		//Thread.sleep(2000);
	 assertTrue(registerObj.successMsg.getText().contains("Almost done!"));
	}

}

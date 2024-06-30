package tests;

import org.testng.annotations.Test;

import pages.LoginPage;
import tests.models.ModelsProcess;
import tests.models.Login;

public class LoginTest extends TestCase {
	/*
	 * Test Steps
	 * 1. Open website
	 * 2. Input all valid data
	 * 3. Click login
	 * 4. Login successfully
	 */
	@Test
	public void loginSuccessfully() {
		ModelsProcess modelsProcess= new ModelsProcess();
		String testData = "LoginData.csv";
		Login login= modelsProcess.convertLoginFromCsv(testData);
		
		
		LoginPage loginPage= new LoginPage(testBase.driver);
		//testBase.driver.navigate().to("https://www.saucedemo.com/");
		loginPage.inputData(login);
		
	}

}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import tests.models.Login;

public class LoginPage extends Page {
	
	By txtUserName = By.id("user-name");
	By txtPassword = By.id("password");
	By btnLogin= By.id("login-button");

	public LoginPage(WebDriver dr) {
		super(dr);
	}

	public void inputData(Login register) {
        testBase.inputText(txtUserName, register.username, 0);
        testBase.inputText(txtPassword, register.password, 0);
        testBase.clickByLocator(btnLogin);
		
	}

}

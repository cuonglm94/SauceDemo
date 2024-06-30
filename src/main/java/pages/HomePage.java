package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends Page{
	public By linkRegister=By.linkText("Register");

	public HomePage(WebDriver dr) {
		super(dr);
		// TODO Auto-generated constructor stub
	}
	
	public LoginPage clickOnRegister() {
		driverWeb.findElement(linkRegister).click();
		return new LoginPage(driverWeb);
	}

}

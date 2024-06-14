package pages;

import org.openqa.selenium.WebDriver;

import common.Configuration;
import common.TestBase;

public class Page {
	
	//khởi tạo biến toàn cục trong class Page
	public WebDriver driverWeb;
	//Kế thừa Has-A đến Class TestBase
	public TestBase testBase= new TestBase();
	
	public Configuration config = new Configuration(System.getProperty("user.dir")+"\\config\\"+"Configuration.properties");
//	public int timeout_short = Integer.parseInt(config.getConfigValueByKey("timeout_short"));
	
	//Khởi tạo hàm constructor
	public Page(WebDriver dr) {
		//super();
		testBase.driver = dr;
		this.driverWeb = testBase.driver;
	}
	
	
	

}

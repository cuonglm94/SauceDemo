package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import common.Configuration;
import common.TestBase;

public class TestCase {
	public TestBase testBase= new TestBase();
	
	public Configuration config = new Configuration(
			System.getProperty("user.dir") + "\\config\\Configurations.properties");

	@Parameters({ "browser" })
	@BeforeMethod
	public void openBrowser(String browser) {
		String url = config.getConfigValueByKey("URL");
		testBase.openSingleBrowser(url, browser);
	}

}

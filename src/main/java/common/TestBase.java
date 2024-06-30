package common;

import java.time.Duration;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TestBase {
	public WebDriver driver;
	
	//Mở trình duyệt
	public void openSingleBrowser(String url, String brower) {
		if(brower.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
			 driver= new ChromeDriver();
			
		}else if(brower.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\driver\\msedgedriver.exe");
			driver = new EdgeDriver();
		}

		//Gõ url
		//driver.get("https://demoqa.com/");
		driver.get(url);		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		//maximize màn hình
		driver.manage().window().maximize();
	}
	
	//scroll to end page
	public void scrollToEndPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	/**
	 * Kiểm tra element hiển thị rồi mới click
	 * @param locator
	 * @param timeBySecond
	 */
	public void clickToElement(By locator, int timeBySecond) {
		WebElement e= driver.findElement(locator);
		waitForElementDisplayed(e, timeBySecond);
		if(e.isDisplayed()) {
			e.click();
		}else {
			System.out.println("Element not found after "+ timeBySecond +"second");
		}
	}
	
	/*
	 * Input text to textbox
	 */
	public void inputText(By locator, String text, int timeBySecond) {
		WebElement e= driver.findElement(locator);
		waitForElementDisplayed(e, timeBySecond);
		if(e.isDisplayed()) {
			e.sendKeys(text);
		}else {
			System.out.println("Element not found after "+ timeBySecond +"second");
		}
	}
	
	//room nhỏ màn hình
	public void zoomOut() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom = '50%'");
	}
	
	//hàm lấy giá trị attribute trả về
	public String getValueOfAttribute(By locator,String attributeName) {
		String result="";
		result= driver.findElement(locator).getAttribute(attributeName);
		return result;
	}
	
	/**
	 * Wait for element displayed
	 * @param timeBySecond
	 */
	public void waitForElementDisplayed(WebElement element, int timeBySecond) {
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
	    wait.until(d -> element.isDisplayed());
	}
	
	public String getText(By locator, int timeBySecond) {
		String result="";	
		WebElement e= driver.findElement(locator);
		waitForElementDisplayed(e, timeBySecond);
		if(e.isDisplayed()) {
			result= e.getText();
		}else {
			System.out.println("Element not found after "+ timeBySecond +"second");
		}
		return result;
	}
	
	public void switchNewWindowByClick(By locator, int timeBySecond) {
		String originalWindow = driver.getWindowHandle();
		System.out.println("originalWindow: "+ originalWindow);
		clickToElement(locator, timeBySecond);
		
		

		// Loop through until we find a new window handle
		for (String windowHandle : driver.getWindowHandles()) {
			System.out.println("sjfb"+ windowHandle);
		//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeBySecond));
			if (!windowHandle.equalsIgnoreCase(originalWindow)) {
				
				System.out.println("driver1: "+ driver);	
				
				driver.switchTo().window(windowHandle);
				System.out.println("driver2: "+ driver);	
				String s1=driver.findElement(By.xpath("//body")).getText();
				System.out.println("dsnfkndsfk"+s1);
				break;
			}
		}
	}
	
	/*
	 * getText lay gia tri text cua phan tu
	 */
	public String getTextByLocator(By locator) {
		String result= driver.findElement(locator).getText();
		return result;
	}
	
	/*
	 * clickByLocator click vao mot phan tu element
	 */
	
	public void clickByLocator(By locator) {
		driver.findElement(locator).click();
	}

}

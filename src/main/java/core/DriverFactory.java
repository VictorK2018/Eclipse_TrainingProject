package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
protected WebDriver driver = null;
	
	public WebDriver getDriver(String browserName) {
		
		/*
		 * String browser = browserName.toLowerCase(); if(browser.equals("chrome")) {
		 * System.setProperty("webdriver.chrome.driver",
		 * "C:\\... chromedriver.exe"); driver = new
		 * ChromeDriver(); }else if(browser.equals("firefox")) {
		 * System.setProperty("webdriver.gecko.driver",
		 * "C:\\... geckodriver-v0.28.0-win64\\geckodriver.exe"); driver =
		 * new FirefoxDriver(); } return driver;
		 */
		
		String browser = browserName.toLowerCase();
		if(browser.equals("chrome")) {
			driver = new ChromeDriver();
		}
		
		else if (browser.equals("firefox")) {
			driver =new FirefoxDriver();
		}
		
		else if (browser.equals("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\victo\\Downloads\\msedgedriver.exe");
			driver = new EdgeDriver ();
		}
				
		return driver;
	}
	
	public void quitDriver() {
		if(driver!=null) {
			driver.quit();
		}
	}

}

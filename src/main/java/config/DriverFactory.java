package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.Toolkit;

public class DriverFactory {
	public static WebDriver driver;

	public DriverFactory(){
		
		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver.manage().window().maximize();
		driver.get("https://developer.clashroyale.com/");

	}

	public static WebDriver getDriver() {
		return driver;
	}
	public static WebDriver killDriver() {
		driver.quit();
		return driver;
	}
}

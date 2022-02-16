package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import config.DriverFactory;

public class AccountPage {
	
	private By btnCreateKey = By.xpath("//a[@class='create-key-btn btn btn-icon btn-primary btn-lg']");
	private By btnApiKey = By.xpath("//li[@class='api-key']");

	
	public WebElement getBtnCreateKey() {
		return DriverFactory.getDriver().findElement(btnCreateKey);
	}
	public WebElement getBtnApiKey() {
		return DriverFactory.getDriver().findElement(btnApiKey);
	}
	

	
	
	
}

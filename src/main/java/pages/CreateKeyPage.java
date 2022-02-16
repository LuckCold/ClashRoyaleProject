package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import config.DriverFactory;

public class CreateKeyPage {
	private By cmpKeyName = By.id("name");
	private By cmpDescription = By.id("description");
	private By cmpAllowedIp = By.id("range-0");
	private By btnCreateKey = By.xpath("//button[@type='submit']");
	private By cmpKeyText = By.xpath("//samp");

	
	public WebElement getCmpKeyName() {
		return DriverFactory.getDriver().findElement(cmpKeyName);
	}
	public WebElement getCmpDescription() {
		return DriverFactory.getDriver().findElement(cmpDescription);
	}
	public WebElement getCmpAllowedIp() {
		return DriverFactory.getDriver().findElement(cmpAllowedIp);
	}
	public WebElement getBtnAddKey() {
		return DriverFactory.getDriver().findElement(btnCreateKey);
	}
	public WebElement getKeyText() {
		return DriverFactory.getDriver().findElement(cmpKeyText);
	}

}

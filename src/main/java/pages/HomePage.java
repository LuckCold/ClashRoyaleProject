package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import config.DriverFactory;

public class HomePage {

	private By btnPageLogin = By.xpath("//div/a[@href='#/login']");
	private By btnDaConta = By.xpath("//button[@type='button']");
	private By btnMyAccount = By.xpath("//div[@class='login-menu']//li/a[@href='#/account']");

	public WebElement getBtnPageLogin() {
		return DriverFactory.getDriver().findElement(btnPageLogin);
	}

	public WebElement getBtnDaConta() {
		return DriverFactory.getDriver().findElement(btnDaConta);
	}
	public WebElement getBtnMyAccount() {
		return DriverFactory.getDriver().findElement(btnMyAccount);
	}

}

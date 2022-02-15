package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import config.DriverFactory;

public class LoginPage {
	private By cmpEmail = By.id("email");
	private By cmpSenha = By.id("password");
	private By btnLogin = By.xpath("//button[@type='submit']");
	
	public WebElement getCmpEmail() {
		return DriverFactory.getDriver().findElement(cmpEmail);
	}
	public WebElement getCmpSenha() {
		return DriverFactory.getDriver().findElement(cmpSenha);
	}
	public WebElement getBtnLogin() {
		return DriverFactory.getDriver().findElement(btnLogin);
	}
}

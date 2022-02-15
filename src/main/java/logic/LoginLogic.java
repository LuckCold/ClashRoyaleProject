package logic;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.DriverFactory;
import pages.HomePage;
import pages.LoginPage;

public class LoginLogic {
	private HomePage homePage;
	private LoginPage loginPage;
	WebDriverWait wait;
	
	String email = "lucasmoreno389@gmail.com";
	String senha = "";
	
	public LoginLogic() {
		homePage = new HomePage();
		loginPage = new LoginPage();
	}

	public void clicoBtnPageLogin() throws InterruptedException {
		Thread.sleep(3000);
		homePage.getBtnPageLogin().click();
	}
	public void textEmail() throws InterruptedException {
		loginPage.getCmpEmail().click();
		loginPage.getCmpEmail().sendKeys(email);
	}
	public void textPass() throws InterruptedException {
		loginPage.getCmpSenha().click();
		loginPage.getCmpSenha().sendKeys(senha);
	}
	public void clicoBtnLogin() throws InterruptedException {
		loginPage.getBtnLogin().click();
	}
	
}




package logic;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.DriverFactory;
import pages.HomePage;
import pages.LoginPage;
import utils.Logger;

public class LoginLogic {
	private HomePage homePage;
	private LoginPage loginPage;
	private Logger log;
	WebDriverWait wait;
	
	String email = "lucasmoreno389@gmail.com";
	String senha = "";
	
	public LoginLogic() {
		homePage = new HomePage();
		loginPage = new LoginPage();
		log = new Logger();
	}

	public void clicoBtnPageLogin() throws InterruptedException {
		Thread.sleep(3000);
		try {
			log.getRegistro("Clico no botão de login");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		homePage.getBtnPageLogin().click();
	}
	public void textEmail() throws InterruptedException {
		try {
			log.getRegistro("Digito email");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loginPage.getCmpEmail().click();
		loginPage.getCmpEmail().sendKeys(email);
	}
	public void textPass() throws InterruptedException {
		try {
			log.getRegistro("Digito senha");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loginPage.getCmpSenha().click();
		loginPage.getCmpSenha().sendKeys(senha);
	}
	public void clicoBtnLogin() throws InterruptedException {
		try {
			log.getRegistro("Faço login");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loginPage.getBtnLogin().click();
	}
	
}




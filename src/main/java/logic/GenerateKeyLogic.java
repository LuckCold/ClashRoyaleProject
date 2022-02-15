package logic;

import java.io.IOException;
import java.net.UnknownHostException;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.DriverFactory;
import pages.HomePage;
import pages.LoginPage;
import utils.GenerateIP;
import pages.AccountPage;
import pages.CreateKeyPage;

public class GenerateKeyLogic extends DriverFactory{
	private AccountPage accountPage;
	private HomePage homePage;
	private CreateKeyPage createKeyPage;
	private GenerateIP generateIp;
	String key;
	
	
	public GenerateKeyLogic(){
		accountPage = new AccountPage();
		homePage = new HomePage();
		createKeyPage = new CreateKeyPage();
		generateIp = new GenerateIP(); 
	}
	
	public void clicoBtnMyAccount() throws InterruptedException {
		Thread.sleep(3000);
		homePage.getBtnDaConta().click();;
		homePage.getBtnMyAccount().click();;
	}
	public void clicoBtnCreateNewKey() throws InterruptedException, UnknownHostException {
		Thread.sleep(1500);
		try {
			accountPage.getBtnApiKey().isDisplayed();
		}catch(NoSuchElementException e) {
			accountPage.getBtnCreateKey().click();
			createKeyPage.getCmpKeyName().sendKeys("Meu PC");
			createKeyPage.getCmpDescription().sendKeys("Meu PC");
			createKeyPage.getCmpAllowedIp().sendKeys(generateIp.getIp());
			createKeyPage.getBtnAddKey().click();	
		}
		
	}
	public void copioKeyText() throws InterruptedException {
		Thread.sleep(2000);
		accountPage.getBtnApiKey().click();
		key = createKeyPage.getKeyText().getText();
		
		
	}
	public String getKey() {
		DriverFactory.killDriver();
		return key;
	}
}

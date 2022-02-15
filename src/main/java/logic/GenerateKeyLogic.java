package logic;

import java.io.IOException;
import java.net.UnknownHostException;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.DriverFactory;
import pages.HomePage;
import pages.LoginPage;
import utils.GenerateIP;
import utils.Logger;
import pages.AccountPage;
import pages.CreateKeyPage;

public class GenerateKeyLogic extends DriverFactory{
	private AccountPage accountPage;
	private HomePage homePage;
	private CreateKeyPage createKeyPage;
	private GenerateIP generateIp;
	private Logger log;
	String key;
	
	
	public GenerateKeyLogic(){
		accountPage = new AccountPage();
		homePage = new HomePage();
		createKeyPage = new CreateKeyPage();
		generateIp = new GenerateIP();
		log = new Logger();
		
	}
	
	public void clicoBtnMyAccount() throws InterruptedException {
		Thread.sleep(3000);
		homePage.getBtnDaConta().click();
		homePage.getBtnMyAccount().click();
		try {
			log.getRegistro("Clico no botão 'My Account'");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void clicoBtnCreateNewKey() throws InterruptedException, UnknownHostException {
		Thread.sleep(1500);
		try {
			accountPage.getBtnApiKey().isDisplayed();
			try {
				log.getRegistro("Chave já criada. Acesso a chave criada.'");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(NoSuchElementException e) {
			try {
				log.getRegistro("Chave não criada. Crio uma nova");
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			accountPage.getBtnCreateKey().click();
			createKeyPage.getCmpKeyName().sendKeys("Meu PC");
			createKeyPage.getCmpDescription().sendKeys("Meu PC");
			createKeyPage.getCmpAllowedIp().sendKeys(generateIp.getIp());
			createKeyPage.getBtnAddKey().click();	
		}
		
	}
	public void copioKeyText() throws InterruptedException {
		
		Thread.sleep(2000);
		try {
			log.getRegistro("Copio a chave da API'");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		accountPage.getBtnApiKey().click();
		key = createKeyPage.getKeyText().getText();
		
		
	}
	public String getKey() throws InterruptedException {
		Thread.sleep(1000);
		DriverFactory.killDriver();
		return key;
	}
}

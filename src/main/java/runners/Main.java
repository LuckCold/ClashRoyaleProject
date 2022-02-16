package runners;

import java.io.IOException;
import java.text.SimpleDateFormat;

import logic.GenerateKeyLogic;
import logic.LoginLogic;
import utils.Clans;
import utils.Logger;

import java.util.Calendar;

public class Main {

	public static void main(String[] args) throws InterruptedException, IOException {
		LoginLogic login = new LoginLogic();
		GenerateKeyLogic account = new GenerateKeyLogic();
		Logger log = new Logger();
		

		// Fazer Login
		log.getDate();
		login.clicoBtnPageLogin();
		login.textEmail();
		login.textPass();
		login.clicoBtnLogin();
		// Acessar Conta
		account.clicoBtnMyAccount();

		// Gerar chave
		account.clicoBtnCreateNewKey();

		// pegar API key
		account.copioKeyText();
		Clans clans = new Clans(account.getKey(), "Resistance", "57000038");
		clans.getClanMembers();
	}
}

package runners;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;

import config.DriverFactory;

import logic.GenerateKeyLogic;
import logic.LoginLogic;
import utils.Clans;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {

	public static void main(String[] args) throws InterruptedException, IOException {
		LoginLogic login = new LoginLogic();
		GenerateKeyLogic account = new GenerateKeyLogic();
		FileOutputStream os = new FileOutputStream("F:\\Eclipse\\clashroyaleproject\\log.txt");
		Writer wr = new OutputStreamWriter(os);
		BufferedWriter br = new BufferedWriter(wr);
		Calendar agora = Calendar.getInstance();
		SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss Z");
		String a = s.format(agora.getTime());

		try {
			br.write(a);
			br.newLine();
			br.write("Clico no botão de Login da página.");
			// Fazer Login
			login.clicoBtnPageLogin();
			br.newLine();
			br.write("Digito email e senha");
			login.textEmail();
			login.textPass();
			br.newLine();
			br.write("Clico botão pra logar");
			login.clicoBtnLogin();
			// Acessar Conta
			account.clicoBtnMyAccount();

			// Gerar chave
			br.newLine();
			br.write("Crio uma nova key");
			account.clicoBtnCreateNewKey();

			// pegar API key
			br.newLine();
			br.write("Copio nova key");
			br.close();
			account.copioKeyText();
			Clans clans = new Clans(account.getKey(), "Resistance", "57000038");
			clans.getClanMembers();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

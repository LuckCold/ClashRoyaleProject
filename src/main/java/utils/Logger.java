package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Logger {
	Calendar agora = Calendar.getInstance();
	SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss Z");
	String a = time.format(agora.getTime());
	SimpleDateFormat data = new SimpleDateFormat("dd/MM/yy");
	String b = data.format(agora.getTime());

	public Logger() {
		return;
	}
	public void getDate() throws IOException {
		PrintWriter p = new PrintWriter(new FileWriter("F:\\Eclipse\\ClashRoyaleProject\\.log", true));
		p.println("<-------------------------------"+ b + "------------------------------->");
		p.close();
	}

	public void getRegistro(String str) throws IOException {
		PrintWriter p = new PrintWriter(new FileWriter("F:\\Eclipse\\ClashRoyaleProject\\.log", true));
		p.println(a + "  -->  " + str);
		p.close();
	}
}

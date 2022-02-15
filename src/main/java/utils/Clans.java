package utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.sun.org.slf4j.internal.Logger;

import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;
import logic.GenerateKeyLogic;
import pages.CreateKeyPage;

public class Clans {
	String ListaClans;
	String TOKEN;
	String clanName;
	String locationId;
	String clanInfo;
	
	public Clans(String TOKEN, String clanName, String LocationId) {
		this.TOKEN = TOKEN;
		this.clanName = clanName;
		this.locationId = LocationId;
		ListaClans = "https://api.clashroyale.com/v1/clans?name=" + clanName + "&locationId=" + LocationId;
	}
	
	
	public void getClanMembers() {
		
		
		String clansInfo = Unirest.get(ListaClans)
				.header("Accept", "application/json")
				.header("authorization", "Bearer "+TOKEN)
				.asString()
				.getBody();
		JSONObject objAllClans = new JSONObject(clansInfo);
		JSONArray items = objAllClans.getJSONArray("items");
		String tagCompleta = null;
		
		for(Object clans:items) {
			JSONObject jsonLineItem = (JSONObject) clans;
			String key = jsonLineItem.getString("tag");
			if(key.contains("#9V2Y")){
				tagCompleta = key.toString();
			}
		}
		String tagSemHashTag = tagCompleta.replace("#", "");
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheetMembers = workbook.createSheet("info");
		
		String clanInfo = Unirest.get("https://api.clashroyale.com/v1/clans/%23" + tagSemHashTag + "/members")
				.header("Accept", "application/json")
				.header("authorization", "Bearer "+TOKEN)
				.asString()
				.getBody();
		JSONObject objMembers = new JSONObject(clanInfo);
		JSONArray arrMembers = objMembers.getJSONArray("items");
		int rowNum = 0;
		for(Object members:arrMembers) {
			JSONObject member = (JSONObject) members;
			Row row = sheetMembers.createRow(rowNum++);
			int cellNum = 0;
			Cell cellName = row.createCell(cellNum++);
			cellName.setCellValue(member.get("name").toString());
			Cell cellExpLvl = row.createCell(cellNum++);
			cellExpLvl.setCellValue(member.get("expLevel").toString());
			Cell cellTrophies = row.createCell(cellNum++);
			cellTrophies.setCellValue(member.get("trophies").toString());
			Cell cellRole = row.createCell(cellNum++);
			cellRole.setCellValue(member.get("role").toString());
			try {
				FileOutputStream out = new FileOutputStream(new File("F:\\Eclipse\\clashroyaleproject\\src\\main\\resources\\info.xls"));
				workbook.write(out);
				out.close();
				System.out.println("Arquivo criado com sucesso!");
			}catch(FileNotFoundException e) {
				e.printStackTrace();
				System.out.println("Arquivo não encontrado");
			}catch(IOException e) {
				e.printStackTrace();
				System.out.println("Erro na edição do arquivo!");
			}
			
		}
	}
}

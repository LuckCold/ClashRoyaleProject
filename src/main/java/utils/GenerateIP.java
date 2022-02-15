package utils;

import kong.unirest.GetRequest;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

public class GenerateIP {
	public String getIp() {
		String url = Unirest.get("https://api.ipify.org/")
				.asString()
				.getBody();
		return url;
	}

}
package application;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
public class ViaCepAdress {
	
	public Adress pesquisar(String cep) {
		String url = "https://viacep.com.br/ws/" + cep + "/json/";
		
		HttpClient adress = HttpClient.newHttpClient();
		
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(url))
                .GET()
                .build();
		
		try {
			HttpResponse<String> response = adress.send(request,HttpResponse.BodyHandlers.ofString());
			if (response.statusCode() == 200) {
				String json = response.body();
				String bairro = extractValueFromJson(json,"bairro");
				String logradouro = extractValueFromJson(json,"logradouro");
				String cidade = extractValueFromJson(json,"localidade");
				String estado = extractValueFromJson(json,"uf");
				return new Adress(logradouro, null, cidade, estado, null, 0, null, null, bairro, null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	public String extractValueFromJson(String json, String key) {
		String searchKey = "\""+ key +"\":";
		int startIndex = json.indexOf(searchKey);
		
		if (startIndex == -1) {
			return null;
		}
		
		startIndex += searchKey.length();
		char firstChar = json.charAt(startIndex);
		
		
		if (firstChar == '"') {
			startIndex++;
			int endIndex = json.indexOf("\"",startIndex);
			return json.substring(startIndex,endIndex);
		}else {
			int endIndex = json.indexOf(",",startIndex);
			if(endIndex == -1) {
				endIndex = json.indexOf("}",startIndex);
			}
		return json.substring(startIndex,endIndex).trim();
		}
		
		
	}

}

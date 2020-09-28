package rest;

import java.util.Map;

import io.restassured.response.Response;

public class SystemPublicUsers extends BaseRest{
	private final String url = "https://api.octoperf.com/public/users";
	
	public Response login(String ruta, Map<String, String> map) throws Exception {
		return consultarPostConParametros(url, ruta, map);
	}
}

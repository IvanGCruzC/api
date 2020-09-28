package rest;

import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseRest {
	
	public Response consultarPostConParametros(String url, String servicio, Map<String, String> map) throws Exception {
		RequestSpecification request = obtenerRequest(url);
		return request.queryParams(map).post(servicio);
	}
	
	private RequestSpecification obtenerRequest(String url) throws Exception {
		RestAssured.baseURI = url;
		RequestSpecification request = RestAssured.given();
		return request;
	}
}

package steps;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import io.cucumber.datatable.DataTable;
import io.restassured.response.Response;
import rest.SystemPublicUsers;

public class SystemPublicUsersSteps {
	private SystemPublicUsers systemPublicUsers = new SystemPublicUsers();
	private Response response;
	
	@Cuando("consulto POST {string} con parametros")
	public void consulto_POST_con_parametros(String ruta, DataTable dataTable) throws Exception {
		Map<String, String> queryParams = new HashMap<String, String>();
		
		for (Map<String, String> data : dataTable.asMaps()) {
			queryParams = data;
		}
		
		response = systemPublicUsers.login(ruta, queryParams);
	}

	@Entonces("el status es {int}")
	public void el_status_es(int status) {
		Assert.assertEquals("status code", status, response.getStatusCode());
	}

	@Entonces("en el body el {string} es {string}")
	public void en_el_body_el_es(String key, String valor) {
		Assert.assertEquals(valor, response.jsonPath().get(key));
	}

}

package RequestChaining;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Scenario_3_getPayrollInfo {
	@Test
	public void SampleTest() {
		
	
     //API==>1 get Auth API==>1
	Response resp=given()
	.formParam("client_id", "ninza-client")
	.formParam("client_secret", "gPQBf1Yxew5OMccMhzos1GefIyiSnXzM")
	.formParam("grant_type", "client_credentials")
	
	.when()
	.post("http://49.249.28.218:8180/auth/realms/ninza/protocol/openid-connect/token");
	resp.then().log().all();
	
	//capture the token from the response
	String token=resp.jsonPath().get("access_token");
	
	//API-2 get payroll info
	given()
	.auth().oauth2(token)
	.get("http://49.249.28.218:8091/admin/payrolls")
	.then().log().all();
	
  }
}

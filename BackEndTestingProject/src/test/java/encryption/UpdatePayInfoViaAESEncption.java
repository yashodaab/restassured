package encryption;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;
public class UpdatePayInfoViaAESEncption {
	@Test
	public void sampleTest() throws Exception {
	
		EncrypAndDecryptUtility ed=new EncrypAndDecryptUtility();
		String jbody="{ \"employee\": { \"empId\":\"NH_00257\", \"designation\": \"SoftwareEngineer\", \"dob\": \"04/05/1996\", \"email\": \"yashodayashu@gmail.com\", \"empName\": \"Yashoda_4955\", \"experience\": 4.0, \"mobileNo\": \"9874563219\", \"project\": \"Airtel_4955\", \"role\": \"ROLE_EMPLOYEE\", \"username\": “user_4955” }, \"basicPlusVda\": 100, \"hra\": 100, \"insurance\": 100, \"lta\": 100, \"lwf\": 100, \"netPay\": 500, \"payroll_id\": 222, \"pf\": 100, \"pt\": 100, \"stat_bonus\": 100, \"status\": “Active” }";	
		String jreqbody=ed.encrypt(jbody,"Ac03tEam@j!tu_#1");
		System.out.println(jreqbody);
		
	Response resp=given()
		.body(jreqbody)
		.when()
		.put("http://49.249.28.218:8091/payroll");
		resp.then().log().all();
		
		String respbody=ed.decrypt(resp.getBody().asString(),"Ac03tEam@j!tu_#1");
		System.out.println(respbody);
	}

}

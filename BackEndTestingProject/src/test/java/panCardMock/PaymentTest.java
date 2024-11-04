package panCardMock;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
public class PaymentTest {
	//To run this program creditcardmock should be in running mood 
	// or else we can create a .jar file exporting that creditcardmock from the different package and run in cmd line 
	@Test
	public void sampleTest() {
		JSONObject obj=new JSONObject();
		obj.put("creditcard", "1234567891234");
		obj.put("cvv", "123");
		obj.put("cardName", "Yashoda");
		
		given()
		.contentType(ContentType.JSON)
		.body(obj)
		.when()
		.post("http://localhost:8889/credit-card")
		.then().log().all();
	}

}

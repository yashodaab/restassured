package practice.postRequestTypes;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PostReq_Vai_JSonObject {
	@Test
	
	public void postDataToServer() {
	
	JSONObject jsonObj=new JSONObject();
	jsonObj.put("createdBy","Yashoda");
	jsonObj.put("status", "created");
	jsonObj.put("teamsize",10);
	jsonObj.put("projectName", "orange 5");
	
	given().contentType(ContentType.JSON)
	.body(jsonObj.toJSONString())
	.when()
	.post("http://49.249.28.218:8091/addProject")
	.then()
	.assertThat().statusCode(201)
	.log().all();
	 
	}
}

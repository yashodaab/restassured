package practice.postRequestTypes;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostReq_Vai_HashMapTest {
@Test
	
	public void postDataToServer() {
	
	HashMap<String, Object> map=new HashMap();
	map.put("createdBy","Yashoda");
	map.put("status", "created");
	map.put("teamsize",10);
	map.put("projectName", "orange 6");
	
	given().contentType(ContentType.JSON)
	.body(map)
	.when()
	.post("http://49.249.28.218:8091/addProject")
	.then()
	.assertThat().statusCode(201)
	.log().all();
	
	}
}

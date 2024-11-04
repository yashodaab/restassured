package practice.postRequestTypes;

import static io.restassured.RestAssured.*;
import java.io.File;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

public class postReq_Vai_JsonFileTest {
@Test
	
	public void postDataToServer() {
	File fileobj=new File("./pro.json");
	
	
		given().contentType(ContentType.JSON)
	.body(fileobj)
	.when()
	.post("http://49.249.28.218:8091/addProject")
	.then()
	.assertThat().statusCode(201)
	.log().all();
	 
	}
}



package practice.postRequestTypes;

import static io.restassured.RestAssured.*;
import java.io.File;
import java.util.Random;

import org.testng.annotations.Test;

import PojoClass .Utility.ProjectPojo;
import io.restassured.http.ContentType;

public class postReq_Vai_PojoClassFileTest4 {
@Test
	
	public void postDataToServer() {
	
	//create an object to pojo class
	Random random=new Random();
	int ranNum = random.nextInt(5000);
	
	ProjectPojo pobj= new ProjectPojo("Orange"+ranNum, "created", "Yashoda", 10);
		given().contentType(ContentType.JSON)
	.body(pobj)
	.when()
	.post("http://49.249.28.218:8091/addProject")
	.then()
	.assertThat().statusCode(201)
	.log().all();
	 
	}

}



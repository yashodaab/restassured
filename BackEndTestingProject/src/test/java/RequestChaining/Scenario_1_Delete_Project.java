package RequestChaining;

import static io.restassured.RestAssured.*;
import java.io.File;
import java.util.Random;

import org.testng.annotations.Test;

import PojoClass.Utility.ProjectPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Scenario_1_Delete_Project {
	@Test

	public void postDataToServer() {

		// create an object to pojo class
		Random random = new Random();
		int ranNum = random.nextInt(5000);

		// Api-1==>add a project inside the server
		ProjectPojo pobj = new ProjectPojo("Airtel_" + ranNum, "created", "Yashoda", 10);

		Response resp = given().contentType(ContentType.JSON).body(pobj).when()
				.post("http://49.249.28.218:8091/addProject");
		resp.then().assertThat().statusCode(201).log().all();

		// capture project name from the response
		String projectId = resp.jsonPath().get("projectId");
		System.out.println(projectId);

		// Api-2 ==>Delete Project
		given().delete("http://49.249.28.218:8091/project/" + projectId).then().log().all();

	}

}

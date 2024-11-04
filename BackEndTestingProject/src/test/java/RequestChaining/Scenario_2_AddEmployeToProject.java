package RequestChaining;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.testng.annotations.Test;

import PojoClass.Utility.EmployeePOJO;
import PojoClass.Utility.ProjectPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Scenario_2_AddEmployeToProject {
	@Test
	public void SampleTest() {
		// create an object to pojo class
		Random random = new Random();
		int ranNum = random.nextInt(5000);

		// Api-1==>add a project inside the server
		ProjectPojo pobj = new ProjectPojo("Airtel_" + ranNum, "created", "Yashoda", 10);

		Response resp = given().contentType(ContentType.JSON).body(pobj).when()
				.post("http://49.249.28.218:8091/addProject");
		resp.then().assertThat().statusCode(201).log().all();

		// capture project name from the response
		String projectName = resp.jsonPath().get("projectName");
		System.out.println(projectName);

		// Api-2 ==>Add employee to same project

		EmployeePOJO empobj = new EmployeePOJO("SoftwareEngineer", "04/05/1996", "yashodayashu@gmail.com", "Yashoda_" + ranNum,
				4, "9874563219", projectName, "ROLE_EMPLOYEE", "user_" + ranNum);
		given().contentType(ContentType.JSON).body(empobj).when().post("http://49.249.28.218:8091/employees").then()
				.assertThat().statusCode(201).log().all();

	}
}

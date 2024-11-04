package PracticeresponseValidation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;

public class VerifyResponseBody_Vai_JsonPath {
@Test
public void sampleTest() {
	Response resp= given()
	.get("http://49.249.28.218:8091/projects-paginated");
	resp.then().log().all();
	
	resp.then().assertThat().body("numberOfElements", Matchers.greaterThanOrEqualTo(20));
	resp.then().assertThat().body("empty", Matchers.equalTo(false));
	resp.then().assertThat().body("pageable.sort.unsorted", Matchers.equalTo(true));
	resp.then().assertThat().body("content[0].projectName",Matchers.equalTo("Airtel_925"));
	resp.then().assertThat().body("content[3].createdOn", Matchers.equalTo("24/06/2024"));
	
	ArrayList<String>lst=resp.jsonPath().get("content.projectName");
	
	System.out.println(lst);
	
  }
}

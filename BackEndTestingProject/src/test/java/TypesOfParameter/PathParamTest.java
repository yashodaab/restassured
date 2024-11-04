package TypesOfParameter;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class PathParamTest {
	@Test
	public void SampleTest() {
		given()
		.pathParam("projectId", "NH_PROJ_1230")
		.when().get("http://49.249.28.218:8091/project/{projectId}")
		.then().log().all();
		
	}

}

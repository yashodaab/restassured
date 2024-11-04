package TypesOfParameter;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class QueryParaTest2 {
	@Test
	public void SampleTest() {
		given()
		.queryParam("teamSize", 10)
		.log().all()
		.when().get("http://49.249.28.218:8091/project")
		.then().log().all();
		
	}

}

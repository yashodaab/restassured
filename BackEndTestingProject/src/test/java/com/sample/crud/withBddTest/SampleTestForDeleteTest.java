package com.sample.crud.withBddTest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleTestForDeleteTest {

	@Test
	public void putDataToServer() {
		
		
		given()
		.delete("http://49.249.28.218:8091/project/NH_PROJ_306")
		.then()
		.assertThat().statusCode(204)
		.log().all();
       
	}

}

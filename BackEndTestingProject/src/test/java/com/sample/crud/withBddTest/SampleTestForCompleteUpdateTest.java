package com.sample.crud.withBddTest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class SampleTestForCompleteUpdateTest {
	@Test
	public void postDataToServer() {
		JSONObject jsonObj = new JSONObject();

		jsonObj.put("createdBy", "Yashoda");
		jsonObj.put("status", "created");
		jsonObj.put("teamSize", 10);
		jsonObj.put("projectName", "goa12");
		
		given()
		 .contentType(ContentType.JSON)
		  .body(jsonObj.toJSONString())
		   .when()
		    .post("http://49.249.28.218:8091/addProject")
		     .then()
		      .assertThat().statusCode(201)
		      .log().all();
		    
		

	}
}

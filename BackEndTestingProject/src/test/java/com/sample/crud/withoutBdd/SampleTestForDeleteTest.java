package com.sample.crud.withoutBdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleTestForDeleteTest {

	@Test
	public void DeleteDataFromServer() {
		
		Response res = RestAssured.delete("http://49.249.28.218:8091/project/NH_PROJ_325");
		res.then().assertThat().statusCode(204);
		res.then().log().all();
       
	}

}

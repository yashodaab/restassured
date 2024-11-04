package com.sample.crud.withoutBdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleTestForCompleteUpdateTest {
	@Test
	public void putDataToServer() {
		JSONObject jsonObj = new JSONObject();

		jsonObj.put("createdBy", "Yashoda");
		jsonObj.put("status", "created");
		jsonObj.put("teamSize", 10);
		jsonObj.put("projectName", "mangooo 223");

		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(jsonObj.toJSONString());

		Response res = req.put("http://49.249.28.218:8091/project/NH_PROJ_302");
		res.then().log().all();
        res.then().assertThat().statusCode(200);
	}
}

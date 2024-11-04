package PracticeresponseValidation;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertThat;

import java.util.concurrent.TimeUnit;
public class VerifyResponseTimeTest {
@Test
public void verifyHeader() {
	Response resp=given()
	.get("http://49.249.28.218:8091/projects");
	resp.then().log().all();
	
	long timeTaken=resp.time();
	long timetakensec=resp.timeIn(TimeUnit.SECONDS);
	System.out.println(timeTaken);
	System.out.println(timetakensec);
	
	resp.then().assertThat().time(Matchers.lessThan(900L));
	
	resp.then().assertThat().time(Matchers.greaterThan(300L));
	
	resp.then().assertThat().time(Matchers.both(Matchers.lessThan(900L)).and(Matchers.greaterThan(300L)));
	
  }
}

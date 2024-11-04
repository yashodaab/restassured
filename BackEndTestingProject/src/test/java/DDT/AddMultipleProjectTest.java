package DDT;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
public class AddMultipleProjectTest {

	@Test(dataProvider = "getData")
	public void sampleTest(String pName, String status  ) {
		//String pName="Tek Pyramid";
		//String status="created";
		String reqbody ="{\r\n"
				+ "  \"createdBy\": \"Yashoda\",\r\n"
				+ "  \"projectName\": \""+pName+"\",\r\n"
				+ "  \"status\": \""+status+"\",\r\n"
				+ "  \"teamSize\": 0\r\n"
				+ "}";
				
				given()
				.contentType(ContentType.JSON)
				.body(reqbody)
				.when()
				.post("http://49.249.28.218:8091/addProject")
				.then().log().all();
				
	}
	@DataProvider
	public Object[][]getData() throws Throwable{
		/*/Object[][] objarr=new Object[3][2];
		objarr[0][0]="AirIndia_1";
		objarr[0][1]="Created";
		
		objarr[1][0]="AirIndia_2";
		objarr[1][1]="Created";
		
		objarr[2][0]="AirIndia_3";
		objarr[2][1]="Created";
		/*/
		
		ExcelUtility elib=new ExcelUtility();
		int count=elib.getRowcount("project");
		Object[][] objarr=new Object[count][2];
		
		for(int i=0; i<count; i++) {
			objarr[i][0]=elib.getDataFromExcel("project", i+1, 0);
			objarr[i][1]=elib.getDataFromExcel("project", i+1, 1);
		}
		
		return objarr;
	}
}

package practice_serialization;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonPropertyOrder(value = { "CreatedBy", "projectName", "Teamsize", "status" }

)
@JsonIgnoreProperties(value = { "Teamsize" }, allowSetters = true

)

class project { // POJO Class [Plain old java object]
	private String projectName;
	@JsonProperty(value = "Created By")
	private String CreatedBy;
	private int Teamsize;
	private String status;

	private project() {
	}

	public project(String projectName, String createdBy, int teamsize, String status) {
		super();
		this.projectName = projectName;
		CreatedBy = createdBy;
		Teamsize = teamsize;
		this.status = status;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getCreatedBy() {
		return CreatedBy;
	}

	public void setCreatedBy(String createdBy) {
		CreatedBy = createdBy;
	}

	public int getTeamsize() {
		return Teamsize;
	}

	public void setTeamsize(int teamsize) {
		Teamsize = teamsize;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

public class Run1_JackSonSerTest {
	public static void main(String[] args) throws Throwable, DatabindException, IOException {
		project pobj = new project("Mango", "Yashoda", 10, "Created");

		ObjectMapper objM = new ObjectMapper();
		objM.writeValue(new File("./project.json"), pobj);
		System.out.println("===END===");

	}
}

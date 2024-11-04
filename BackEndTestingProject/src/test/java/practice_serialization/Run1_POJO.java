package practice_serialization;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

class project1 {

	String projectName;
	String projectstatus;
	int teamsize;

	List<String> teamMember;
	ProjectManager projectManager;

	public project1(String projectName, String projectstatus, int teamsize, List<String> teamMember,
			ProjectManager projectManager) {
		super();
		this.projectName = projectName;
		this.projectstatus = projectstatus;
		this.teamsize = teamsize;
		this.teamMember = teamMember;
		this.projectManager = projectManager;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectstatus(String projectstatus) {
		this.projectstatus = projectstatus;
	}

	public String getProjectstatus() {
		return projectstatus;
	}

	public void setTeamsize(int teamsize) {
		this.teamsize = teamsize;
	}

	public int getTeamsize() {
		return teamsize;
	}

	public void setTeamMember(List<String> teamMember) {
		this.teamMember = teamMember;
	}

	public List<String> getTeamMember() {
		return teamMember;
	}

	public void setProjectManager(ProjectManager projectManager) {
		this.projectManager = projectManager;
	}

	public ProjectManager getProjectManager() {
		return projectManager;
	}

}

class ProjectManager { 
	
	String name;
	String empID;
	
	public ProjectManager(String name, String empID) {
		super();
		this.name = name;
		this.empID = empID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public String getEmpID() {
		return empID;
	}

}

public class Run1_POJO {
	public static void main(String[] args) throws Throwable, DatabindException, IOException {
		List<String> lst = new ArrayList<String>();
		lst.add("Jhon");
		lst.add("devid");
		lst.add("stev");

		ProjectManager pm = new ProjectManager("sagar", "tp01");

		project1 probjectobj = new project1("Yashoda", "created", 10, lst, pm);

		ObjectMapper objmap = new ObjectMapper();
		objmap.writeValue(new File("./project1.json"), probjectobj);
		System.out.println("end");

	}
}
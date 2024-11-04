package practice_serialization;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Run3_Jackson_deserTest {

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
	ObjectMapper objM=new ObjectMapper();
project pobj =	objM.readValue(new File("./project.json"), project.class);

System.out.println(pobj.getProjectName());
System.out.println(pobj.getTeamsize());
System.out.println(pobj.getStatus());
System.out.println(pobj.getCreatedBy());


	}

}

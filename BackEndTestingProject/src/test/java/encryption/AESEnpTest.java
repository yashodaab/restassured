package encryption;

import org.testng.annotations.Test;

public class AESEnpTest {
@Test
public void sampleTest() throws Exception {
	
	String privateKey="Ac03tEam@j!tu_#1";
	//String data= "Yashoda";
	String data="{\"name\":\"yashoda\",\"id\":\"TP_01\"}";
	
	EncrypAndDecryptUtility ed= new EncrypAndDecryptUtility();
	System.out.println(ed.encrypt(data, privateKey));
	System.out.println(ed.decrypt("+cHEGnNWatbQASSsuWjxKDgn1feMmG+wzfpfbFjDQO4=", privateKey));
}	
}

package practice_serialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class NFSGame implements Serializable{
	String name;
	int level;
	long score;
	int life;
	public NFSGame(String name, int level, long score, int life) {
		super();
		this.name = name;
		this.level = level;
		this.score = score;
		this.life = life;
	}
	
}
public class Run1_seri {

	public static void main(String[] args) throws Throwable {
	 NFSGame user1obj=new NFSGame ("yashoda",10,60000,3);
	 FileOutputStream fileOut=new FileOutputStream("./f.txt");
	 
	 ObjectOutputStream objout=new ObjectOutputStream(fileOut);
	 objout.writeObject(user1obj);
	 System.out.println("===END===");
	 

	}

}

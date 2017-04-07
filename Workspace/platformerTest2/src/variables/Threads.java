package variables;
import playerMove.*;
public class Threads {
	public static Thread jump = new Thread(new Jump());
	public static Thread fall = new Thread(new Falling());
	
	public static void remakeJump(){
		jump = new Thread(new Jump());
	}
}

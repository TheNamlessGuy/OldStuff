package variables;
import javax.swing.JFrame;
import create.CreateJFrames;
public class JFrames {
	public static JFrame gameFrame;
	public static JFrame haxFrame;
	public static void gameFrame(){
		gameFrame = CreateJFrames.gameFrame();
	}
}
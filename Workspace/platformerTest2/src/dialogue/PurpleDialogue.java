package dialogue;
import java.util.Random;
import variables.*;
public class PurpleDialogue {
	static Random r = new Random();
	static int ri = 0;
	public static void floor5(){
		JLabels.oTalkingLabel.setText("<html><center>Oh thank god<br>rescue! Let's go<br>back!</center></html>");
	}
	public static void floor6(){
		ri = r.nextInt(3);
		switch (ri){
		case 0:
			JLabels.oTalkingLabel.setText("<html><center>Thank you so much!</center></html");
			break;
		case 1:
			JLabels.oTalkingLabel.setText("<html><center>I love you!<br>(nohomo)</center></html");
			break;
		case 2:
			JLabels.oTalkingLabel.setText("<html><center>You're the greatest!</center></html");
			break;
		default:
			JLabels.oTalkingLabel.setText("<html><center>Purple default</center></html");
			break;
		}
	}
}

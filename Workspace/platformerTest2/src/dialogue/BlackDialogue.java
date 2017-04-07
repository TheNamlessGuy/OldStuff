package dialogue;
import java.util.Random;
import variables.*;
public class BlackDialogue {
	static Random r = new Random();
	static int ri = 0;
	public static void floor1() {
		ri = r.nextInt(2);
		switch(ri){
		case 0: //FIRST TIME TALK
			JLabels.oTalkingLabel.setText("<html><center>Congratulations!<br>You figured out how<br>to talk!</center></html>");
			break;
		case 1:
			JLabels.oTalkingLabel.setText("<html><center>You have to save her!</center></html>");
			break;
		default: //WHEN NOT CASES ABOVE
			JLabels.oTalkingLabel.setText("<html><center>Black Default</center></html>");
			break;
		}
	}
	public static void floor2(){
		ri = r.nextInt(2);
		switch(ri){
		case 0: //FIRST TIME TALK ON FLOOR 2
			JLabels.oTalkingLabel.setText("<html><center>Purple is 3<br>floors ahead!</center></html>");
			break;
		case 1: //SECOND TIME TALK ON FLOOR 2
			JLabels.oTalkingLabel.setText("<html><center>You just have<br> to go 3 floors more!</center></html>");
			break;
		default: //IF NOT ABOVE
			JLabels.oTalkingLabel.setText("<html><center>Black default</center></html>");
			break;
		}
	}
	public static void floor6(){
		ri = r.nextInt(2);
		switch(ri){
		case 0:
			JLabels.oTalkingLabel.setText("<html><center>You did it!</center></html");
			break;
		case 1:
			JLabels.oTalkingLabel.setText("<html><center>Yaay, I'm so happy!</center></html");
			break;
		default:
			JLabels.oTalkingLabel.setText("<html><center>Black default</center></html");
			break;
		}
	}
}

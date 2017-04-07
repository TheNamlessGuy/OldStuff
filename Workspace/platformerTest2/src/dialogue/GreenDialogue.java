package dialogue;
import java.util.Random;

import variables.*;
public class GreenDialogue {
	static Random r = new Random();
	static int ri = 0;
	public static void floor1() {
		ri = r.nextInt(2);
		switch (ri){
		case 0: //FIRST TIME TALK
			JLabels.oTalkingLabel.setText("<html><center>Purple is missing!<br>You have to save her!</center></html>");
			break;
		case 1: //SECOND TIME TALK
			JLabels.oTalkingLabel.setText("<html><center>Purple is gone!</center></html>");
			break;
		default: //IF NOT CASES ABOVE
			JLabels.oTalkingLabel.setText("<html><center>Green default</center></html>");
			break;
		}
	}
	public static void floor2(){
		ri = r.nextInt(2);
		switch(ri){
		case 0: //FIRST TIME TALK ON FLOOR 2
			JLabels.oTalkingLabel.setText("<html><center>Purple might<br>be hurt!</center></html>");
			break;
		case 1: //SECOND TIME TALK ON FLOOR 2
			JLabels.oTalkingLabel.setText("<html><center>Save Purple!<br>Hurry!</center></html>");
			break;
		default: //IF NOT ABOVE
			JLabels.oTalkingLabel.setText("<html><center>Green default</center></html>");
		}
	}
	public static void floor6(){
		JLabels.oTalkingLabel.setText("<html><center>Yay, you got Purple!<br>And it only took you<br>" + Ints.timesKilled + " deaths!</center></html");
	}
}

package listeners;
import game.Maaaaaaaaain;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import create.JFrames;
import create.JToolBars;
public class ReplayListener implements ActionListener{
	static JFrame gameFrame;
	static JFrame updateFrame;
	public void actionPerformed(ActionEvent e) {
		gameFrame.dispose();
		updateFrame.dispose();
		JFrame gameModeFrame = JFrames.gameModeFrame();
		gameModeFrame.setVisible(true);
		JToolBars.replay();
		Maaaaaaaaain.replay();
	}
	public static void getFrames(JFrame gameFrame1, JFrame updateFrame1){
		gameFrame = gameFrame1;
		updateFrame = updateFrame1;
	}
}

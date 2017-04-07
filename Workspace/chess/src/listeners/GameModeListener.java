package listeners;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import game.Maaaaaaaaain;
public class GameModeListener implements ActionListener{
	static JFrame gameModeFrame;
	static JButton vsComp;
	static JButton vsPlay;
	static boolean vsPlayer;
	public void actionPerformed(ActionEvent e){
		JButton q = (JButton)e.getSource();
		if (q == vsComp){
			vsPlayer = false;
		}
		if (q == vsPlay){
			vsPlayer = true;
		}
		try {
			Maaaaaaaaain.startGame();
		}catch (IOException e1) {}
		gameModeFrame.dispose();
	}
	public static void getAll(JButton vsComp1, JButton vsPlay1, JFrame gameModeFrame1){
		vsComp = vsComp1;
		vsPlay = vsPlay1;
		gameModeFrame = gameModeFrame1;
	}
}

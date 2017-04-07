package create;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import listeners.ReplayListener;
public class JToolBars {
	static JLabel playerLabel = new JLabel("<html><center>It's player 1's turn</center></html>");
	public static JToolBar toolbar() {
		JToolBar toolbar = new JToolBar();
		
		JButton replay = new JButton("Replay");
		
		replay.addActionListener(new ReplayListener());

		toolbar.add(playerLabel);
		toolbar.add(replay);
		return toolbar;
	}
	public static void update(String s1){
    	s1 = "<html><center>" + s1 + "</center></html>";
    	playerLabel.setText(s1);
	}
	public static void changePlayer(){
    	if (playerLabel.getText().equals("<html><center>It's player 1's turn</center></html>")){
    		playerLabel.setText("<html><center>It's player 2's turn</center></html>");
    	}else{
    		playerLabel.setText("<html><center>It's player 1's turn</center></html>");
    	}
    }
    public static void replay(){
    	playerLabel.setText("<html><center>It's player 1's turn</center></html>");
    }
}

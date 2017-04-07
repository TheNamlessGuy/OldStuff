package listeners;
import game.Get;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
public class MoveListener implements ActionListener{
	static int[] location;
	static JButton[][] b;
	static Color[][] colors;
	static int[] clickedLocation;
	public void actionPerformed(ActionEvent e) {
		JButton q = (JButton)e.getSource();
		clickedLocation = Get.location(q, b);
		if (q.getBackground() == Color.blue){
			ImageIcon IC = Get.currentPiece(location, b);
			b[location[0]][location[1]].setIcon(null);
			b[clickedLocation[0]][clickedLocation[1]].setIcon(IC);
			for (int i = 0; i != 8; i++){
				for (int j = 0; j != 8; j++){
					b[i][j].setBackground(colors[i][j]);
					b[i][j].removeActionListener(b[i][j].getActionListeners()[0]);
					b[i][j].addActionListener(new ActionListeners());
					//ENEMY MOVEMENT
				}
			}
		}
		if(clickedLocation[0] == location[0] && clickedLocation[1] == location[1]){
			for (int i = 0; i != 8; i++){
				for (int j = 0; j != 8; j++){
					b[i][j].setBackground(colors[i][j]);
					b[i][j].removeActionListener(b[i][j].getActionListeners()[0]);
					b[i][j].addActionListener(new ActionListeners());
				}
			}
		}
	}
	public static void getAll(int[] l, JButton[][] b1, Color[][] c){
		location = l;
		b = b1;
		colors = c;
	}
}
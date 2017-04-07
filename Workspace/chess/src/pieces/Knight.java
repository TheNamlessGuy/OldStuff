package pieces;
import game.Get;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import listeners.MoveListener;
public class Knight {
	static boolean canMoveB = false;
	public static JButton[][] canMove(JButton[][] b, JButton q, int[] location, Color[][] colors, ImageIcon[] enemies) {
		for (ImageIcon i: enemies){
			if (location[0] > 1){ //GO NORTH 2
				if (location[1] < 7){ //GO NORTH 2, EAST 1
					if (b[location[0]-2][location[1]+1].getIcon() == null || b[location[0]-2][location[1]+1].getIcon() == i){
						b[location[0]-2][location[1]+1].setBackground(Color.blue);
						canMoveB = true;
					}
				}
				if (location[1] > 0){ //GO NORTH 2, WEST 1
					if (b[location[0]-2][location[1]-1].getIcon() == null || b[location[0]-2][location[1]-1].getIcon() == i){
						b[location[0]-2][location[1]-1].setBackground(Color.blue);
						canMoveB = true;
					}
				}
			}
			if (location[0] < 6){ //GO SOUTH 2
				if (location[1] < 7){ //GO SOUTH 2, EAST 1
					if (b[location[0]+2][location[1]+1].getIcon() == null || b[location[0]+2][location[1]+1].getIcon() == i){
						b[location[0]+2][location[1]+1].setBackground(Color.blue);
						canMoveB = true;
					}
				}
				if (location[1] > 0){ //GO SOUTH 2, WEST 1
					if (b[location[0]+2][location[1]-1].getIcon() == null || b[location[0]+2][location[1]-1].getIcon() == i){
						b[location[0]+2][location[1]-1].setBackground(Color.blue);
						canMoveB = true;
					}
				}
			}
			if (location[1] > 1){ //GO WEST 2
				if (location[0] < 7){ //GO WEST 2, SOUTH 1
					if (b[location[0]+1][location[1]-2].getIcon() == null || b[location[0]+1][location[1]-2].getIcon() == i){
						b[location[0]+1][location[1]-2].setBackground(Color.blue);
						canMoveB = true;
					}
				}
				if (location[0] > 0){ //GO WEST 2, NORTH 1
					if (b[location[0]-1][location[1]-2].getIcon() == null || b[location[0]-1][location[1]-2].getIcon() == i){
						b[location[0]-1][location[1]-2].setBackground(Color.blue);
						canMoveB = true;
					}
				}
			}
			if (location[1] < 6){ //GO EAST 2
				if (location[0] < 7){ //GO EAST 2, SOUTH 1
					if (b[location[0]+1][location[1]+2].getIcon() == null || b[location[0]+1][location[1]+2].getIcon() == i){
						b[location[0]+1][location[1]+2].setBackground(Color.blue);
						canMoveB = true;
					}
				}
				if (location[0] > 0){ //GO EAST 2, NORTH 1
					if (b[location[0]-1][location[1]+2].getIcon() == null || b[location[0]-1][location[1]+2].getIcon() == i){
						b[location[0]-1][location[1]+2].setBackground(Color.blue);
						canMoveB = true;
					}
				}
			}
		}
		if (canMoveB){
			location = Get.location(q, b);
			for(JButton[] q1: b){
				for (JButton q2: q1){
					q2.removeActionListener(q2.getActionListeners()[0]);
					MoveListener.getAll(location, b, colors);
					q2.addActionListener(new MoveListener());
				}
			}
		}
		return b;
	}
}
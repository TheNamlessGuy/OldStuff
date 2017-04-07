package pieces;
import game.Get;
import java.awt.Color;
import javax.swing.JButton;
import listeners.MoveListener;
public class Rook {
	public static JButton[][] canMove(JButton[][] b, int[] location, Color[][] colors, JButton q) {
		boolean canMoveB = false;
		if (location[0] != 7){ //SOUTH
			while (location[0] != 7 && b[location[0]+1][location[1]].getIcon() == null){
					b[location[0]+1][location[1]].setBackground(Color.blue);
					canMoveB = true;
				location[0]++;
			}
		}
		location = Get.location(q, b);
		if (location[0] != 0){ //NORTH
			while (location[0] != 0 && b[location[0]-1][location[1]].getIcon() == null){
					b[location[0]-1][location[1]].setBackground(Color.blue);
					canMoveB = true;
				location[0]--;
			}
		}
		location = Get.location(q, b);
		if (location[1] != 0){ //WEST
			while (location[1] != 0 && b[location[0]][location[1]-1].getIcon() == null){
					b[location[0]][location[1]-1].setBackground(Color.blue);
					canMoveB = true;
				location[1]--;
			}
		}
		location = Get.location(q, b);
		if (location[1] != 7){ //EAST
			while (location[1] != 7 && b[location[0]][location[1]+1].getIcon() == null){
					b[location[0]][location[1]+1].setBackground(Color.blue);
					canMoveB = true;
				location[1]++;
			}
		}
		location = Get.location(q, b);
		if (canMoveB){
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
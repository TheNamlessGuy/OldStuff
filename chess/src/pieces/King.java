package pieces;
import game.Get;
import java.awt.Color;
import javax.swing.JButton;
import listeners.MoveListener;
public class King {
	public static JButton[][] canMove(JButton[][] b, int[] location, Color[][] colors, JButton q) {
		boolean canMoveB = false;
		if (location[1] != 7){
			if (b[location[0]][location[1]+1].getIcon() == null){ //EAST
				b[location[0]][location[1]+1].setBackground(Color.blue);
				canMoveB = true;
			}
		}if (location[1] != 0){
			if (b[location[0]][location[1]-1].getIcon() == null){ //WEST
				b[location[0]][location[1]-1].setBackground(Color.blue);
				canMoveB = true;
			}
		}if (location[0] != 0){
			if (b[location[0]-1][location[1]].getIcon() == null){ //NORTH
				b[location[0]-1][location[1]].setBackground(Color.blue);
				canMoveB = true;
			}
		}if (location[0] != 7){
			if (b[location[0]+1][location[1]].getIcon() == null){ //SOUTH
				b[location[0]+1][location[1]].setBackground(Color.blue);
				canMoveB = true;
			}
		}if (location[0] != 0 && location[1] != 7){
			if (b[location[0]-1][location[1]+1].getIcon() == null){ //NORTHEAST
				b[location[0]-1][location[1]+1].setBackground(Color.blue);
				canMoveB = true;
			}
		}if (location[0] != 0 && location[1] != 0){
			if (b[location[0]-1][location[1]-1].getIcon() == null){ //NORTHWEST
				b[location[0]-1][location[1]-1].setBackground(Color.blue);
				canMoveB = true;
			}
		}if (location[0] != 7 && location[1] != 7){
			if (b[location[0]+1][location[1]+1].getIcon() == null){ //SOUTHEAST
				b[location[0]+1][location[1]+1].setBackground(Color.blue);
				canMoveB = true;
			}
		}if (location[0] != 7 && location[1] != 0){
			if (b[location[0]+1][location[1]-1].getIcon() == null){ //SOUTHWEST
				b[location[0]+1][location[1]-1].setBackground(Color.blue);
				canMoveB = true;
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
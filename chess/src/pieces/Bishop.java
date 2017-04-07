package pieces;
import game.Get;
import java.awt.Color;
import javax.swing.JButton;

import debug.Bedug;
import listeners.MoveListener;
public class Bishop {
	public static JButton[][] canMove(int[] location, JButton[][] b, JButton q, Color[][] colors) {
		boolean canMoveB = false;
		if (location[0] != 0 && location[1] != 0){
			while(location[0] != 0 && location[1] != 0 && b[location[0]-1][location[1]-1].getIcon() == null){ //NORTHWEST
				location[0]--;
				location[1]--;
				b[location[0]][location[1]].setBackground(Color.blue);
				canMoveB = true;
			}
		}
		location = Get.location(q, b);
		if (location[0] != 0 && location[1] != 7){
			while (location[0] != 0 && location[1] != 7 && b[location[0]-1][location[1]+1].getIcon() == null){ //NORTHEAST
				location[0]--;
				location[1]++;
				b[location[0]][location[1]].setBackground(Color.blue);
				canMoveB = true;
			}
		}
		location = Get.location(q, b);
		if (location[0] != 7 && location[1] != 7){
			while (location[0] != 7 && location[1] != 7 && b[location[0]+1][location[1]+1].getIcon() == null){ //SOUTHEAST
				location[0]++;
				location[1]++;
				b[location[0]][location[1]].setBackground(Color.blue);
				canMoveB = true;
			}
		}
		location = Get.location(q, b);
		if (location[0] != 7 && location[1] != 0){
			while (location[0] != 7 && location[1] != 0 && b[location[0]+1][location[1]-1].getIcon() == null){ //SOUTHWEST
				location[0]++;
				location[1]--;
				b[location[0]][location[1]].setBackground(Color.blue);
				canMoveB = true;
			}
		}
		if(canMoveB){
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
package pieces;
import game.Get;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import listeners.MoveListener;
public class PawnG {
	static boolean canMoveB = false;
	public static JButton[][] canMove(int[] location, JButton[][] b, Color[][] colors, ImageIcon[] enemies, JButton q) {
		if (location[0] != 0){ //NORTH
			if (b[location[0]-1][location[1]].getIcon() == null){
				b[location[0]-1][location[1]].setBackground(Color.blue);
				canMoveB = true;
			}
		}
		if (location[0] == 6){ //IF FIRST MOVE
			if (b[location[0]-2][location[1]].getIcon() == null){
				b[location[0]-2][location[1]].setBackground(Color.blue);
				canMoveB = true;
			}
		}
		b = PawnG.canAttack(b, enemies, location);
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
	public static JButton[][] canAttack(JButton[][] b, ImageIcon[] enemies, int[] location){
		for (ImageIcon i: enemies){
			if (location[0] != 0 && location[1] != 0){ //ATTACK NORTHWEST
				if (b[location[0]-1][location[1]-1].getIcon() == i){
					b[location[0]-1][location[1]-1].setBackground(Color.blue);
					canMoveB = true;
				}
			}
			if (location[0] != 0 && location[1] != 7){ //ATTACK NORTHEAST
				if (b[location[0]-1][location[1]+1].getIcon() == i){
					b[location[0]-1][location[1]+1].setBackground(Color.blue);
					canMoveB = true;
				}
			}
		}
		return b;
	}
}
package pieces;
import game.Get;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import listeners.MoveListener;
public class Queen {
	static boolean canMoveB = false;
	static boolean attacking = false;
	static boolean friendlyFire = false;
	public static JButton[][] canMove(JButton q, JButton[][] b, int[] location, Color[][] colors, ImageIcon[] enemies, ImageIcon[] friendly) {
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
		if (location[1] != 7){ //EAST
			while (location[1] != 7 && b[location[0]][location[1]+1].getIcon() == null){
				b[location[0]][location[1]+1].setBackground(Color.blue);
				canMoveB = true;
				location[1]++;
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
		if (location[0] != 0 && location[1] != 0){ //NORTHWEST
			while (location[0] != 0 && location[1] != 0 && b[location[0]-1][location[1]-1].getIcon() == null){
				b[location[0]-1][location[1]-1].setBackground(Color.blue);
				canMoveB = true;
				location[0]--;
				location[1]--;
			}
		}
		location = Get.location(q, b);
		if (location[0] != 0 && location[1] != 7){ //NORTHEAST
			while (location[0] != 0 && location[1] != 7 && b[location[0]-1][location[1]+1].getIcon() == null){
				b[location[0]-1][location[1]+1].setBackground(Color.blue);
				canMoveB = true;
				location[0]--;
				location[1]++;
			}
		}
		location = Get.location(q, b);
		if (location[0] != 7 && location[1] != 0){ //SOUTHWEST
			while (location[0] != 7 && location[1] != 0 && b[location[0]+1][location[1]-1].getIcon() == null){
				b[location[0]+1][location[1]-1].setBackground(Color.blue);
				canMoveB = true;
				location[0]++;
				location[1]--;
			}
		}
		location = Get.location(q, b);
		if (location[0] != 7 && location[1] != 7){ //SOUTHEAST
			while (location[0] != 7 && location[1] != 7 && b[location[0]+1][location[1]+1].getIcon() == null){
				b[location[0]+1][location[1]+1].setBackground(Color.blue);
				canMoveB = true;
				location[0]++;
				location[1]++;
			}
		}
		//ATTACKING
		b = Queen.canAttack(b, q, enemies, location, friendly);
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
	public static JButton[][] canAttack (JButton[][] b, JButton q, ImageIcon[] enemies, int[] location, ImageIcon[] friendly){
		friendlyFire = false;
		attacking = false;
		location = Get.location(q, b);
		//ATTACK SOUTHEAST
		while (location[0] != 7 && location[1] != 7){
			for (ImageIcon i: friendly){
				if (b[location[0]+1][location[1]+1].getIcon() == i){
					friendlyFire = true;
				}
			}
			if (!friendlyFire){
				for (ImageIcon i: enemies){
					if (b[location[0]+1][location[1]+1].getIcon() == i && !attacking){
						b[location[0]+1][location[1]+1].setBackground(Color.blue);
						canMoveB = true;
						attacking = true;
					}
				}
			}
			location[0]++;
			location[1]++;
		}
		friendlyFire = false;
		attacking = false;
		location = Get.location(q, b);
		//ATTACK SOUTHWEST
		while (location[0] != 7 && location[1] != 0){
			for (ImageIcon i: friendly){
				if (b[location[0]+1][location[1]-1].getIcon() == i){
					friendlyFire = true;
				}
			}
			if (!friendlyFire){
				for (ImageIcon i: enemies){
					if (b[location[0]+1][location[1]-1].getIcon() == i && !attacking){
						b[location[0]+1][location[1]-1].setBackground(Color.blue);
						canMoveB = true;
						attacking = true;
					}
				}
			}
			location[0]++;
			location[1]--;
		}
		friendlyFire = false;
		attacking = false;
		location = Get.location(q, b);
		//ATTACK NORTHEAST
		while (location[0] != 0 && location[1] != 7){
			for (ImageIcon i: friendly){
				if (b[location[0]-1][location[1]+1].getIcon() == i){
					friendlyFire = true;
				}
			}
			if (!friendlyFire){
				for (ImageIcon i: enemies){
					if (b[location[0]-1][location[1]+1].getIcon() == i && !attacking){
						b[location[0]-1][location[1]+1].setBackground(Color.blue);
						canMoveB = true;
						attacking = true;
					}
				}
			}
			location[0]--;
			location[1]++;
		}
		friendlyFire = false;
		attacking = false;
		location = Get.location(q, b);
		//ATTACK NORTHWEST
		while (location[0] != 0 && location[1] != 0){
			for (ImageIcon i: friendly){
				if (b[location[0]-1][location[1]-1].getIcon() == i){
					friendlyFire = true;
				}
			}
			if (!friendlyFire){
				for (ImageIcon i: enemies){
					if (b[location[0]-1][location[1]-1].getIcon() == i && !attacking){
						b[location[0]-1][location[1]-1].setBackground(Color.blue);
						canMoveB = true;
						attacking = true;
					}
				}
			}
			location[0]--;
			location[1]--;
		}
		friendlyFire = false;
		attacking = false;
		location = Get.location(q, b);
		//ATTACK NORTH
		while (location[0] != 0){
			for (ImageIcon i: friendly){
				if (b[location[0]-1][location[1]].getIcon() == i){
					friendlyFire = true;
				}
			}
			if (!friendlyFire){
				for (ImageIcon i: enemies){
					if (b[location[0]-1][location[1]].getIcon() == i && !attacking){
						b[location[0]-1][location[1]].setBackground(Color.blue);
						canMoveB = true;
						attacking = true;
					}
				}
			}
			location[0]--;
		}
		friendlyFire = false;
		attacking = false;
		location = Get.location(q, b);
		//ATTACK SOUTH
		while (location[0] != 7){
			for (ImageIcon i: friendly){
				if (b[location[0]+1][location[1]].getIcon() == i){
					friendlyFire = true;
				}
			}
			if (!friendlyFire){
				for (ImageIcon i: enemies){
					if (b[location[0]+1][location[1]].getIcon() == i && !attacking){
						b[location[0]+1][location[1]].setBackground(Color.blue);
						canMoveB = true;
						attacking = true;
					}
				}
			}
			location[0]++;
		}
		friendlyFire = false;
		attacking = false;
		location = Get.location(q, b);
		//ATTACK WEST
		while (location[1] != 0){
			for (ImageIcon i: friendly){
				if (b[location[0]][location[1]-1].getIcon() == i){
					friendlyFire = true;
				}
			}
			if (!friendlyFire){
				for (ImageIcon i: enemies){
					if (b[location[0]][location[1]-1].getIcon() == i && !attacking){
						b[location[0]][location[1]-1].setBackground(Color.blue);
						canMoveB = true;
						attacking = true;
					}
				}
			}
			location[1]--;
		}
		friendlyFire = false;
		attacking = false;
		location = Get.location(q, b);
		//ATTACK EAST
		while (location[1] != 7){
			for (ImageIcon i: friendly){
				if (b[location[0]][location[1]+1].getIcon() == i){
					friendlyFire = true;
				}
			}
			if (!friendlyFire){
				for (ImageIcon i: enemies){
					if (b[location[0]][location[1]+1].getIcon() == i && !attacking){
						b[location[0]][location[1]+1].setBackground(Color.blue);
						canMoveB = true;
						attacking = true;
					}
				}
			}
			location[1]++;
		}
		return b;
	}
}
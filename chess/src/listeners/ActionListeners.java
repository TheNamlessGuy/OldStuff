package listeners;
import game.Get;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import pieces.Bishop;
import pieces.King;
import pieces.Pawn;
import pieces.Queen;
import pieces.Rook;
import debug.Bedug;
public class ActionListeners implements ActionListener{
	static ImageIcon BG;
	static ImageIcon BR;
	static ImageIcon KG;
	static ImageIcon KR;
	static ImageIcon KnG;
	static ImageIcon KnR;
	static ImageIcon PG;
	static ImageIcon PR;
	static ImageIcon QG;
	static ImageIcon QR;
	static ImageIcon RG;
	static ImageIcon RR;
	static JButton[][] b;
	static ImageIcon[] enemies;
	static Color[][] colors;
	public void actionPerformed(ActionEvent e) {
		JButton q = (JButton)e.getSource();
		int[] location = Get.location(q, b);
		
		if(q.getIcon() == BR || q.getIcon() == KR || q.getIcon() == KnR || q.getIcon() == PR || q.getIcon() == QR || q.getIcon() == RR){
			Bedug.update("You cannot move that piece!");
		}else if(q.getIcon() == BG){ //BISHOP
			b = Bishop.canMove(location, b, q, colors);
		}else if(q.getIcon() == KG){ //KING
			b = King.canMove(b, location, colors, q);
		}else if(q.getIcon() == KnG){ //KNIGHT
			//FANIWGNW
		}else if(q.getIcon() == PG){ //PAWN
			b = Pawn.canMove(location, b, colors, enemies, q, QG);
		}else if(q.getIcon() == QG){ //QUEEN
			b = Queen.canMove(q, b, location, colors, enemies);
		}else if(q.getIcon() == RG){ //ROOK
			b = Rook.canMove(b, location, colors, q);
		}else{
			Bedug.update("Wut");
		}
	}
	public static void getImageIcons(ImageIcon BG1, ImageIcon BR1, ImageIcon KG1, ImageIcon KR1, ImageIcon KnG1, ImageIcon KnR1, ImageIcon PG1, ImageIcon PR1, ImageIcon QG1, ImageIcon QR1, ImageIcon RG1, ImageIcon RR1, ImageIcon[] enemigos){
		BG = BG1;
		BR = BR1;
		KG = KG1;
		KR = KR1;
		KnG = KnG1;
		KnR = KnR1;
		PG = PG1;
		PR = PR1;
		QG = QG1;
		QR = QR1;
		RG = RG1;
		RR = RR1;
		enemies = enemigos;
	}
	public static void getButtons(JButton[][] b1){
		b = b1;
	}
	public static void getColors(Color[][] colo){
		colors = colo;
	}
}
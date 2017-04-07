package listeners;
import game.Get;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import create.JToolBars;
import pieces.*;
import game.Maaaaaaaaain;
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
	static ImageIcon[] enemiesG;
	static ImageIcon[] enemiesR;
	static Color[][] colors;
	static ImageIcon[] friendlyG;
	static ImageIcon[] friendlyR;
	static boolean p1;
	public void actionPerformed(ActionEvent e) {
		p1 = Maaaaaaaaain.getP1();
		JButton q = (JButton)e.getSource();
		int[] location = Get.location(q, b);
		
		if(q.getIcon() == BR){ //P2 BISHOP
			if (!p1){
				b = Bishop.canMove(location, b, q, colors, friendlyR, enemiesR);
			}else{
				JToolBars.update("You can't move that piece!");
			}
		}else if (q.getIcon() == KR){ //P2 KING
			if (!p1){
				b = King.canMove(b, location, colors, q, enemiesR);
			}else{
				JToolBars.update("You can't move that piece!");
			}
		}else if (q.getIcon() == KnR){ //P2 KNIGHT
			if (!p1){
				b = Knight.canMove(b, q, location, colors, enemiesR);
			}else{
				JToolBars.update("You can't move that piece!");
			}
		}else if (q.getIcon() == PR){ //P2 PAWN
			if (!p1){
				b = PawnR.canMove(location, b, colors, enemiesR, q);
			}else{
				JToolBars.update("You can't move that piece!");
			}
		}else if (q.getIcon() == QR){ //P2 QUEEN
			if (!p1){
				b = Queen.canMove(q, b, location, colors, enemiesR, friendlyR);
			}else{
				JToolBars.update("You can't move that piece!");
			}
		}else if (q.getIcon() == RR){ //P2 ROOK
			if (!p1){
				b = Rook.canMove(b, location, colors, q, friendlyR, enemiesR);
			}else{
				JToolBars.update("You can't move that piece!");
			}
		}else if(q.getIcon() == BG){ //P1 BISHOP
			if (p1){
				b = Bishop.canMove(location, b, q, colors, friendlyG, enemiesG);
			}else{
				JToolBars.update("You can't move that piece!");
			}
		}else if(q.getIcon() == KG){ //P1 KING
			if (p1){
				b = King.canMove(b, location, colors, q, enemiesG);
			}else{
				JToolBars.update("You can't move that piece!");
			}
		}else if(q.getIcon() == KnG){ //P1 KNIGHT
			if (p1){
				b = Knight.canMove(b, q, location, colors, enemiesG);
			}else{
				JToolBars.update("You can't move that piece!");
			}
		}else if(q.getIcon() == PG){ //P1 PAWN
			if (p1){
				b = PawnG.canMove(location, b, colors, enemiesG, q);
			}else{
				JToolBars.update("You can't move that piece!");
			}
		}else if(q.getIcon() == QG){ //P1 QUEEN
			if (p1){
				b = Queen.canMove(q, b, location, colors, enemiesG, friendlyG);
			}else{
				JToolBars.update("You can't move that piece!");
			}
		}else if(q.getIcon() == RG){ //P1 ROOK
			if (p1){
				b = Rook.canMove(b, location, colors, q, friendlyG, enemiesG);
			}else{
				JToolBars.update("You can't move that piece!");
			}
		}
	}
	public static void getAll(ImageIcon BG1, ImageIcon BR1, ImageIcon KG1, ImageIcon KR1, ImageIcon KnG1, ImageIcon KnR1, ImageIcon PG1, ImageIcon PR1, ImageIcon QG1, ImageIcon QR1, ImageIcon RG1, ImageIcon RR1, ImageIcon[] enemigosG, ImageIcon[] friendlysG, ImageIcon[] enemigosR, ImageIcon[] friendlysR, Color[][] colo){
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
		enemiesG = enemigosG;
		friendlyG = friendlysG;
		enemiesR = enemigosR;
		friendlyR = friendlysR;
		colors = colo;
	}
	public static void getButtons (JButton[][] b1){
		b = b1;
	}
}
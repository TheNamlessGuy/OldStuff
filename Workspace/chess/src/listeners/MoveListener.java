package listeners;
import game.Get;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import create.JToolBars;
import game.Maaaaaaaaain;
public class MoveListener implements ActionListener{
	static int[] location;
	static JButton[][] b;
	static Color[][] colors;
	static int[] clickedLocation;
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
	static boolean p1Win = false;
	static boolean p2Win = false;
	public void actionPerformed(ActionEvent e) {
		String s = "";
		JButton q = (JButton)e.getSource();
		clickedLocation = Get.location(q, b);
		if (q.getBackground() == Color.blue){
			ImageIcon IC = Get.currentPiece(location, b);
			if (Maaaaaaaaain.getP1()){ //P1
				if (b[clickedLocation[0]][clickedLocation[1]].getIcon() == KR){
					p1Win = true;
				}
			}else{ //P2
				if (b[clickedLocation[0]][clickedLocation[1]].getIcon() == KG){
					p2Win = true;
				}
			}
			b[location[0]][location[1]].setIcon(null);
			s = b[location[0]][location[1]].getToolTipText();
			b[location[0]][location[1]].setToolTipText(null);
			b[clickedLocation[0]][clickedLocation[1]].setIcon(IC);
			b[clickedLocation[0]][clickedLocation[1]].setToolTipText(s);
			Maaaaaaaaain.changeP1();
			for (int i = 0; i != 8; i++){
				for (int j = 0; j != 8; j++){
					b[i][j].setBackground(colors[i][j]);
					b[i][j].removeActionListener(b[i][j].getActionListeners()[0]);
					b[i][j].addActionListener(new ActionListeners());
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
		for (int i = 0; i != 8; i++){
			if (b[0][i].getIcon() == PG){
				b[0][i].setIcon(QG);
				b[0][i].setToolTipText("Green Queen");
			}
			if (b[7][i].getIcon() == PR){
				b[7][i].setIcon(QR);
				b[7][i].setToolTipText("Red Queen");
			}
		}
		if (p1Win){
			for (JButton[] q1: b){
				for (JButton q2: q1){
					q2.setEnabled(false);
				}
			}
			JToolBars.update("Player 1 wins!");
		}
		if(p2Win){
			for (JButton[] q1: b){
				for (JButton q2: q1){
					q2.setEnabled(false);
				}
			}
			JToolBars.update("Player 2 wins!");
		}
	}
	public static void getAll(int[] l, JButton[][] b1, Color[][] c){
		location = l;
		b = b1;
		colors = c;
	}
	public static void getImageIcons(ImageIcon BG1, ImageIcon BR1, ImageIcon KG1, ImageIcon KR1, ImageIcon KnG1, ImageIcon KnR1, ImageIcon PG1, ImageIcon PR1, ImageIcon QG1, ImageIcon QR1, ImageIcon RG1, ImageIcon RR1){
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
	}
}
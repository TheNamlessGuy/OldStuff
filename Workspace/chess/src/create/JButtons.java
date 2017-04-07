package create;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import listeners.ActionListeners;
public class JButtons {
	public static JButton[][] b(ImageIcon BG, ImageIcon BR, ImageIcon KG, ImageIcon KR, ImageIcon KnG, ImageIcon KnR, ImageIcon PG, ImageIcon PR, ImageIcon QG, ImageIcon QR, ImageIcon RG, ImageIcon RR) {
		JButton[][] b = new JButton[8][8];
		
		int row = 0, col = 0;
		while (row != 8){
			while (col != 8){
				if ((row + col) % 2 == 0){
					b[row][col] = new JButton();
					b[row][col].setBackground(Color.white);
				}
				else{
					b[row][col] = new JButton();
					b[row][col].setBackground(Color.black);
				}
				col++;
			}
			row++;
			col = 0;
		}
		col = 0;

		b[0][0].setIcon(RR);
		b[0][0].setToolTipText("Red Rook");
		b[0][1].setIcon(KnR);
		b[0][1].setToolTipText("Red Knight");
		b[0][2].setIcon(BR);
		b[0][2].setToolTipText("Red Bishop");
		b[0][3].setIcon(QR);
		b[0][3].setToolTipText("Red Queen");
		b[0][4].setIcon(KR);
		b[0][4].setToolTipText("Red King");
		b[0][5].setIcon(BR);
		b[0][5].setToolTipText("Red Bishop");
		b[0][6].setIcon(KnR);
		b[0][6].setToolTipText("Red Knight");
		b[0][7].setIcon(RR);
		b[0][7].setToolTipText("Red Rook");
		while (col != 8){
			b[1][col].setIcon(PR);
			b[1][col].setToolTipText("Red Pawn");
			col++;
		}
		col = 0;

		b[7][0].setIcon(RG);
		b[7][0].setToolTipText("Green Rook");
		b[7][1].setIcon(KnG);
		b[7][0].setToolTipText("Green Knight");
		b[7][2].setIcon(BG);
		b[7][0].setToolTipText("Green Bishop");
		b[7][3].setIcon(QG);
		b[7][0].setToolTipText("Green Queen");
		b[7][4].setIcon(KG);
		b[7][0].setToolTipText("Green King");
		b[7][5].setIcon(BG);
		b[7][0].setToolTipText("Green Bishop");
		b[7][6].setIcon(KnG);
		b[7][0].setToolTipText("Green Knight");
		b[7][7].setIcon(RG);
		b[7][0].setToolTipText("Green Rook");
		while (col != 8){
			b[6][col].setIcon(PG);
			b[6][col].setToolTipText("Green Pawn");
			col++;
		}
		ActionListeners.getButtons(b);
		return b;
	}
}
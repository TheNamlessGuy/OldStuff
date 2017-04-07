package game;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import listeners.ActionListeners;
import create.*;
public class Maaaaaaaaain {
	static ImageIcon BG = new ImageIcon("D:\\images\\BishopGreen.png");
	static ImageIcon BR = new ImageIcon("D:\\images\\BishopRed.png");
	static ImageIcon KG = new ImageIcon("D:\\images\\KingGreen.png");
	static ImageIcon KR = new ImageIcon("D:\\images\\KingRed.png");
	static ImageIcon KnG = new ImageIcon("D:\\images\\KnightGreen.png");
	static ImageIcon KnR = new ImageIcon("D:\\images\\KnightRed.png");
	static ImageIcon PG = new ImageIcon("D:\\images\\PawnGreen.png");
	static ImageIcon PR = new ImageIcon("D:\\images\\PawnRed.png");
	static ImageIcon QG = new ImageIcon("D:\\images\\QueenGreen.png");
	static ImageIcon QR = new ImageIcon("D:\\images\\QueenRed.png");
	static ImageIcon RG = new ImageIcon("D:\\images\\RookGreen.png");
	static ImageIcon RR = new ImageIcon("D:\\images\\RookRed.png");
	static ImageIcon[] enemies = {BR, KR, KnR, PR, QR, RR};
	static Color[][] colors = new Color[8][8];
	public static void main(String[] args){
		int row = 0, col = 0;
		while (row != 8){
			while (col != 8){
				if ((row + col) % 2 == 0){
					colors[row][col] = Color.white;
				}else{
					colors[row][col] = Color.black;
				}
				col++;
			}
			row++;
			col = 0;
		}
		ActionListeners.getColors(colors);
		ActionListeners.getImageIcons(BG, BR, KG, KR, KnG, KnR, PG, PR, QG, QR, RG, RR, enemies);
		JFrames.getImageIcons(BG, BR, KG, KR, KnG, KnR, PG, PR, QG, QR, RG, RR);
		JFrame startUpFrame = JFrames.startUpFrame();
		startUpFrame.setVisible(true);
	}
}
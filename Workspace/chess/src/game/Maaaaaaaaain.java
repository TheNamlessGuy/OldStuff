package game;
import java.awt.Color;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import listeners.ActionListeners;
import listeners.MoveListener;
import listeners.ReplayListener;
import create.*;
public class Maaaaaaaaain {
	static String installLocation = "D:\\";
	static ImageIcon BG = new ImageIcon(installLocation+"images\\BishopGreen.png");
	static ImageIcon BR = new ImageIcon(installLocation+"images\\BishopRed.png");
	static ImageIcon KG = new ImageIcon(installLocation+"images\\KingGreen.png");
	static ImageIcon KR = new ImageIcon(installLocation+"images\\KingRed.png");
	static ImageIcon KnG = new ImageIcon(installLocation+"images\\KnightGreen.png");
	static ImageIcon KnR = new ImageIcon(installLocation+"images\\KnightRed.png");
	static ImageIcon PG = new ImageIcon(installLocation+"images\\PawnGreen.png");
	static ImageIcon PR = new ImageIcon(installLocation+"images\\PawnRed.png");
	static ImageIcon QG = new ImageIcon(installLocation+"images\\QueenGreen.png");
	static ImageIcon QR = new ImageIcon(installLocation+"images\\QueenRed.png");
	static ImageIcon RG = new ImageIcon(installLocation+"images\\RookGreen.png");
	static ImageIcon RR = new ImageIcon(installLocation+"images\\RookRed.png");
	static ImageIcon[] enemiesG = {BR, KR, KnR, PR, QR, RR};
	static ImageIcon[] enemiesR = {BG, KG, KnG, PG, QG, RG};
	static ImageIcon[] friendlyG = {BG, KG, KnG, PG, QG, RG};
	static ImageIcon[] friendlyR = {BR, KR, KnR, PR, QR, RR};
	static Color[][] colors = new Color[8][8];
	static boolean p1 = false;
	static JFrame gameFrame = new JFrame();
	static JFrame updateFrame = new JFrame();
	static JFrame gameModeFrame = new JFrame();
	public static void main(String[] args) throws IOException{
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
		JFrames.getImageIcons(BG, BR, KG, KR, KnG, KnR, PG, PR, QG, QR, RG, RR);
		ActionListeners.getAll(BG, BR, KG, KR, KnG, KnR, PG, PR, QG, QR, RG, RR, enemiesG, friendlyG, enemiesR, friendlyR, colors);
		MoveListener.getImageIcons(BG, BR, KG, KR, KnG, KnR, PG, PR, QG, QR, RG, RR);
		gameModeFrame = JFrames.gameModeFrame();
		gameModeFrame.setVisible(true);
		p1 = true;
	}
    public static boolean getP1(){
    	return p1;
    }
    public static void changeP1(){
    	p1 = !p1;
    	JToolBars.changePlayer();
    }
    public static void replay(){
    	p1 = true;
    }
    public static void startGame() throws IOException{
		gameFrame = JFrames.gameFrame(BG, BR, KG, KR, KnG, KnR, PG, PR, QG, QR, RG, RR);
    	gameFrame.setVisible(true);
    	ReplayListener.getFrames(gameFrame, updateFrame);
    }
}
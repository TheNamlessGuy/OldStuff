package game;
import javax.swing.ImageIcon;
import javax.swing.JButton;
public class Get {
	public static int[] location(JButton q, JButton[][] b) {
		int[] i = new int[2];
		int i1 = 0, i2 = 0;
		while (i1 != 8){
			while (i2 != 8){
				if (b[i1][i2] == q){
					i[0] = i1;
					i[1] = i2;
				}
				i2++;
			}
			i2 = 0;
			i1++;
		}
		return i;
	}
	public static ImageIcon currentPiece(int[] location, JButton[][] b){
		ImageIcon IC = new ImageIcon();
		IC = (ImageIcon)b[location[0]][location[1]].getIcon();
		return IC;
	}
}
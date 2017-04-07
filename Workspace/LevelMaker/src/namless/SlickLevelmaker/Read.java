package namless.SlickLevelmaker;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JPanel;

public class Read {
	public static String s;
	public static int x = 0;
	public static int y = 0;
	public static JPanel[][] read(File file) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new FileReader(file));
		int index;
		boolean playerSpawn;
		boolean enemySpawn;
		JPanel[][] tiles = null;
		while ((s = br.readLine()) != null) {
			index = s.indexOf(':')+1;
			if (s.contains("SIZE X")){
				x = Integer.parseInt(s.substring(index, s.length()));
			}else if (s.contains("SIZE Y")){
				y = Integer.parseInt(s.substring(index, s.length()));
				tiles = new JPanel[x][y];
				for (int i = 0; i < x; i++){
					for (int j = 0; j < y; j++){
						tiles[i][j] = new JPanel();
						tiles[i][j].setBackground(Color.black);
					}
				}
			}else{
				x = 0;
				y = 0;
				if(s.contains("AIR")){
					s = s.substring(index, s.length());
					index = s.indexOf(':')+1;
					x = Integer.parseInt(s.substring(0,index-1));
					s = s.substring(index, s.length());
					index = s.indexOf(':')+1;
					y = Integer.parseInt(s.substring(0, index-1));
					s = s.substring(index, s.length());
					index = s.indexOf(':')+1;
					playerSpawn = Boolean.parseBoolean(s.substring(0, index-1));
					enemySpawn = Boolean.parseBoolean(s.substring(index, s.length()));
					if (playerSpawn){
						tiles[y][x].setBackground(Color.green);
					}else if(enemySpawn){
						
					}else{
						tiles[y][x].setBackground(Color.yellow);
					}
				}else if (s.contains("FIRE")){
					s = s.substring(index, s.length());
					index = s.indexOf(':')+1;
					x = Integer.parseInt(s.substring(0,index-1));
					s = s.substring(index, s.length());
					index = s.indexOf(':')+1;
					y = Integer.parseInt(s.substring(0, index-1));
					s = s.substring(index, s.length());
					index = s.indexOf(':')+1;
					playerSpawn = Boolean.parseBoolean(s.substring(0, index-1));
					enemySpawn = Boolean.parseBoolean(s.substring(index, s.length()));
					tiles[y][x].setBackground(Color.red);
				}else if (s.contains("HIDDEN")){
					s = s.substring(index, s.length());
					index = s.indexOf(':')+1;
					x = Integer.parseInt(s.substring(0,index-1));
					s = s.substring(index, s.length());
					index = s.indexOf(':')+1;
					y = Integer.parseInt(s.substring(0, index-1));
					s = s.substring(index, s.length());
					index = s.indexOf(':')+1;
					playerSpawn = Boolean.parseBoolean(s.substring(0, index-1));
					enemySpawn = Boolean.parseBoolean(s.substring(index, s.length()));
					tiles[y][x].setBackground(LevelMakerMain.purple);
				}else if(s.contains("WALL")){
					s = s.substring(index, s.length());
					index = s.indexOf(':')+1;
					x = Integer.parseInt(s.substring(0, index-1));
					s = s.substring(index, s.length());
					index = s.indexOf(':')+1;
					y = Integer.parseInt(s.substring(0, index-1));
					s = s.substring(index, s.length());
					index = s.indexOf(':')+1;
					playerSpawn = Boolean.parseBoolean(s.substring(0, index-1));
					enemySpawn = Boolean.parseBoolean(s.substring(index, s.length()));
					tiles[y][x].setBackground(Color.gray);
				}else if(s.contains("BREAK")){
					s = s.substring(index, s.length());
					index = s.indexOf(':')+1;
					x = Integer.parseInt(s.substring(0, index-1));
					s = s.substring(index, s.length());
					index = s.indexOf(':')+1;
					y = Integer.parseInt(s.substring(0, index-1));
					s = s.substring(index, s.length());
					index = s.indexOf(':')+1;
					playerSpawn = Boolean.parseBoolean(s.substring(0, index-1));
					enemySpawn = Boolean.parseBoolean(s.substring(index, s.length()));
					tiles[y][x].setBackground(Color.cyan);
				}
			}
		}
		br.close();
		return tiles;
	}
}

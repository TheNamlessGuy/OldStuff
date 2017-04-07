package namless.SlickLevelmaker.listeners;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import namless.SlickLevelmaker.JPanels;
import namless.SlickLevelmaker.LevelMakerMain;


public class SaveListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		File file = new File("levels");
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(file+"\\"+InitListener.name+".txt"));
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		try{
			file.mkdir();
		}catch(Exception err){
			err.printStackTrace();
		}
		ArrayList<Point> airList = new ArrayList<Point>();
		ArrayList<Point> fireList = new ArrayList<Point>();
		ArrayList<Point> hiddenList = new ArrayList<Point>();
		for (int i = 0; i < InitListener.y; i++){
			for (int j = 0; j < InitListener.x; j++){
				if (JPanels.panels[i][j].getBackground() == Color.yellow){
					airList.add(new Point(i,j));
				}else if(JPanels.panels[i][j].getBackground() == Color.red){
					fireList.add(new Point(i,j));
				}else if(JPanels.panels[i][j].getBackground() == LevelMakerMain.purple){
					hiddenList.add(new Point(i,j));
				}
			}
		}
		try {
			bw.write("SIZE X:" + InitListener.x);
			bw.newLine();
			bw.write("SIZE Y:" + InitListener.y);
			bw.newLine();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		for (Point p: airList){
			try{
				bw.write("AIR:"+(int)p.getX()+":"+(int)p.getY()+":false:false");
				bw.newLine();
			}catch(Exception err){
				err.printStackTrace();
			}
		}
		for (Point p: fireList){
			try{
				bw.write("FIRE:"+(int)p.getX()+":"+(int)p.getY()+":false:false");
				bw.newLine();
			}catch(Exception err){
				err.printStackTrace();
			}
		}
		for (Point p: hiddenList){
			try{
				bw.write("HIDDEN:"+(int)p.getX()+":"+(int)p.getY()+":false:false");
				bw.newLine();
			}catch(Exception err){
				err.printStackTrace();
			}
		}
		if (bw != null){
			try {
				bw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		try {
			Desktop.getDesktop().open(new File(System.getProperty("user.dir")+"\\levels"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.exit(0);
	}
}

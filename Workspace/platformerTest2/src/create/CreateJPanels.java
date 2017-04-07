package create;
import java.awt.GridLayout;
import javax.swing.JPanel;
import variables.*;
public class CreateJPanels {
	public static JPanel playingPanel(){
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(Ints.screenSizeX,Ints.screenSizeY));
        for(JPanel[] p1: JPanels.gamePanel){
        	for (JPanel p2: p1){
            	p.add(p2);
            }
        }
		return p;
	}
	public static JPanel[] talkingPanels(){
		JPanel[] panel = new JPanel[4];
		panel[0] = new JPanel();
		panel[0].setBackground(Colors.skyBackground);
		panel[0].add(JLabels.pLabel);
		panel[1] = new JPanel();
		panel[1].setBackground(Colors.skyBackground);
		panel[1].add(JLabels.oLabel);
		panel[2] = new JPanel();
		panel[2].setBackground(Colors.groundBackground);
		panel[2].add(JLabels.pTalkingLabel);
		panel[3] = new JPanel();
		panel[3].setBackground(Colors.groundBackground);
		panel[3].add(JLabels.oTalkingLabel);
		return panel;
	}
	public static JPanel talkingPanel(){
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,2));
		for (JPanel p1: JPanels.talkingPanels){
			panel.add(p1);
		}
		return panel;
	}
}
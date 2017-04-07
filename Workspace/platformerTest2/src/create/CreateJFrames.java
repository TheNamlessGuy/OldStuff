package create;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import variables.*;
import listeners.*;
import javax.swing.JFrame;
public class CreateJFrames {
	public static JFrame gameFrame(){
		JFrame gameFrame = new JFrame();
		gameFrame.setTitle("Gaem");
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setResizable(false);
		gameFrame.setUndecorated(false);
		gameFrame.setVisible(true);
		gameFrame.setBackground(Color.black);
		gameFrame.addKeyListener(new MoveListener());
		
        JPanels.playingPanel = CreateJPanels.playingPanel();
        gameFrame.add(JPanels.playingPanel);
        gameFrame.pack();
		
		Dimension d = gameFrame.getSize();
        int w1 = (int)d.getWidth() / 2;
        int h1 = (int)d.getHeight() / 2;
        int w2 = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth() / 2;
        int h2 = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight() / 2;
        h2 = h2 - h1;
        w2 = w2 - w1;
        gameFrame.setLocation(w2, h2);
		return gameFrame;
	}
}
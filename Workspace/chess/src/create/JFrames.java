package create;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import listeners.*;
    public class JFrames {static ImageIcon BG;
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
		static JFrame gameFrame = new JFrame();
		static JFrame gameModeFrame = new JFrame();
            public static JFrame gameFrame(ImageIcon BG, ImageIcon BR, ImageIcon KG, ImageIcon KR, ImageIcon KnG, ImageIcon KnR, ImageIcon PG, ImageIcon PR, ImageIcon QG, ImageIcon QR, ImageIcon RG, ImageIcon RR) throws IOException{
            		gameFrame = new JFrame();
            		int row = 0, col = 0;
            		
                    JPanel panel = new JPanel();
                    
                    JButton[][] buttons = JButtons.b(BG, BR, KG, KR, KnG, KnR, PG, PR, QG, QR, RG, RR);
                    
                    gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    gameFrame.setTitle("Chess");
                    gameFrame.setResizable(false);
                    
                    panel.setLayout(new GridLayout(8,8));

                    while (row != 8){
                    	while(col != 8){
                        	panel.add(buttons[row][col]);
                    		col++;
                    	}
                    	row++;
                    	col = 0;
                    }
                    
                    JToolBar toolbar = JToolBars.toolbar();
                    gameFrame.add(panel);
                    gameFrame.add(toolbar, BorderLayout.NORTH);
                    gameFrame.pack();
                    
                    Dimension d = gameFrame.getSize();
                    int w1 = (int)d.getWidth() / 2;
                    int h1 = (int)d.getHeight() / 2;
                    int w2 = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth() / 2;
                    int h2 = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight() / 2;
                    h2 = h2 - h1;
                    w2 = w2 - w1;
                    gameFrame.setLocation(w2, h2);
                    
                    ActionListeners a = new ActionListeners();
                    row = 0;
                    col = 0;
                    while (row != 8){
                    	while(col != 8){
                    		buttons[row][col].addActionListener(a);
                        	col++;
                    	}
                    	row++;
                    	col = 0;
                    }
                    return gameFrame;
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
            public static JFrame gameModeFrame(){
            	gameModeFrame = new JFrame();
            	gameModeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            	gameModeFrame.setTitle("Choose your gamemode!");
            	gameModeFrame.setLayout(new FlowLayout());
            	gameModeFrame.setSize(230,100);
            	gameModeFrame.setResizable(false);
            	
            	JButton vsComp = new JButton("vs. Computer");
            	JButton vsPlay = new JButton("vs. Player");
            	
            	gameModeFrame.add(new JLabel("<html><center>Choose your gamemode!</center></html>"));
            	gameModeFrame.add(vsPlay);
            	gameModeFrame.add(vsComp);
            	
            	Dimension d = gameModeFrame.getSize();
                int w1 = (int)d.getWidth() / 2;
                int h1 = (int)d.getHeight() / 2;
                int w2 = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth() / 2;
                int h2 = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight() / 2;
                h2 = h2 - h1;
                w2 = w2 - w1;
                gameModeFrame.setLocation(w2, h2);
            	
            	GameModeListener.getAll(vsComp, vsPlay, gameModeFrame);
            	
            	vsPlay.addActionListener(new GameModeListener());
            	vsComp.addActionListener(new GameModeListener());
            	
            	return gameModeFrame;
            }
    }
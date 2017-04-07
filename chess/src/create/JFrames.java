package create;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import debug.Bedug;
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
            public static JFrame gameFrame(ImageIcon BG, ImageIcon BR, ImageIcon KG, ImageIcon KR, ImageIcon KnG, ImageIcon KnR, ImageIcon PG, ImageIcon PR, ImageIcon QG, ImageIcon QR, ImageIcon RG, ImageIcon RR) throws IOException{
            		int row = 0, col = 0;
            		
                    JFrame frame = new JFrame();
                    JPanel panel = new JPanel();
                    
                    JButton[][] buttons = JButtons.b(BG, BR, KG, KR, KnG, KnR, PG, PR, QG, QR, RG, RR);
                    
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setTitle("Chess");
                    frame.setResizable(false);
                    
                    panel.setLayout(new GridLayout(8,8));

                    while (row != 8){
                    	while(col != 8){
                        		panel.add(buttons[row][col]);
                    		col++;
                    	}
                    	row++;
                    	col = 0;
                    }
                    
                    frame.add(panel);
                    frame.pack();
                    
                    Dimension d = frame.getSize();
                    int w1 = (int)d.getWidth() / 2;
                    int h1 = (int)d.getHeight() / 2;
                    int w2 = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth() / 2;
                    int h2 = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight() / 2;
                    h2 = h2 - h1;
                    w2 = w2 - w1;
                    frame.setLocation(w2, h2);
                    
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
                    return frame;
            }
            public static JFrame startUpFrame(){
            	final JFrame frame = new JFrame();
            	JLabel label = new JLabel("<html><center>Welcome to chess!<br>Against what would you like to play?</center></html>");
            	final JButton SP = new JButton("vs. Computer");
            	final JButton MP = new JButton("vs. Other Player");
            	MP.setEnabled(false);
            	
            	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            	frame.setTitle("Chess");
            	frame.setResizable(false);
            	frame.setLayout(new FlowLayout());
            	frame.setSize(250,100);
            	
            	Dimension d = frame.getSize();
                int w1 = (int)d.getWidth() / 2;
                int h1 = (int)d.getHeight() / 2;
                int w2 = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth() / 2;
                int h2 = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight() / 2;
                h2 = h2 - h1;
                w2 = w2 - w1;
                frame.setLocation(w2, h2);
                
                frame.add(label);
                frame.add(SP);
                frame.add(MP);
                
                ActionListener lis = new ActionListener(){
                	public void actionPerformed(ActionEvent e){
                		if (e.getSource() == SP){
                			JFrame gameFrame = new JFrame();
							try {
								gameFrame = JFrames.gameFrame(BG, BR, KG, KR, KnG, KnR, PG, PR, QG, QR, RG, RR);
							} catch (IOException e1) {}
                			gameFrame.setVisible(true);
                			Bedug bedug = new Bedug();
                    		frame.dispose();
                		}else if (e.getSource() == MP){
                			//MP
                			frame.dispose();
                		}
                	}
                };

                SP.addActionListener(lis);
                MP.addActionListener(lis);
            	
            	return frame;
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
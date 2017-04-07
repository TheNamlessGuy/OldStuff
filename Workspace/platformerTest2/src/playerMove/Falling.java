package playerMove;
import variables.*;
public class Falling implements Runnable{
	public void run() {
		while(Booleans.playing){
			try{
				Thread.sleep(10);
			}catch(InterruptedException e){}
			if (!Booleans.jumping && !Booleans.hax){
				while(JPanels.gamePanel[Ints.location[0]+1][Ints.location[1]].getBackground() == Colors.skyBackground){
					if(JPanels.gamePanel[Ints.location[0]+1][Ints.location[1]].getBackground() == Colors.skyBackground){
						JPanels.gamePanel[Ints.location[0]][Ints.location[1]].remove(Icons.playerIcon);
						Ints.location[0]++;
						JPanels.gamePanel[Ints.location[0]][Ints.location[1]].add(Icons.playerIcon);
						JFrames.gameFrame.repaint();
					}
					try {
						Thread.sleep(30);
					} catch (InterruptedException e) {}
					if (JPanels.gamePanel[Ints.location[0]+1][Ints.location[1]].getBackground() == Colors.death){
						Booleans.dying = true;
						JPanels.gamePanel[Ints.location[0]][Ints.location[1]].remove(Icons.playerIcon);
						Ints.location[0]++;
						JPanels.gamePanel[Ints.location[0]][Ints.location[1]].add(Icons.playerIcon);
						JFrames.gameFrame.repaint();
						try{
							Thread.sleep(500);
						}catch(InterruptedException e){}
						Teleport.dieTeleport();
					}
				}
				
			}
		}
	}
}

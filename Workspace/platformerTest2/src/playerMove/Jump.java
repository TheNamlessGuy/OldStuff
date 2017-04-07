package playerMove;
import variables.*;
public class Jump implements Runnable{
	public void run() {
		int upJump = 0;
		for(int index = 0; index != Ints.jumpHeight; index++){
			if (JPanels.gamePanel[Ints.location[0]-1][Ints.location[1]].getBackground() == Colors.skyBackground){
				Booleans.jumping = true;
				JPanels.gamePanel[Ints.location[0]][Ints.location[1]].remove(Icons.playerIcon);
				Ints.location[0]--;
				JPanels.gamePanel[Ints.location[0]][Ints.location[1]].add(Icons.playerIcon);
				JFrames.gameFrame.repaint();
			}
			try{
				Thread.sleep(50);
			}catch (InterruptedException e){}
			upJump++;
		}
		while(upJump > 0){
			if(JPanels.gamePanel[Ints.location[0]+1][Ints.location[1]].getBackground() == Colors.skyBackground && !Booleans.dying){
				JPanels.gamePanel[Ints.location[0]][Ints.location[1]].remove(Icons.playerIcon);
				Ints.location[0]++;
				JPanels.gamePanel[Ints.location[0]][Ints.location[1]].add(Icons.playerIcon);
				JFrames.gameFrame.repaint();
			}
			try{
				Thread.sleep(50);
			}catch (InterruptedException e){}
			if (JPanels.gamePanel[Ints.location[0]+1][Ints.location[1]].getBackground() == Colors.death){
				Booleans.dying = true;
				JPanels.gamePanel[Ints.location[0]][Ints.location[1]].remove(Icons.playerIcon);
				Ints.location[0]++;
				JPanels.gamePanel[Ints.location[0]][Ints.location[1]].add(Icons.playerIcon);
				JFrames.gameFrame.repaint();
				upJump--;
				try{
					Thread.sleep(500);
				}catch(InterruptedException e){}
				Teleport.dieTeleport();
			}
			upJump--;
		}
		upJump = 0;
		Booleans.jumping = false;
	}
}

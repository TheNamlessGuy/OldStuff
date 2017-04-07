package listeners;
import hax.CreateHaxFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import playerMove.*;
import variables.*;
public class MoveListener implements KeyListener{
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()){
		case KeyEvent.VK_LEFT:
							//MOVE LEFT
							if (!Booleans.jumping && !Booleans.notMove){
								Move.left();
							}
							break;
		case KeyEvent.VK_RIGHT:
							//MOVE RIGHT
							if (!Booleans.jumping &&!Booleans.notMove){
								Move.right();
							}
							break;
		default:
			break;
		}
	}
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()){
		case KeyEvent.VK_UP:
							//JUMP
							if (!Booleans.jumping && !Booleans.notMove){
							Threads.jump.start();
							Threads.remakeJump();
							}
							break;
		case KeyEvent.VK_LEFT:
							//LEFT WHEN JUMPING
							if (Booleans.jumping && !Booleans.notMove){
								Move.left();
							}
							break;
		case KeyEvent.VK_RIGHT:
							//RIGHT WHEN JUMPING
							if (Booleans.jumping && !Booleans.notMove){
								Move.right();
							}
							break;
		case KeyEvent.VK_SPACE:
							//ACTION
							Actions.action();
							break;
		case KeyEvent.VK_DELETE:
							//CHEATS
							JFrames.haxFrame = CreateHaxFrame.haxFrame();
							break;
		case KeyEvent.VK_DOWN:
							//NADA
							break;
		default:
			break;
		}
	}
	public void keyTyped(KeyEvent e) {
		
	}

}

package game;
import variables.*;
public class platformerTestMain {
	public static void main(String[] args) {
		JFrames.gameFrame();
		Booleans.playing = true;
		Threads.fall.start();
	}
	public static void quit(){
		Booleans.playing = false;
		JFrames.gameFrame.dispose();
	}
}
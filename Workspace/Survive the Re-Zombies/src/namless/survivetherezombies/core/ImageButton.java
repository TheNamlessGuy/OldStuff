package namless.survivetherezombies.core;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.openal.Audio;
public class ImageButton {
	private Image activeImg;
	private Image notHoverImg;
	private Image hoverImg;
	private int x;
	private int y;
	private boolean hoverPlayed;
	static Audio hover;
	static Audio click;
	public ImageButton(Image image, int x, int y, boolean hover) {
		hoverPlayed = false;
		this.x = x;
		this.y = y;
		if (hover){
			notHoverImg = image.getSubImage(0, 0, image.getWidth(), (image.getHeight() / 2));
			hoverImg = image.getSubImage(0, (image.getHeight() / 2), image.getWidth(), (image.getHeight() / 2));
		}else{
			notHoverImg = image;
		}
		activeImg = notHoverImg;
	}

	public void render(Graphics g) {
		g.drawImage(activeImg, x, y);
	}

	public boolean isClicked(int mouseX, int mouseY) {
		if ((mouseX > x && mouseX < (x + activeImg.getWidth())) && (mouseY > y && mouseY < (y + activeImg.getHeight()))){
			Play.soundEffect(click, 0.3f);
			return true;
		}
		return false;
	}

	public void isHover(int mouseX, int mouseY) {
		if ((mouseX > x && mouseX < (x + activeImg.getWidth())) && (mouseY > y && mouseY < (y + activeImg.getHeight()))) {
			hoverSound();
			hoverPlayed = true;
			activeImg = hoverImg;
		} else {
			hoverPlayed = false;
			activeImg = notHoverImg;
		}
	}
	public int getWidth(){
		return activeImg.getWidth();
	}
	public int getHeight(){
		return activeImg.getHeight();
	}
	public void centerX(int screenX){
		x = screenX/2 - getWidth()/2;
	}
	public void centerY(int screenY){
		y = screenY/2 - getHeight()/2;
	}
	public static void setHoverSound(Audio a){
		hover = a;
	}
	public static void setClickSound(Audio a){
		click = a;
	}
	public void hoverSound(){
		if (!hoverPlayed){
			Play.soundEffect(hover, 0.3f);
		}
	}
}

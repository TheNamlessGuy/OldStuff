package nam.namless.GameName.Client.Core;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
public class ImageButton {
	private Image activeImg;
	private Image notHoverImg;
	private Image hoverImg;
	private int x;
	private int y;

	public ImageButton(Image image, int x, int y, boolean hover) {
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
		if ((mouseX > x && mouseX < (x + activeImg.getWidth())) && (mouseY > y && mouseY < (y + activeImg.getHeight()))) {
			return true;
		}
		return false;
	}

	public void isHover(int mouseX, int mouseY) {
		if ((mouseX > x && mouseX < (x + activeImg.getWidth())) && (mouseY > y && mouseY < (y + activeImg.getHeight()))) {
			activeImg = hoverImg;
		} else {
			activeImg = notHoverImg;
		}
	}
}

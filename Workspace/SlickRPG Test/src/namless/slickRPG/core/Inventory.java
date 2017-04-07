package namless.slickRPG.core;

import namless.slickRPG.Maine;
import namless.slickRPG.items.Pickaxe;
import namless.slickRPG.items.QuestItem;
import namless.slickRPG.supers.Item;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class Inventory {
	private boolean isActive = false;
	private static int x;
	private static int y;
	private Item[] inv;
	public Inventory(Item[] inv){
		this.inv = inv;
		x = Maine.screenX/2-110;
		y = Maine.screenY/2-90;
	}
	public void render(Graphics g){
		g.setColor(Color.darkGray);
		g.fillRect(x, y, 220, 200);
		g.setColor(Color.white);
		g.drawString("Inventory", x+70, y);
		//Row 1
		g.drawRect(x+10, y+30, 40, 40);
		g.drawRect(x+50, y+30, 40, 40);
		g.drawRect(x+90, y+30, 40, 40);
		g.drawRect(x+130, y+30, 40, 40);
		g.drawRect(x+170, y+30, 40, 40);
		//Row 2
		g.drawRect(x+10, y+70, 40, 40);
		g.drawRect(x+50, y+70, 40, 40);
		g.drawRect(x+90, y+70, 40, 40);
		g.drawRect(x+130, y+70, 40, 40);
		g.drawRect(x+170, y+70, 40, 40);
		//Row 3
		g.drawRect(x+10, y+110, 40, 40);
		g.drawRect(x+50, y+110, 40, 40);
		g.drawRect(x+90, y+110, 40, 40);
		g.drawRect(x+130, y+110, 40, 40);
		g.drawRect(x+170, y+110, 40, 40);
		// Row 4
		g.drawRect(x+10, y+150, 40, 40);
		g.drawRect(x+50, y+150, 40, 40);
		g.drawRect(x+90, y+150, 40, 40);
		g.drawRect(x+130, y+150, 40, 40);
		g.drawRect(x+170, y+150, 40, 40);
		int counter = 0;
		for (int i = 0; i < 4; i++){
			for (int j = 0; j < 5; j++){
				if (inv[counter].getImage() != null){
					g.drawImage(inv[counter].getImage(), x+10+(40*j), y+30+(40*i));
				}
				counter++;
			}
		}
		for (int i = 0; i < 20; i++){
			inv[i].render(g);
		}
	}
	public void update(Input in){
		if (in.isKeyPressed(Input.KEY_I)){
			isActive = false;
		}
		int mX = in.getMouseX();
		int mY = in.getMouseY();
		if ((mY > y+30 && mY < y+70) && (mX > x+10 && mX < x+210)){ //Row 1
			if (mX > x+10 && mX < x + 50){
				inv[0].setHover(true);
				inv[0].update();
				if (in.isMousePressed(0)){
					inv[0].action();
				}
			}else{
				inv[0].setHover(false);
			}
			if(mX > x+50 && mX < x+90){
				inv[1].setHover(true);
				inv[1].update();
				if (in.isMousePressed(0)){
					inv[1].action();
				}
			}else{
				inv[1].setHover(false);
			}
			if(mX > x+90 && mX < x+130){
				inv[2].setHover(true);
				inv[2].update();
				if (in.isMousePressed(0)){
					inv[2].action();
				}
			}else{
				inv[2].setHover(false);
			}
			if(mX > x+130 && mX < x+170){
				inv[3].setHover(true);
				inv[3].update();
				if (in.isMousePressed(0)){
					inv[3].action();
				}
			}else{
				inv[3].setHover(false);
			}
			if(mX > x+170 && mX < x+210){
				inv[4].setHover(true);
				inv[4].update();
				if (in.isMousePressed(0)){
					inv[4].action();
				}
			}else{
				inv[4].setHover(false);
			}
		}else{
			inv[0].setHover(false);
			inv[1].setHover(false);
			inv[2].setHover(false);
			inv[3].setHover(false);
			inv[4].setHover(false);
		}
		if((mY > y+70 && mY < y+110) && (mX > x+10 && mX < x+210)){ //Row 2
			if (mX > x+10 && mX < x + 50){
				inv[5].setHover(true);
				inv[5].update();
				if (in.isMousePressed(0)){
					inv[5].action();
				}
			}else{
				inv[5].setHover(false);
			}
			if(mX > x+50 && mX < x+90){
				inv[6].setHover(true);
				inv[6].update();
				if (in.isMousePressed(0)){
					inv[6].action();
				}
			}else{
				inv[6].setHover(false);
			}
			if(mX > x+90 && mX < x+130){
				inv[7].setHover(true);
				inv[7].update();
				if (in.isMousePressed(0)){
					inv[7].action();
				}
			}else{
				inv[7].setHover(false);
			}
			if(mX > x+130 && mX < x+170){
				inv[8].setHover(true);
				inv[8].update();
				if (in.isMousePressed(0)){
					inv[8].action();
				}
			}else{
				inv[8].setHover(false);
			}
			if(mX > x+170 && mX < x+210){
				inv[9].setHover(true);
				inv[9].update();
				if (in.isMousePressed(0)){
					inv[9].action();
				}
			}else{
				inv[9].setHover(false);
			}
		}else{
			inv[5].setHover(false);
			inv[6].setHover(false);
			inv[7].setHover(false);
			inv[8].setHover(false);
			inv[9].setHover(false);
		}
		if((mY > y+110 && mY < y+150) && (mX > x+10 && mX < x+210)){ //Row 3
			if (mX > x+10 && mX < x + 50){
				inv[10].setHover(true);
				inv[10].update();
				if (in.isMousePressed(0)){
					inv[10].action();
				}
			}else{
				inv[10].setHover(false);
			}
			if(mX > x+50 && mX < x+90){
				inv[11].setHover(true);
				inv[11].update();
				if (in.isMousePressed(0)){
					inv[11].action();
				}
			}else{
				inv[11].setHover(false);
			}
			if(mX > x+90 && mX < x+130){
				inv[12].setHover(true);
				inv[12].update();
				if (in.isMousePressed(0)){
					inv[12].action();
				}
			}else{
				inv[12].setHover(false);
			}
			if(mX > x+130 && mX < x+170){
				inv[13].setHover(true);
				inv[13].update();
				if (in.isMousePressed(0)){
					inv[13].action();
				}
			}else{
				inv[13].setHover(false);
			}
			if(mX > x+170 && mX < x+210){
				inv[14].setHover(true);
				inv[14].update();
				if (in.isMousePressed(0)){
					inv[14].action();
				}
			}else{
				inv[14].setHover(false);
			}
		}else{
			inv[10].setHover(false);
			inv[11].setHover(false);
			inv[12].setHover(false);
			inv[13].setHover(false);
			inv[14].setHover(false);
		}
		if((mY > y+150 && mY < y+190) && (mX > x+10 && mX < x+210)){ //Row 4
			if (mX > x+10 && mX < x + 50){
				inv[15].setHover(true);
				inv[15].update();
				if (in.isMousePressed(0)){
					inv[15].action();
				}
			}else{
				inv[15].setHover(false);
			}
			if(mX > x+50 && mX < x+90){
				inv[16].setHover(true);
				inv[16].update();
				if (in.isMousePressed(0)){
					inv[16].action();
				}
			}else{
				inv[16].setHover(false);
			}
			if(mX > x+90 && mX < x+130){
				inv[17].setHover(true);
				inv[17].update();
				if (in.isMousePressed(0)){
					inv[17].action();
				}
			}else{
				inv[17].setHover(false);
			}
			if(mX > x+130 && mX < x+170){
				inv[18].setHover(true);
				inv[18].update();
				if (in.isMousePressed(0)){
					inv[18].action();
				}
			}else{
				inv[18].setHover(false);
			}
			if(mX > x+170 && mX < x+210){
				inv[19].setHover(true);
				inv[19].update();
				if (in.isMousePressed(0)){
					inv[19].action();
				}
			}else{
				inv[19].setHover(false);
			}
		}else{
			inv[15].setHover(false);
			inv[16].setHover(false);
			inv[17].setHover(false);
			inv[18].setHover(false);
			inv[19].setHover(false);
		}
	}
	public boolean isActive(){
		return isActive;
	}
	public void setActive(boolean b){
		isActive = b;
	}
	public Item[] getList(){
		return inv;
	}
	public boolean containsGold(){
		for (Item i: inv){
			if (i.getObjectType().equals("Gold")){
				return true;
			}
		}
		return false;
	}
	public int getGoldID(){
		for (Item i: inv){
			if (i.getObjectType().equals("Gold")){
				return i.getItemInvRefID();
			}
		}
		return 0;
	}
	public boolean containsPickaxe(){
		for (Item i: inv){
			if (i instanceof Pickaxe){
				return true;
			}
		}
		return false;
	}
	public static int getInvRefX(int i){
		if (i == 0 || i == 5 || i == 10 || i == 15){
			return x+10;
		}
		if (i == 1 || i == 6 || i == 11 || i == 16){
			return x+50;
		}
		if (i == 2 || i == 7 || i == 12 || i == 17){
			return x+90;
		}
		if (i == 3 || i == 8 || i == 13 || i == 18){
			return x+130;
		}
		if (i == 4 || i == 9 || i == 14 || i == 19){
			return x+170;
		}
		return 0;
	}
	public static int getInvRefY(int i){
		if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4){
			return y+30;
		}
		if (i == 5 || i == 6 || i == 7 || i == 8 || i == 9){
			return y+70;
		}
		if (i == 10 || i == 11 || i == 12 || i == 13 || i == 14){
			return y+110;
		}
		if (i == 15 || i == 16 || i == 17 || i == 18 || i == 19){
			return y+150;
		}
		
		return 0;
	}
	public boolean contains(QuestItem i){
		for (int i1 = 0; i1 < inv.length; i1++){
			if (inv[i1] == i){
				return true;
			}
		}
		return false;
	}
}

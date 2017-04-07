package namless.slickRPG.events;

import namless.slickRPG.PlayLevel;

public class Event {
	private int locationX = 0;
	private int locationY = 0;
	public Event(int x, int y){
		locationX = x;
		locationY = y;
	}
	public void update(){
		
	}
	public boolean playerLocation(){
		if (PlayLevel.player.x() == locationX && PlayLevel.player.y() == locationY){
			return true;
		}else{
			return false;
		}
	}
	public int x(){
		return locationX;
	}
	public int y(){
		return locationY;
	}
}

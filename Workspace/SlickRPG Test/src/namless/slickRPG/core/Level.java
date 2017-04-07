package namless.slickRPG.core;

import namless.slickRPG.events.Button;
import namless.slickRPG.events.Event;
import namless.slickRPG.events.ItemPickup;
import namless.slickRPG.events.Sign;
import namless.slickRPG.events.Switch;
import namless.slickRPG.supers.Enemy;
import namless.slickRPG.supers.EventHandler;
import namless.slickRPG.supers.NPC;
import namless.slickRPG.supers.Tile;
import namless.slickRPG.tiles.BreakTile;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Level {
	private Tile[][] tiles;
	private Image background;
	private int maxX = 0;
	private int maxY = 0;
	//private Music music;
	private Event[] events;
	private EventHandler[] eventHandlers;
	private NPC[] npcs;
	private Enemy[] enemies;
	private ItemPickup[] itemPickups;
	public Level(Tile[][] tiles, Image background, /*Music music,*/ EventHandler[] eventHandlers, NPC[] npcs, Enemy[] enemies, ItemPickup[] itemPickups, Event[] events) {
		this.tiles = tiles;
		for (@SuppressWarnings("unused") Tile[] t2: tiles){
			maxX++;
		}
		System.out.println();
		for (Tile[] t2: tiles){
			for (@SuppressWarnings("unused") Tile t1: t2){
				maxY++;
			}
			break;
		}
		this.background = background;
		//this.music = music;
		this.eventHandlers = eventHandlers;
		this.npcs = npcs;
		this.enemies = enemies;
		this.events = events;
		this.itemPickups = itemPickups;
	}
	public void render(Graphics g){
		if (background != null){
			g.drawImage(background, 0, 0);
		}
		if (tiles != null){
			for (Tile[] t1: tiles){
				for (Tile t2: t1){
					t2.render(g);
				}
			}
		}
		if (eventHandlers != null){
			for (EventHandler ev1: eventHandlers){
				ev1.render(g);
			}
		}
		if (enemies != null){
			for (Enemy e: enemies){
				e.render(g);
			}
		}
		if (itemPickups != null){
			for (ItemPickup i: itemPickups){
				i.render(g);
			}
		}
		if (npcs != null){
			for (NPC n: npcs){
				n.render(g);
			}
		}
	}
	public void update(Input in) throws SlickException{
		if (tiles != null){
			for (Tile[] t2: tiles){
				for (Tile t1: t2){
					if (!(t1 instanceof BreakTile)){
						t1.update();
					}
				}
			}
		}
		if (eventHandlers != null){
			for (EventHandler ev1: eventHandlers){
				if (ev1 instanceof Button){
					ev1.update();
				}
			}
		}
		if (npcs != null){
			for (NPC n: npcs){
				n.update();
			}
		}
		if (in.isKeyPressed(Input.KEY_ENTER)){
			if (tiles != null){
				for (Tile[] t2: tiles){
					for (Tile t1: t2){
						if (t1 instanceof BreakTile){
							t1.update();
						}
					}
				}
			}
			if (eventHandlers != null){
				for (EventHandler ev1: eventHandlers){
					if (ev1 instanceof Switch || ev1 instanceof Sign){
						ev1.update();
					}
				}
			}
			if (npcs != null){
				for (NPC n: npcs){
					n.talkingUpdate();
				}
			}
			if (enemies != null){
				for (Enemy e: enemies){
					e.update();
				}
			}
			if (itemPickups != null){
				for (ItemPickup i: itemPickups){
					i.update();
				}
			}
		}
	}
	public NPC[] getNPCs(){
		return npcs;
	}
	public Tile[][] getTiles(){
		return tiles;
	}
	public void reset() throws SlickException{
		if (eventHandlers != null){
			for (EventHandler ev1: eventHandlers){
				ev1.reset();
			}
		}
		if (npcs != null){
			for (NPC npcc: npcs){
				npcc.reset();
			}
		}
		if (enemies != null){
			for (Enemy ene1: enemies){
				ene1.reset();
			}
		}
	}
	public int getMaxX(){
		return maxX;
	}
	public int getMaxY(){
		return maxY;
	}
	public Event[] getEvents(){
		return events;
	}
	public ItemPickup[] getItemPickups(){
		return itemPickups;
	}
	public void setItemPickups(ItemPickup[] i){
		itemPickups = i;
	}
	public void setEvents(Event[] e){
		events = e;
	}
	public void setEventHandlers(EventHandler[] e){
		eventHandlers = e;
	}
	public void setNPCs(NPC[] n){
		npcs = n;
	}
	public void setEnemies(Enemy[] e){
		enemies = e;
	}
}

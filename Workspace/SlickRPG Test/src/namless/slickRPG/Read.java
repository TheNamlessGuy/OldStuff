package namless.slickRPG;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import namless.slickRPG.Enemies.Zombie;
import namless.slickRPG.NPCs.QuestNPC;
import namless.slickRPG.NPCs.TalkingNPC;
import namless.slickRPG.core.Level;
import namless.slickRPG.events.Button;
import namless.slickRPG.events.Event;
import namless.slickRPG.events.ItemPickup;
import namless.slickRPG.events.Switch;
import namless.slickRPG.items.Gold;
import namless.slickRPG.items.Pickaxe;
import namless.slickRPG.items.Potion;
import namless.slickRPG.items.QuestItem;
import namless.slickRPG.supers.Enemy;
import namless.slickRPG.supers.EventHandler;
import namless.slickRPG.supers.NPC;
import namless.slickRPG.supers.Tile;
import namless.slickRPG.tiles.AirTile;
import namless.slickRPG.tiles.BreakTile;
import namless.slickRPG.tiles.FireTile;
import namless.slickRPG.tiles.HiddenTile;
import namless.slickRPG.tiles.VoidTile;
import namless.slickRPG.tiles.WallTile;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Read {
	public static int fullX = 0;
	public static int fullY = 0;
	public static Level read(File file) throws IOException, SlickException{
		Level level = null;
		ItemPickup[] itemPickups = null;
		NPC[] npcs = null;
		Enemy[] enemies = null;
		Event[] events = null;
		EventHandler[] eventHandlers = null;
		Tile[][] tiles = null;
		BufferedReader br = new BufferedReader(new FileReader(file));
		String s = "";
		int index = 0;
		int x = 0;
		int y = 0;
		boolean playerSpawn;
		boolean enemySpawn;
		while ((s = br.readLine()) != null) {
			index = s.indexOf(':')+1;
			if (s.contains("SIZE X")){
				x = Integer.parseInt(s.substring(index, s.length()));
				fullX = Integer.parseInt(s.substring(index, s.length()));
			}else if (s.contains("SIZE Y")){
				y = Integer.parseInt(s.substring(index, s.length()));
				fullY = Integer.parseInt(s.substring(index, s.length()));
				tiles = new Tile[x][y];
				for (int i = 0; i < x; i++){
					for (int j = 0; j < y; j++){
						tiles[i][j] = new VoidTile();
					}
				}
				for (int i = 0; i < x; i++){
					tiles[i][0] = new WallTile(i, 0, false, false);
				}
				for (int i = 0; i < y; i++){
					tiles[0][i] = new WallTile(0, i, false, false);
				}
				for (int i = 0; i < x; i++){
					tiles[i][11] = new WallTile(i, 11, false, false);
				}
				for (int i = 0; i < y; i++){
					tiles[11][i] = new WallTile(11, i, false, false);
				}
			}else{
				x = 0;
				y = 0;
				if(s.contains("AIR")){
					s = s.substring(index, s.length());
					index = s.indexOf(':')+1;
					x = Integer.parseInt(s.substring(0,index-1));
					s = s.substring(index, s.length());
					index = s.indexOf(':')+1;
					y = Integer.parseInt(s.substring(0, index-1));
					s = s.substring(index, s.length());
					index = s.indexOf(':')+1;
					playerSpawn = Boolean.parseBoolean(s.substring(0, index-1));
					enemySpawn = Boolean.parseBoolean(s.substring(index, s.length()));
					tiles[x][y] = new AirTile(x, y, playerSpawn, enemySpawn);
				}else if (s.contains("FIRE")){
					s = s.substring(index, s.length());
					index = s.indexOf(':')+1;
					x = Integer.parseInt(s.substring(0,index-1));
					s = s.substring(index, s.length());
					index = s.indexOf(':')+1;
					y = Integer.parseInt(s.substring(0, index-1));
					s = s.substring(index, s.length());
					index = s.indexOf(':')+1;
					playerSpawn = Boolean.parseBoolean(s.substring(0, index-1));
					enemySpawn = Boolean.parseBoolean(s.substring(index, s.length()));
					tiles[x][y] = new FireTile(x, y, playerSpawn, enemySpawn);
				}else if (s.contains("HIDDEN")){
					s = s.substring(index, s.length());
					index = s.indexOf(':')+1;
					x = Integer.parseInt(s.substring(0,index-1));
					s = s.substring(index, s.length());
					index = s.indexOf(':')+1;
					y = Integer.parseInt(s.substring(0, index-1));
					s = s.substring(index, s.length());
					index = s.indexOf(':')+1;
					playerSpawn = Boolean.parseBoolean(s.substring(0, index-1));
					enemySpawn = Boolean.parseBoolean(s.substring(index, s.length()));
					tiles[x][y] = new HiddenTile(x, y, playerSpawn, enemySpawn);
				}else if(s.contains("WALL")){
					s = s.substring(index, s.length());
					index = s.indexOf(':')+1;
					x = Integer.parseInt(s.substring(0, index-1));
					s = s.substring(index, s.length());
					index = s.indexOf(':')+1;
					y = Integer.parseInt(s.substring(0, index-1));
					s = s.substring(index, s.length());
					index = s.indexOf(':')+1;
					playerSpawn = Boolean.parseBoolean(s.substring(0, index-1));
					enemySpawn = Boolean.parseBoolean(s.substring(index, s.length()));
					tiles[x][y] = new WallTile(x, y, playerSpawn, enemySpawn);
				}else if(s.contains("BREAK")){
					s = s.substring(index, s.length());
					index = s.indexOf(':')+1;
					x = Integer.parseInt(s.substring(0, index-1));
					s = s.substring(index, s.length());
					index = s.indexOf(':')+1;
					y = Integer.parseInt(s.substring(0, index-1));
					s = s.substring(index, s.length());
					index = s.indexOf(':')+1;
					playerSpawn = Boolean.parseBoolean(s.substring(0, index-1));
					enemySpawn = Boolean.parseBoolean(s.substring(index, s.length()));
					tiles[x][y] = new BreakTile(x, y, playerSpawn, enemySpawn);
				}
			}
		}
		br.close();
		tiles[5][4] = new BreakTile(5, 4, false, false);
		level = new Level(tiles, null,/* null,*/ eventHandlers, npcs, enemies, itemPickups, events);
		events = new Event[1];
		events[0] = new Event(3, 4);
		level.setEvents(events);
		eventHandlers = new EventHandler[2];
		eventHandlers[0] = new Button(1, 3, 0, true, 2, false, false, false, false, level);
		eventHandlers[1] = new Switch(1, 9, 0, false, 0, false, false, false, true, level);
		level.setEventHandlers(eventHandlers);
		itemPickups = new ItemPickup[4];
		itemPickups[0] = new ItemPickup(new Pickaxe(), 1, 1);
		itemPickups[1] = new ItemPickup(new QuestItem(new Image("res/images/player/health/Heart0.png"), "A human heart", "heart"), 1, 10);
		itemPickups[2] = new ItemPickup(new Gold(10), 2, 10);
		itemPickups[3] = new ItemPickup(new Gold(10), 10, 10);
		level.setItemPickups(itemPickups);
		npcs = new NPC[2];
		String[] bobDialogue = {"Hey", "Yo", "Sup"};
		npcs[0] = new TalkingNPC(1, 2, "Bob", bobDialogue, level.getTiles());
		npcs[1] = new QuestNPC(1, 5, level.getTiles(), new Potion(false, false, true), itemPickups[1].getQuestItem());
		level.setNPCs(npcs);
		enemies = new Enemy[1];
		enemies[0] = new Zombie(1, 4, level.getTiles());
		level.setEnemies(enemies);
		return level;
	}
}

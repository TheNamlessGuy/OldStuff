package game;
import core.Enemy;
import variables.*;
public class Spawning{
	public static void spawn(int spawn){
		while (spawn >= 0){ //Spawns enemies depending on input number
			ArrayLists.enemies.add(new Enemy(ArrayLists.enemies.size())); //Creates new enemy
			spawn--; //Removes one from spawn
		}
		if (Numbers.level < 1000){
			Numbers.level += 10; //Adds 10 enemies to the next wave
		}
	}
}
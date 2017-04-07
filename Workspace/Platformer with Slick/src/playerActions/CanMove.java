package playerActions;
import levels.Level1;
import levels.Level2;
import variables.*;
public class CanMove {
	//CAN MOVE DOWN
		public static boolean down(){
			switch(Strings.currentFloor){
			case "Level1":
				return Level1.down();
			case "Level2":
				return Level2.down();
			default:
				return false;
			}
		}
		//CAN MOVE UP
		public static boolean up(){
			switch(Strings.currentFloor){
			case "Level1":
				return Level1.up();
			case "Level2":
				return Level2.up();
			default:
				return false;
			}
		}
		//CAN MOVE LEFT
		public static boolean left(){
			switch(Strings.currentFloor){
			case "Level1":
				return Level1.left();
			case "Level2":
				return Level2.left();
			default:
				return false;
			}
		}
		//CAN MOVE RIGHT
		public static boolean right(){
			switch(Strings.currentFloor){
			case "Level1":
				return Level1.right();
			case "Level2":
				return Level2.right();
			default:
				return false;
			}
		}
}
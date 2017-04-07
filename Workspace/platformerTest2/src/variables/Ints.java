package variables;
public class Ints {
	public static int screenSizeX = 40;
	public static int screenSizeY = 60;
	public static int jumpHeight = 4;
	public static int timesKilled = 0;
	public static int[] startingLocation = {(screenSizeX/2)-1,0};
	public static int[] location = {(screenSizeX/2)-1,0};
	
	public static void getLocation(int[] location1){
		location = location1;
	}
	public static void getStartingLocation(int[] startingLocation1){
		startingLocation = startingLocation1;
	}
}

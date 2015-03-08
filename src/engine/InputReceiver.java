package engine;

public interface InputReceiver {
	
	public static int LEFT_KEY = 37;
	
	public static int UP_KEY = 38;
	
	public static int RIGHT_KEY = 39;
	
	public static int DOWN_KEY = 40;
	
	/**
	 * this key should halt the movement of the snake. 
	 * We can also think about this key as the pause key.
	 */
	public static int NO_DIRECTION = 80; 
	
	public void receiveInput(int inputCode);
}

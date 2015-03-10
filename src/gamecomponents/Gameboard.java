package gamecomponents;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import common.Point;
import engine.VisualElement;

public class Gameboard {
	
	public static final int GAME_RUNNING = 0;
	
	public static final int GAME_LOST = -1;
	
	public static final int GAME_WON = 1;
	
	public static final int WIN_AMOUNT = 10;
	
	private List<GameboardElement> visibles = new ArrayList<>();
	
	private Player player;
	
	private GameboardBorder border;
	
	private FoodTile food;
	
	private int gameState = GAME_RUNNING;
	
	public static double TILE_SIZE = 0.1;
	
	public Gameboard(Player player){
		populateBoard();
		placePlayer(player);
	}
	
	private void populateBoard(){
		GameboardBorder border = new GameboardBorder();
		this.border = border;
		this.border.initElement();
		this.visibles.add(this.border);
		
		
	}
	
	private void placePlayer(Player player){
		this.player = player;
		this.player.setTileSize(TILE_SIZE);
		this.player.initElement();
		this.visibles.add(player);
		

	}
	
	
	public synchronized void tick(){

		Point point = this.player.move();
		if(point == null){
			return ;
		}
		if(!this.detectLoss(point)){
			this.detectVictory();
		}
		
		if(this.food == null){
			this.food = new FoodTile(this.generateCleanPoint());
			this.food.initElement();
			this.visibles.add(this.food);
		}else{
			if(this.food.detectCollision(point)){
				this.food.increasePlayerTiles(player);
				this.visibles.remove(this.food);
				this.food = null;
			}
		}
	}
	
	private Point generateCleanPoint(){
		Point point = null; 
				
		do{
			point = this.generatePoint();
		}while(this.player.detectCollision(point));
		
		return point;
		
	}
	
	private Point generatePoint(){
		Random rand = new Random();
		int x1 = rand.nextInt(18);
		int y1 = rand.nextInt(18);
		
		double xd1 = x1;
		double yd1 = y1;
		xd1 = xd1 / 10 - 0.8;
		yd1 = yd1 / 10 - 0.8;
		Point point = new Point(xd1,yd1);
		
		return point;
	}
	
	private boolean detectLoss(Point point){
		if(this.player.detectCollision(point)  || this.detectEdgeCollision(point)){
			this.loseGame();
			return true;
		}
		return false;
	}
	
	private boolean detectEdgeCollision(Point point){
		
		return this.border.detectCollision(point);
	}
	
	private void detectVictory(){
		if(this.player.getPlayerSize() >= WIN_AMOUNT){
			this.winGame();
		}
	}
	
	public List<VisualElement> getVisuals(){
		List<VisualElement> visuals = new ArrayList<>();
		for(GameboardElement ve : this.visibles){
			visuals.addAll(ve.getSkin());
		}
		return visuals;
	}
	
	public List<GameboardElement> getVisibles() {
		return visibles;
	}
	

	public void setVisibles(List<GameboardElement> visibles) {
		this.visibles = visibles;
	}
	
	public void winGame(){
		this.gameState = GAME_WON;
	}
	
	public void loseGame(){
		this.gameState = GAME_LOST;
	}
	
	public boolean isGameRunning(){
		if(this.gameState == GAME_RUNNING){
			return true;
		}else{
			return false;
		}
	}
	
	public String getEndGameMessage(){
		switch(this.gameState){
		case GAME_WON:
			return "You have won! HURRAAY";
			
		case GAME_LOST:
			return "You have lost! HAHAHA!";
			
			default:
				return "The game should be running";
		}
	}

	public void resetBoard() {
		player.reset(0,0);
		this.visibles.remove(this.food);
		this.food = null;
		this.gameState = GAME_RUNNING;
		
	}
}

package gamecomponents;

import java.util.ArrayList;
import java.util.List;

import common.Point;

import engine.VisualElement;

public class Gameboard {
	
	public static int GAME_RUNNING = 0;
	
	public static int GAME_LOST = -1;
	
	public static int GAME_WON = 1;
	
	private List<GameboardElement> visibles = new ArrayList<>();
	
	private Player player;
	
	private int gameState = GAME_RUNNING;
	
	public static double TILE_SIZE = 0.1;
	
	public Gameboard(Player player){
		populateBoard();
		placePlayer(player);
	}
	
	private void populateBoard(){
		
	}
	
	private void placePlayer(Player player){
		this.visibles.add(player);
		this.player = player;
		this.player.setMoveStep(TILE_SIZE);
		this.player.initPlayer();
	}
	
	
	public synchronized void tick(){

		Point point = this.player.move();
		if(point == null){
			return ;
		}
		if(!this.detectLoss(point)){
			this.detectVictory();
		}
		
	}
	
	private boolean detectLoss(Point point){
		if(this.player.detectCollision(point)  || this.detectEdgeCollision(point)){
			this.loseGame();
			return true;
		}
		return false;
	}
	
	private boolean detectEdgeCollision(Point point){
		
		return false;
	}
	
	private void detectVictory(){
		if(this.player.getPlayerSize()>=10){
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
}

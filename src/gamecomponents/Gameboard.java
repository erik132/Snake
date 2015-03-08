package gamecomponents;

import java.util.ArrayList;
import java.util.List;

import common.Point;

import engine.VisualElement;

public class Gameboard {
	
	private List<GameboardElement> visibles = new ArrayList<>();
	
	private Player player;
	
	public Gameboard(Player player){
		populateBoard();
		placePlayer(player);
	}
	
	private void populateBoard(){
		
	}
	
	private void placePlayer(Player player){
		this.visibles.add(player);
		this.player = player;
	}
	
	
	public synchronized void tick(){

		Point point = this.player.move();
		if(point == null){
			return ;
		}

		if(this.player.detectCollision(point)){
			this.loseGame();
			return ;
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
		
	}
	
	public void loseGame(){
		
	}
}

package gamecomponents;

import java.util.ArrayList;
import java.util.List;

import engine.VisualElement;

public class Gameboard {
	private List<GameboardElement> visibles = new ArrayList<>();
	
	public Gameboard(Player player){
		populateBoard();
		placePlayer(player);
	}
	
	private void populateBoard(){
		
	}
	
	private void placePlayer(Player player){
		this.visibles.add(player);
	}
	
	public List<VisualElement> getVisuals(){
		List<VisualElement> visuals = new ArrayList<>();
		for(GameboardElement ve : this.visibles){
			visuals.add(ve.getSkin());
		}
		return visuals;
	}
	
	public List<GameboardElement> getVisibles() {
		return visibles;
	}
	

	public void setVisibles(List<GameboardElement> visibles) {
		this.visibles = visibles;
	}
}

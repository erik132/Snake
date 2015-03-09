package gamecomponents;

import java.util.List;

import common.Point;

import engine.VisualElement;
import gamecomponents.skins.FoodTileSkin;

public class FoodTile extends GameboardElement{
	
	
	private double xCord;
	
	private double yCord;
	
	public FoodTile(double x, double y) {
		this.xCord = x;
		this.yCord = y;
	}
	
	public FoodTile(Point point){
		this.xCord = point.getX();
		this.yCord = point.getY();
	}
	

	@Override
	public void initElement() {
		this.skin = new FoodTileSkin(this.xCord, this.yCord, tileSize);
		
	}
	
	public void increasePlayerTiles(Player player){
		player.addSnakeTiles(1);
	}

}

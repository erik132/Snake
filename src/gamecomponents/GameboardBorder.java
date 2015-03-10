package gamecomponents;

import common.Point;
import gamecomponents.skins.GameboardBorderSkin;

public class GameboardBorder extends GameboardElement{
	
	
	public static final double LEFT_EDGE = -1;
	
	public static final double RIGHT_EDGE = 1;
	
	public static final double TOP_EDGE = 1;
	
	public static final double BOTTOM_EDGE = -1;
	
	

	@Override
	public void initElement() {
		this.skin = new GameboardBorderSkin(-1, 1, this.tileSize);
		
	}
	
	@Override
	public boolean detectCollision(Point point){
		if(this.compareDouble(point.getX(), this.getLeftEdge()) || 
				this.compareDouble(point.getX(), this.getRightEdge()) || 
				this.compareDouble(point.getY(), this.getTopEdge()) || 
				this.compareDouble(point.getY(), this.getBottomEdge()) ){
			return true;
		}
		return false;
	}
	
	public double getLeftEdge(){
		return this.LEFT_EDGE;
	}
	
	public double getRightEdge(){
		return this.RIGHT_EDGE - this.tileSize;
	}
	
	public double getTopEdge(){
		return this.TOP_EDGE;
	}
	
	public double getBottomEdge(){
		return this.BOTTOM_EDGE + this.tileSize;
	}

}

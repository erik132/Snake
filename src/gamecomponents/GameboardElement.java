package gamecomponents;

import java.util.ArrayList;
import java.util.List;

import common.MathLib;
import common.Point;
import engine.VisualElement;

public abstract class GameboardElement extends MathLib{
	
	protected double tileSize = 0.1;
	
	protected VisualElement skin;
	
	public List<VisualElement> getSkin() {
		List<VisualElement> skin = new ArrayList<VisualElement>();
		skin.add(this.skin);
		return skin;
	}
	
	public abstract void initElement();
	
	public void setTileSize(double size){
		this.tileSize = size;
	}
	
	
	public boolean detectCollision(Point point){
		List <VisualElement> skins = this.getSkin();
		for(VisualElement element: skins){
			if(element.equals(point)){
				return true;
			}
		}
		return false;
	}
	
	
}

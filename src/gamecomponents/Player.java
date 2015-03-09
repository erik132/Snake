package gamecomponents;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import common.ArrayListQueue;
import common.Point;
import engine.InputReceiver;
import engine.VisualElement;

public class Player implements GameboardElement, InputReceiver{
	
	private ArrayListQueue<VisualElement> skins = new ArrayListQueue<>();
	
	
	private int[] allowedKeys = {UP_KEY, DOWN_KEY, LEFT_KEY, RIGHT_KEY, NO_DIRECTION};
	
	private int direction;
	
	private double moveStep = 0.1;
	
	public Player(){
		this.direction = NO_DIRECTION;
		
	}
	
	public void initPlayer(){
		this.skins.add(new PlayerSkin(0,0,this.moveStep));
		this.skins.add(new PlayerSkin(0,0,this.moveStep));
		this.skins.add(new PlayerSkin(0,0,this.moveStep));
		this.skins.add(new PlayerSkin(0,0,this.moveStep));
		this.skins.add(new PlayerSkin(0,0,this.moveStep));
		this.skins.add(new PlayerSkin(0,0,this.moveStep));
		this.skins.add(new PlayerSkin(0,0,this.moveStep));
	}

	public List<VisualElement> getSkin() {
		return this.extractVisualList();
	}

	public boolean detectCollision(Point point){
		List<VisualElement> skins = this.extractVisualList();
		for(VisualElement skin: skins){
			if(skin.equals(point)){
				return true;
			}
		}
		return false;
	}
	
	public Point move(){
		VisualElement snakeSquare = null;
		Point point = null;
		
		if(this.skins.isEmpty() == true){
			return null;
		}
		if( this.direction == NO_DIRECTION){
			return null;
		}else{
			point = this.skins.peekLast().getPoint();
		}
		
		
		switch(this.direction){
		case UP_KEY:
			point.setY(point.getY() + this.moveStep);
			break;
		case DOWN_KEY:
			point.setY(point.getY() - this.moveStep);
			break;
		case LEFT_KEY:
			point.setX(point.getX() - this.moveStep);
			break;
		case RIGHT_KEY:
			point.setX(point.getX() + this.moveStep);
			break;
		}
		snakeSquare = this.skins.poll();
		snakeSquare.setPoint(point);
		this.skins.add(snakeSquare);
		return point;
	}
	
	private List<VisualElement> extractVisualList(){
		List<VisualElement> skins = new ArrayList<>();
		Iterator<VisualElement> skinner = this.skins.iterator();
		while(skinner.hasNext()){
			skins.add(skinner.next());
		}
		return skins;
	}
	
	@Override
	public void receiveInput(int inputCode) {
		for(int key: this.allowedKeys){
			if(inputCode == key){
				this.direction = inputCode;
			}
		}
		
	}
	
	public void setMoveStep(double step){
		this.moveStep = step;
	}
	
	public int getPlayerSize(){
		return this.skins.size();
	}
}

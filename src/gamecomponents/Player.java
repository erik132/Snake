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
import gamecomponents.skins.PlayerSkin;

public class Player extends GameboardElement implements InputReceiver{
	
	private ArrayListQueue<VisualElement> skins = new ArrayListQueue<>();
	
	
	private int[] allowedKeys = {UP_KEY, DOWN_KEY, LEFT_KEY, RIGHT_KEY, NO_DIRECTION};
	
	private int direction;
	
	
	public Player(){
		this.direction = NO_DIRECTION;
		
	}
	
	@Override
	public void initElement(){
		this.skins.add(new PlayerSkin(0,0,this.tileSize));

	}
	
	@Override
	public List<VisualElement> getSkin() {
		return this.extractVisualList();
	}
	
	@Override
	public boolean detectCollision(Point point){
		int i = 0;
		
		List<VisualElement> skins = this.extractVisualList();
		
		for(; i<(skins.size()-1); i++){
			if(skins.get(i).equals(point)){
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
			point.setY(point.getY() + this.tileSize);
			break;
		case DOWN_KEY:
			point.setY(point.getY() - this.tileSize);
			break;
		case LEFT_KEY:
			point.setX(point.getX() - this.tileSize);
			break;
		case RIGHT_KEY:
			point.setX(point.getX() + this.tileSize);
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
	
	public void addSnakeTiles(int nrOfTiles){
		Point point = this.skins.peekFirst().getPoint();
		for(int i = 0; i< nrOfTiles; i++){
			this.skins.addFront(new PlayerSkin(point.getX(), point.getY(),this.tileSize));
		}
	}
	
	
	public int getPlayerSize(){
		return this.skins.size();
	}
	
	public void reset(int x, int y){
		this.direction = NO_DIRECTION;
		this.skins = new ArrayListQueue<>();
		this.skins.add(new PlayerSkin(x, y, this.tileSize));
		
	}
}

package gamecomponents;

import engine.InputReceiver;
import engine.VisualElement;

public class Player implements GameboardElement, InputReceiver{
	
	private VisualElement skin;
	
	private int[] allowedKeys = {UP_KEY, DOWN_KEY, LEFT_KEY, RIGHT_KEY, NO_DIRECTION};
	
	private int direction;
	
	public Player(VisualElement skin){
		this.setSkin(skin);
		this.direction = NO_DIRECTION;
		
	}

	public VisualElement getSkin() {
		return skin;
	}

	public void setSkin(VisualElement skin) {
		this.skin = skin;
	}
	
	public void move(){
		
		switch(this.direction){
		case UP_KEY:
			break;
		case DOWN_KEY:
			break;
		case LEFT_KEY:
			break;
		case RIGHT_KEY:
			break;
		}
	}

	@Override
	public void receiveInput(int inputCode) {
		
		for(int key: this.allowedKeys){
			if(inputCode == key){
				this.direction = inputCode;
			}
		}
		
	}
}

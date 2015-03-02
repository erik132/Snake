package gamecomponents;

import engine.VisualElement;

public class Player implements VisibleElement{
	
	private VisualElement skin;
	
	public Player(VisualElement skin){
		this.setSkin(skin);
	}

	public VisualElement getSkin() {
		return skin;
	}

	public void setSkin(VisualElement skin) {
		this.skin = skin;
	}
}

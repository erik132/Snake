package gamecomponents;

import javax.media.opengl.GL2;

import engine.VisualElement;

public class PlayerSkin extends VisualElement{

	public PlayerSkin(double x, double y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void drawElement(GL2 gl) {
		this.drawSquare(gl, 0.5);
		
	}

}

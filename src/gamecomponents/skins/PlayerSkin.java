package gamecomponents.skins;

import javax.media.opengl.GL2;

import engine.VisualElement;

public class PlayerSkin extends VisualElement{

	public PlayerSkin(double x, double y, double tileSize) {
		super(x, y, tileSize);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void drawElement(GL2 gl) {
		gl.glColor3f(1, 1, 0);
		this.drawSquare(gl, 0.1);
		
	}

}

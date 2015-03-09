package gamecomponents.skins;

import javax.media.opengl.GL2;

import engine.VisualElement;
import gamecomponents.Player;

public class FoodTileSkin extends VisualElement{

	public FoodTileSkin(double x, double y, double tileSize) {
		super(x, y, tileSize);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void drawElement(GL2 gl) {
		gl.glColor3f(0, 1, 0);
		this.drawSquare(gl, this.tileSize);
	}
	


}

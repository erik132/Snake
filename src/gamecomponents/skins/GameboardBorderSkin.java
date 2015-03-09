package gamecomponents.skins;

import javax.media.opengl.GL2;

import engine.VisualElement;

public class GameboardBorderSkin extends VisualElement{
	
	public static int GAMEBOARD_SIZE = 20;

	public GameboardBorderSkin(double x, double y, double tileSize) {
		super(x, y, tileSize);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void drawElement(GL2 gl) {
		gl.glColor3f(1, 0, 0);
		
		this.drawRectangle(gl, this.getxCord(), this.getyCord(), this.getxCord() + this.tileSize * GAMEBOARD_SIZE, this.getyCord() - this.tileSize);
		this.drawRectangle(gl, this.getxCord(), this.getyCord(), this.getxCord() + this.tileSize, this.getyCord() - this.tileSize * GAMEBOARD_SIZE);
		
		this.drawRectangle(gl, this.getxCord(), this.getyCord() - this.tileSize * (GAMEBOARD_SIZE - 1), this.getxCord() + this.tileSize * GAMEBOARD_SIZE, this.getyCord() - this.tileSize* GAMEBOARD_SIZE);
		this.drawRectangle(gl, this.getxCord() + this.tileSize * (GAMEBOARD_SIZE - 1), this.getyCord(), this.getxCord() + this.tileSize * GAMEBOARD_SIZE, this.getyCord() - this.tileSize* GAMEBOARD_SIZE);
	}

}

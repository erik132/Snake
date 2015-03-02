package engine;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;

public abstract class VisualElement {
	
	private double xCord;
	
	private double yCord;
	
	public VisualElement(double x, double y){
		this.xCord = x;
		this.yCord = y;
	}
	
	abstract public void drawElement(GL2 gl);
	
	
	protected void drawSquare(GL2 gl,double size){
        gl.glBegin(GL2.GL_QUADS);
        
        gl.glColor3f(1, 0, 0);
        gl.glVertex2d(size, -size);
        gl.glColor3f(0, 1, 0);
        gl.glVertex2d(size, 0);
        gl.glColor3f(0, 0, 1);
        gl.glVertex2d(0, 0);
        gl.glColor3f(1, 1, 0);
        gl.glVertex2d(0, -size);
        
        gl.glEnd();
	}

	public double getxCord() {
		return xCord;
	}

	public void setxCord(double xCord) {
		this.xCord = xCord;
	}

	public double getyCord() {
		return yCord;
	}

	public void setyCord(double yCord) {
		this.yCord = yCord;
	}
}

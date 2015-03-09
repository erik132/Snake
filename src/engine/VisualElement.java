package engine;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;

import common.Point;

public abstract class VisualElement {
	
	private double xCord;
	
	private double yCord;
	
	protected double tileSize;
	
	public VisualElement(double x, double y, double tileSize){
		this.xCord = x;
		this.yCord = y;
		this.tileSize = tileSize;
	}
	
	abstract public void drawElement(GL2 gl);
	
	
	protected void drawSquare(GL2 gl,double size){
        gl.glBegin(GL2.GL_QUADS);
        
        gl.glColor3f(1, 0, 0);
        gl.glVertex2d(this.xCord + size, this.yCord - size);
        gl.glColor3f(0, 1, 0);
        gl.glVertex2d(this.xCord + size, this.yCord);
        gl.glColor3f(0, 0, 1);
        gl.glVertex2d(this.xCord, this.yCord);
        gl.glColor3f(1, 1, 0);
        gl.glVertex2d(this.xCord, this.yCord - size);
        
        gl.glEnd();
	}
	
	
	public boolean equals(Point point){
		if(point.getX() == this.xCord && point.getY() == this.getyCord()){
			return true;
		}else{
			return false;
		}
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof VisualElement){
			VisualElement element = (VisualElement) obj;
			if(element.getxCord() == this.xCord && element.getyCord() == this.getyCord()){
				return true;
			}
		}
		return false;
	}
	
	public void setPoint(Point point){
		this.xCord = point.getX();
		this.yCord = point.getY();
	}
	
	public Point getPoint(){
		return new Point(this.xCord,this.yCord);
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
	
	public void setTileSize(double size){
		this.tileSize = size;
	}
}

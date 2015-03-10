package engine;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;

import common.MathLib;
import common.Point;

public abstract class VisualElement extends MathLib{
	
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
        
        gl.glVertex2d(this.xCord + size, this.yCord - size);
        gl.glVertex2d(this.xCord + size, this.yCord);
        gl.glVertex2d(this.xCord, this.yCord);
        gl.glVertex2d(this.xCord, this.yCord - size);
        
        gl.glEnd();
	}
	
	protected void drawRectangle(GL2 gl,double x1, double y1, double x2, double y2){
		
		gl.glBegin(GL2.GL_QUADS);
		
		gl.glVertex2d(x1, y1);
		gl.glVertex2d(x2, y1);
		gl.glVertex2d(x2, y2);
		gl.glVertex2d(x1, y2);
		
		gl.glEnd();
	}
	
	
	public boolean equals(Point point){
		if(this.compareDouble(point.getX(), this.xCord) && this.compareDouble(point.getY(), this.getyCord())){
			return true;
		}else{
			return false;
		}
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof VisualElement){
			VisualElement element = (VisualElement) obj;
			if(this.compareDouble(element.getxCord(), this.xCord) && this.compareDouble(element.getyCord(), this.getyCord())){
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

package engine;

import java.util.ArrayList;
import java.util.List;

import gamecomponents.Gameboard;
import gamecomponents.VisibleElement;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;

public class GameEngine implements GLEventListener{
	
	private Gameboard gameboard;
	
	private VisualElementDrawer drawer;
	
	
	
	public GameEngine(Gameboard gameboard){
		this.gameboard = gameboard;
		this.drawer = new VisualElementDrawer();
	}
	
	@Override
	public void init(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void display(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
		this.drawVisuals(this.gameboard.getVisuals(),gl);
		
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width,
			int height) {
		// TODO Auto-generated method stub
		
	}
	
	private void drawVisuals(List<VisualElement> elements, GL2 gl){
		for(VisualElement element : elements){
			element.drawElement(gl);
		}
	}

}

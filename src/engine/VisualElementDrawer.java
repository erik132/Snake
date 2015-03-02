package engine;

import java.util.ArrayList;
import java.util.List;

import javax.media.opengl.GL2;

public class VisualElementDrawer {
	
	private List<VisualElement> elements = new ArrayList<>();
	
	public void drawAllElements(GL2 gl){
		for(VisualElement element : this.elements){
			element.drawElement(gl);
		}
	}
	
	public void addElement(VisualElement element){
		this.elements.add(element);
	}
	
	public void removeElement(VisualElement element){
		this.elements.remove(element);
	}
}

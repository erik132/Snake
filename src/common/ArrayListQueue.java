package common;

import java.util.ArrayList;
import java.util.List;



public class ArrayListQueue<Type> extends ArrayList<Type>{

	
	public Type poll(){
		return super.remove(0);
	}
	
	public void addFront(Type element){
		super.add(0, element);
	}
	
	public Type getLast(){
		return super.remove(super.size()-1);
	}
	
	public Type peekLast(){
		return super.get(super.size()-1);
	}
	
	public Type peekFirst(){
		return super.get(0);
	}

	
}

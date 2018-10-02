//Tian Brown, 111597217

import java.util.*;
@SuppressWarnings("serial")
public class GenericStackExtendsArrayList<E> extends ArrayList<E> {
	
	public int getSize () {
		return size();
	}
	
	public boolean isEmpty () {
		return super.isEmpty();
	}
	
	public Object pop () {
		Object obj = get(getSize() - 1);
		remove(getSize() - 1);
		return obj;
	}
	
	public Object push (E obj) {
		add(obj);
		return obj;
	}
	
	public Object peek () {
		return get(getSize() - 1);
	}

	public int search (Object obj) {
		return indexOf(obj);
	}
	
	public String toString () {
		return "Stack: " + super.toString();
	}




	

	
}

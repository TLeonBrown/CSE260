//Tian Brown 111597217

import java.util.*;

public class GenericHeap7<E>  {
	private ArrayList<E> list = new ArrayList<E>();

	//default heap
	public GenericHeap7 () {}
	
	//creates a new generic heap with Comparator
	public GenericHeap7 (E [] objects, Comparator <? super E> comparator) {
		for (int i = 0; i < objects.length; i++) {
			add(objects[i], comparator);
		}
	}
	//add a new object to the heap, automatically sets it in the right position
	public void add (E newObject, Comparator <? super E> comp) {
		list.add(newObject);
		int currentIndex = list.size() - 1;
		
		while (currentIndex > 0) {
			int parentIndex = (currentIndex - 1)/2;
			if (comp.compare(list.get(currentIndex), list.get(parentIndex)) > 0) {
				E temp = list.get(currentIndex);
				list.set(currentIndex, list.get(parentIndex));
				list.set(parentIndex, temp);
			}
			else break;
			currentIndex = parentIndex;
		}
	}
	//remove root from the heap
	public E remove (Comparator <? super E> comp) {
		if(list.size() == 0) { return null;}
		
		E removedObject = list.get(0);
		list.set(0, list.get(list.size() - 1));
		list.remove(list.size() - 1);
		
		int currentIndex = 0;
		while (currentIndex < list.size()) {
			int leftChildIndex = 2 * currentIndex + 1;
			int rightChildIndex = 2 * currentIndex + 2;
			
			if (leftChildIndex >= list.size()) break;
			int maxIndex = leftChildIndex;
			if (rightChildIndex < list.size()) {
				if (comp.compare(list.get(maxIndex), list.get(rightChildIndex)) < 0) {
					maxIndex = rightChildIndex;
				}
			}
			
			if (comp.compare(list.get(currentIndex), list.get(maxIndex)) < 0) {
				E temp = list.get(maxIndex);
				list.set(maxIndex, list.get(currentIndex));
				list.set(currentIndex, temp);
				currentIndex = maxIndex;
			}
			else
				break;
		}
		return removedObject;
	}
	
	public int getSize () {
		return list.size();
	}


}

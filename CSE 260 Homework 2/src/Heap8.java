import java.util.ArrayList;
//Tian Brown, 111597217

//Helper class for GenericHeapSort4
//Also contains Problem 8 (clone and equals methods in Heap)

public class Heap8<E extends Comparable<E>> {
	public ArrayList<E> list = new ArrayList<E>();

	//defualt heap constructor
	public Heap8 () {}
	
	//create heap from a list of objects
	public Heap8 (E [] objects) {
		for (int i = 0; i < objects.length; i++) {
			add(objects[i]);
		}
	}
	//add object to heap
	public void add (E newObject) {
		list.add(newObject);
		int currentIndex = list.size() - 1;
		while (currentIndex > 0) {
			int parentIndex = (currentIndex - 1)/2;
			if (list.get(currentIndex).compareTo(list.get(parentIndex)) > 0) {
				E temp = list.get(currentIndex);
				list.set(currentIndex, list.get(parentIndex));
				list.set(parentIndex, temp);
			}
			else break;
			currentIndex = parentIndex;
		}
	}
	//remove root from the heap
	public E remove () {
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
				if (list.get(maxIndex).compareTo(list.get(rightChildIndex)) < 0) {
					maxIndex = rightChildIndex;
				}
			}
			
			if (list.get(currentIndex).compareTo(list.get(maxIndex)) < 0) {
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
	
	//clone method (QUESTION #8)
	public ArrayList<E> clone () {
		ArrayList<E> list2 = new ArrayList<E>();
		for (int i = 0; i < this.getSize(); i++) {
			list2.add(this.list.get(i));
		}
		return list2;		
	}
	
	//equals method (QUESTION #8)
	public boolean equals (Heap8<E> list2) {
		if (list2.getSize() != this.getSize())
			return false;
		boolean allElemsTheSame = true;
		for (int i = 0; i < this.getSize(); i++) {
			if (!list2.list.get(i).equals(this.list.get(i)))
					allElemsTheSame = false;
		}
		return allElemsTheSame;
	}
	
	public static void main (String [] args) {
		Integer [] l = {1, 3, 5, 7, 9, 2, 4, 6, 8, 10};
		
		@SuppressWarnings("unchecked")
		Heap8<Integer> heap1 = new Heap8<Integer>(l);
		ArrayList<Integer> heap2 = heap1.clone();
		
		for (int i = 0; i < heap2.size(); i++) 
			System.out.print(heap2.get(i) + " ");
		System.out.println();	
		
		if (heap1.equals(heap2)) {
			System.out.println("they are the same");
		}
	}
	
	
}

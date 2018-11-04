//Tian Brown, 1115972171
//Since the heap in the slides is a MIN-heap, this is an implementation of a MAX-heap

import java.util.*;

public class MaxHeap6<E extends Comparable<E>> {
	private ArrayList<E> list = new ArrayList<E>();

	//default max-heap constructor
	public MaxHeap6 () {
		
	}
	
	//create a max-heap from a list of objects of generic type
	public MaxHeap6 (E [] objects) {
		for (int i = 0; i < objects.length; i++) {
			add(objects[i]);
		}
	}
	
	//add new object of generic type to the max-heap
	public void add (E newObject) {
		list.add(newObject);
		int currentIndex = list.size() - 1;
		while (currentIndex > 0) {
			int parentIndex = (currentIndex - 1)/2;
			if (list.get(currentIndex).compareTo(list.get(parentIndex)) < /*original: >*/ 0) {
				E temp = list.get(currentIndex);
				list.set(currentIndex, list.get(parentIndex));
				list.set(parentIndex, temp);
			}
			else break;
			currentIndex = parentIndex;
		}
	}
	//remove root (aka smallest value) from the max-heap
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
				if (list.get(maxIndex).compareTo(list.get(rightChildIndex)) > /*original: <*/ 0) {
					maxIndex = rightChildIndex;
				}	}
			
			if (list.get(currentIndex).compareTo(list.get(maxIndex)) > /*original: <*/ 0) {
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
	
	
	//get size of the max-heap as an int
	public int getSize () {
		return list.size();
	}
	
	//Heap Sort, with the max-heap
	public static <E extends Comparable<E>> void maxHeapSort(E [] list) {
		MaxHeap6<E> heap = new MaxHeap6<E>();
		for (int i = list.length-1; i >= 0; i--) {
			heap.add(list[i]);
		}
		
		for (int i = list.length-1; i >= 0; i--) {
			list[i] = heap.remove();
		}
	}
	
	
	public static void main (String [] args) {
		Integer [] list = {1, 3, 5, 7, 9, 2, 4, 6, 8, 8, 8, 8, 10};
		
		maxHeapSort(list);
		
		System.out.println("List, sorted with MaxHeapSort: ");
		for (Integer i : list) {
			System.out.print(i + " ");
		}
		
		
	}
}

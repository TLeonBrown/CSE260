//Tian Brown, 111597217
//Heap Sort complexity: O(n log n).

import java.util.*;
public class GenericHeapSort4 {
	
	public GenericHeapSort4 () {
		
	}
	
	
	public <E extends Comparable<E>> void heapSort(E[] list) {
		Heap8<E> heap = new Heap8<E>();
		for (int i = 0; i < list.length; i++) {
			heap.add(list[i]);
		}
		
		for (int i = list.length - 1; i >= 0; i--) {
			list[i] = heap.remove();
		}
	}

	public <E> void heapSort2(E[] list, Comparator<? super E> comparator) {
		PriorityQueue<E> q = new PriorityQueue<E>();
		for (int i = 0; i < list.length; i++) {
			q.add(list[i]);
		}
		
		for (int i = 0; i <list.length; i++) {
			list[i] = q.remove();
		}
	}

//main method
	public static void main(String[] args) {
		GenericHeapSort4 h = new GenericHeapSort4();
		Integer [] l1 = {8, 7, 6, 5, 4, 2, 123, 3, 3, 3, 3, 3, 3, 1};
		Double [] l2 = {1.2, 1.3, 1.4, 1.2, 1.2, 1.2, 0.1};
		h.heapSort(l1);
		h.heapSort2(l2, Comparator.naturalOrder());
		
		for (int i = 0; i < l1.length; i++) {
			System.out.print(l1[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < l2.length; i++) {
			System.out.print(l2[i] + " ");
		}
	}

	
	
	
}

//Tian Brown, 111597217

//Bubble sort time complexity: O(n^2)
import java.util.Comparator;

public class GenericBubbleSort1 {
	
	
	public GenericBubbleSort1 () {
		
	}
	
	public <E extends Comparable<E>> void bubbleSort(E[] list) {
		int n = list.length;
		E temp;
		
		for (int i = 0; i < list.length; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (list[j-1].compareTo(list[j]) > 0) {
					//swap
					temp = list[j-1];
					list[j-1] = list[j];
					list[j] = temp;
				}
			}
		}
	}
	
	public <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
		int n = list.length;
		E temp;
		
		for (int i = 0; i < list.length; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (comparator.compare(list[j-1], list[j]) > 0) {
					temp = list[j-1];
					list[j-1] = list[j];
					list[j] = temp;
				}
			}
	}
}
	public static void main (String [] args) {
		GenericBubbleSort1 b = new GenericBubbleSort1();
		Integer [] list = {8, 7, 6, 5, 4, 3, 2, 1};
		Double [] list2 = {8.8, 7.7, 6.6, 5.5, 4.4, 3.3, 2.2, 1.1};
		b.bubbleSort(list);
		b.bubbleSort(list2, Comparator.naturalOrder());

		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < list.length; i++) {
			System.out.print(list2[i] + " ");
		}
	}
	
	
	
	
}

//Tian Brown, 111597217
//Quick Sort Time (worst case): O(n^2)
import java.util.*;
public class GenericQuickSort3 {
	
	public GenericQuickSort3 () {
		
	}
	//first way
	public <E extends Comparable<E>> void quickSort(E[] list) {
		quickSort(list, 0, list.length-1);
	}	
	public static <E extends Comparable<E>> void quickSort(E [] list, int first, int last) {
		if (last > first) {
			int pivotIndex = partition(list, first, last);
			quickSort(list, first, pivotIndex - 1);
			quickSort(list, pivotIndex+1, last);
		}
	}	
	public static <E extends Comparable<E>> int partition(E [] list, int first, int last) {
		E pivot = list[first];
		int low = first+1;
		int high = last;
		
		while (high > low) {
			while (low <= high && list[low].compareTo(pivot) <= 0) {low++;}
			while (low <= high && list[high].compareTo(pivot) > 0) { high--; }
			if (high > low) {
				E temp = list[high];
				list[high] = list[low];
				list[low] = temp;
			}
		}
		
		while (high > first && list[high].compareTo(pivot) >= 0) {
			high--;
		}
		
		if (pivot.compareTo(list[high]) > 0) {
			list[first] = list[high];
			list[high] = pivot;
			return high;
		}
		else
			return first;
	}

	
	
	//second way
	public <E> void quickSort(E[] list, Comparator<? super E> comparator) {
		quickSort(list, 0, list.length-1, comparator);
	}
	public static <E> void quickSort(E [] list, int first, int last, Comparator<? super E> comparator) {
		if (last > first) {
			int pivotIndex = partition(list, first, last, comparator);
			quickSort(list, first, pivotIndex - 1, comparator);
			quickSort(list, pivotIndex+1, last, comparator);
		}
	}	
	public static <E> int partition(E [] list, int first, int last, Comparator<? super E> comp) {
		E pivot = list[first];
		int low = first+1;
		int high = last;
		
		while (high > low) {
			while (low <= high && comp.compare(list[low], pivot) <= 0) {low++;}
			while (low <= high && comp.compare(list[high], pivot) > 0) { high--; }
			if (high > low) {
				E temp = list[high];
				list[high] = list[low];
				list[low] = temp;
			}
		}
		
		while (high > first && comp.compare(list[high], pivot) >= 0) {
			high--;
		}
		
		if (comp.compare(pivot, list[high]) > 0) {
			list[first] = list[high];
			list[high] = pivot;
			return high;
		}
		else
			return first;
	}

	public static void main(String[] args) {
		GenericQuickSort3 q = new GenericQuickSort3();
		Integer [] list = {12, 13, 14, 15, 11, 9, 10, 8, 7, 6, 16, 17, 19, 18, 21, 20, 5, 5, 5, 4, 3, 2, 1};
		Double [] list2 = {8.8, 7.7, 2.2, 1.1};
		q.quickSort(list);
		q.quickSort(list2, Comparator.naturalOrder());

		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < list2.length; i++) {
			System.out.print(list2[i] + " ");
		}
	}

}

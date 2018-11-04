//Tian Brown, 111597217

import java.util.Stack;

public class NonRecursiveQuickSort11 {
	
	public static void quickSort(Integer [] list) {
		int first = 0;
		int last = list.length-1;
		quickSort(list, first, last);
	}
	
	public static void quickSort(Integer [] list, int first, int last) {
		
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(first); stack.push(last);
		
		while (stack.size() != 0) {
			int end = stack.pop();
			int start = stack.pop();
			if (end - start >= 2)
				break;
			
			
			int pivotIndex = partition(list, first, last);
			
			stack.push(pivotIndex + 1);
			stack.push(end);
			stack.push(start);
			stack.push(pivotIndex);
		}
		
	}
	
	public static int partition(Integer [] list, int first, int last) {
		int pivot = list[first];
		int low = first;
		int high = last - 2;
		
		while (high > low) {
			while (low <= high && list[low].compareTo(pivot) <= 0) {low++;}
			while (low <= high && list[high].compareTo(pivot) > 0) { high--; }
			if (high > low) {
				int temp = list[high];
				list[high] = list[low];
				list[low] = temp;
			}
		}
		
		while (high > first && list[high].compareTo(pivot) >= 0) {
			high--;
		}
		
		if (pivot - (list[high]) > 0) {
			list[first] = list[high];
			list[high] = pivot;
			return high;
		}
		else
			return first;
	}

	public static void main(String[] args) {
		Integer [] list = {12, 13, 14, 15, 11, 9, 10, 8, 7, 6, 16, 17, 19, 18, 21, 20, 5, 5, 5, 4, 3, 2, 1};
		quickSort(list);

		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
		

	}

}

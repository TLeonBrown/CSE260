//Tian Brown, 111597217
//Merge sort time complexity: O(n log n)
import java.lang.reflect.Array;
import java.util.Comparator;

public class GenericMergeSort2 {
	
	public GenericMergeSort2 () {
		
	}
	
	//mergeSort with Comparable
	@SuppressWarnings("unchecked")
	public <E extends Comparable<E>> void mergeSort(E[] list) {
		if (list.length > 1) {
			E[] leftHalf = (E[]) Array.newInstance(list[0].getClass(), list.length/2);
		//	E[] leftHalf = (E[]) Array.newInstance(list.getClass().getComponentType(), list.length/2);
			int secondHalfLength = list.length - list.length/2;
			E[] rightHalf = (E[]) Array.newInstance(list[0].getClass(), secondHalfLength);
		//	E[] rightHalf = (E[]) Array.newInstance(list.getClass().getComponentType(), secondHalfLength);
			
			System.arraycopy(list, 0, leftHalf, 0, list.length/2);
	        System.arraycopy(list, list.length/2, rightHalf, 0, secondHalfLength);
	        
	        mergeSort(leftHalf);
	        mergeSort(rightHalf);
	        
	        merge1(list, leftHalf, rightHalf);   
		}
	}
	
	//mergeSort with Comparator
	@SuppressWarnings("unchecked")
	public <E> void mergeSort(E[] list, Comparator<? super E> comparator) {
		if (list.length > 1) {
			E[] leftHalf = (E[]) Array.newInstance(list.getClass().getComponentType(), list.length/2);
			int secondHalfLength = list.length - list.length/2;
			E[] rightHalf = (E[]) Array.newInstance(list.getClass().getComponentType(), secondHalfLength);
			
			System.arraycopy(list, 0, leftHalf, 0, list.length/2);
	        System.arraycopy(list, list.length/2, rightHalf, 0, secondHalfLength);
	        
	        mergeSort(leftHalf, comparator);
	        mergeSort(rightHalf, comparator);
	        
	        merge2(list, leftHalf, rightHalf, comparator);   
		}
	}
	
	
	
	
	
	//HELPER METHODS
	
	//helper method 1 (with Comparable)
	public static <E extends Comparable<E>>void merge1 (E [] temp, E [] leftHalf, E [] rightHalf) {
		int current1 = 0; int current2 = 0; int current3 = 0;
		
		while(current1 < leftHalf.length && current2 < rightHalf.length) {
			if (leftHalf[current1].compareTo(rightHalf[current2]) < 0) {
				temp[current3++] = leftHalf[current1++];
			}
			else 
				temp[current3++] = rightHalf[current2++];
		}
		
		while (current1 < leftHalf.length) {
			temp[current3++] = leftHalf[current1++];
		}
		while (current2 < rightHalf.length) {
			temp[current3++] = 
					rightHalf[current2++];
		}	
	}
	
	
	//helper method 2 (with comparator)
	public static <E> void merge2 (E[] temp, E[] leftHalf, E[] rightHalf, Comparator<? super E> comparator) {
		int current1 = 0; int current2 = 0; int current3 = 0;
		
		while(current1 < leftHalf.length && current2 < rightHalf.length) {
			if (comparator.compare(leftHalf[current1], rightHalf[current2]) < 0) {
				temp[current3++] = leftHalf[current1++];
			}
			else 
				temp[current3++] = rightHalf[current2++];
		}
		
		while (current1 < leftHalf.length) {
			temp[current3++] = leftHalf[current1++];
		}
		while (current2 < rightHalf.length) {
			temp[current3++] = leftHalf[current2++];
		}	
	}
	
	
	
	public static void main (String [] args) {
		GenericMergeSort2 m = new GenericMergeSort2();
		Integer [] list = {6, 5, 4, 3, 2, 1};
		Double [] list2 = {8.8, 7.7, 6.6, 5.5, 4.4, 3.3, 2.2, 1.1};
		m.mergeSort(list);
		m.mergeSort(list2, Comparator.naturalOrder());

		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < list2.length; i++) {
			System.out.print(list2[i] + " ");
		}
	}

}

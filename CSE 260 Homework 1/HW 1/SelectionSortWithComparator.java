//Tian Brown, 111597217

import java.util.Comparator;

class StringComparator implements Comparator<String> {
	@Override
	public int compare(String str1, String str2) {
		return -1 * str1.compareTo(str2);
	}
}

public class SelectionSortWithComparator<E> {
	
	
	public E [] selectionSort(E[] list,  Comparator<? super E> comparator) {
		E [] sortedList = (E[]) new Object [list.length];
		
		E minElement = list[0];
		
		for (int i = 0; i < list.length; i++) {
			for (int j = i+1; j < list.length; j++) {
				if (comparator.compare(list[j], minElement) < 0) {
					minElement = list[j];
				}				
			}
			sortedList[i] = minElement;
		}
		
		return sortedList;
	}

	

}

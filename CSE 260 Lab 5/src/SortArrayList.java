import java.util.*;
public class SortArrayList {

	
	public static <E extends Comparable<E>> void sort (ArrayList <E> list) {
		E currentMin;
		int currentMinIndex;
		
		for (int i = 0; i < list.size() - 1; i++) {
			currentMin = list.get(i);
			currentMinIndex = i;
			for (int j = i + 1; j < list.size(); j++) {
				if (currentMin.compareTo(list.get(j)) > 0) {
					currentMin = list.get(j);
					currentMinIndex = j;
				}
			}
			if (currentMinIndex != i) {
				list.set(currentMinIndex, list.get(i));
				list.set(i, currentMin);
			}
			
		}
		
	}
	
	
	public static void main (String [] args) {
		ArrayList<Integer> l = new ArrayList<Integer>();
		
		l.add(4);
		l.add(3);
		l.add(5);
		l.add(7);
		l.add(1);
		
		for (int i = 0; i < l.size(); i++) {
			System.out.print(l.get(i) + " ");
		}
		
		System.out.println();
		
		sort(l);
		
		for (int i = 0; i < l.size(); i++) {
			System.out.print(l.get(i) + " ");
		}
	}
}
	


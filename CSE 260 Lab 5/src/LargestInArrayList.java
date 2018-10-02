import java.util.*;
public class LargestInArrayList {

	public static <E extends Comparable<E>> E max (ArrayList<E> list) {
		E max = list.get(0);
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).compareTo(max) > 0) {
				max = list.get(i);
			}
		}
		return max;
	}
	
	
	public static void main (String [] args) {
		ArrayList<Integer> l = new ArrayList<Integer> ();
		
		l.add(1);
		l.add(3);
		l.add(5);
		l.add(12313);
		l.add(12312);
		
		System.out.print(max(l));
	}
}

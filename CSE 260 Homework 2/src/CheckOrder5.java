//Tian Brown, 111597217

import java.util.*;
public class CheckOrder5 {
	
	public static boolean ordered(int[] list) {
		boolean ascending = true;
		
		for (int i = 0; i < list.length-1; i++) {
			if (list[i] > list[i+1]) {
				ascending = false;
			}
		}
		return ascending;
	}

	public static boolean ordered(int[] list, boolean ascending) {
		ascending = true;
		
		for (int i = 0; i < list.length-1; i++) {
			if (list[i] > list[i+1]) {
				ascending = false;
			}
		}
		return ascending;
	}

	public static boolean ordered(double[] list) {
		boolean ascending = true;
		
		for (int i = 0; i < list.length-1; i++) {
			if (list[i] > list[i+1]) {
				ascending = false;
			}
		}
		return ascending;
	}

	public static boolean ordered (double[] list, boolean ascending) {
		ascending = true;
		
		for (int i = 0; i < list.length-1; i++) {
			if (list[i] > list[i+1]) {
				ascending = false;
			}
		}
		return ascending;
	}

	public static <E extends Comparable<E>> boolean ordered(E[] list) {
		boolean ascending = true;
		
		for (int i = 0; i < list.length-1; i++) {
			if (list[i].compareTo(list[i+1]) > 0) {
				ascending = false;
			}
		}
		return ascending;
	}

	public static <E extends Comparable<E>> boolean ordered(E[] list, boolean ascending) {
		ascending = true;
		
		for (int i = 0; i < list.length-1; i++) {
			if (list[i].compareTo(list[i+1]) > 0) {
				ascending = false;
			}
		}
		return ascending;
	}

	public static <E> boolean ordered(E[] list, Comparator<? super E> comparator) {
		boolean ascending = true;
		
		for (int i = 0; i < list.length-1; i++) {
			if (comparator.compare(list[i], list[i+1]) > 0) {
				ascending = false;
			}
		}
		return ascending;
	}

	public static <E> boolean ordered(E[] list, Comparator<? super E> comparator, boolean ascending) {
		ascending = true;
		
		for (int i = 0; i < list.length-1; i++) {
			if (comparator.compare(list[i], list[i+1]) > 0) {
				ascending = false;
			}
		}
		return ascending;
	}
	
	public static void main (String [] args) {
		int [] list = {7, 6, 5, 4, 3, 2, 1};
		int [] list2 = {1, 2, 3, 4, 5};
		System.out.println(ordered(list));
		System.out.println(ordered(list2));
	}

}

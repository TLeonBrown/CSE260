public class Max {
	
	public static <E extends Comparable<E>> E max(E[] list) {
		E max = list[0];
		
		for (int i = 0; i < list.length; i++) {
			if (max.compareTo(list[i]) < 0) {
				max = list[i];
			}
		}
		return max;
	}

	public static void main(String[] args) {
		String [] list = {"a", "b", "e", "d", "t", "u", "x", "s"};
		
		System.out.print(max(list));
		

	}

}

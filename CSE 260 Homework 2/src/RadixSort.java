//HELPER CLASS TO HELP THE EXECUTION TIME PROBLEM (#10)
//Tian Brown, 111597217
public class RadixSort {
	
	public RadixSort () {
		
	}
	
	public void radixSort (Integer [] l) {
        int i, m = l[0], ex = 1, len = l.length;
        int[] b = new int[len];
        for (i = 1; i < len; i++) {
            if (l[i] > m)
                m = l[i];
        }
        while (m / ex > 0) {
        	int[] radixBuckets = new int[10];
            for (i = 0; i < len; i++)
                radixBuckets[(l[i] / ex) % 10]++;
            
            for (i = 1; i < 10; i++)
                radixBuckets[i] += radixBuckets[i-1];

            for (i = len - 1; i >= 0; i--)
                b[--radixBuckets[(l[i] / ex) % 10]] = l[i];

            for (i = 0; i < len; i++)
               l[i] = b[i];

            ex = ex * 10;        
        }
	}

	public static void main(String[] args) {
		RadixSort r = new RadixSort();
		Integer [] list = {1, 4, 3, 2, 5, 7, 6, 8, 10, 10, 10, 9};
		r.radixSort(list);
		
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}

	}

}

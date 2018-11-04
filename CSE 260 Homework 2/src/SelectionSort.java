//HELPER CLASS TO FIND EXECUTION TIMES (Problem #10)
//Tian Brown, 111597217
public class SelectionSort {
	
	public SelectionSort () {
		
	}
	
	public void selectionSort (Integer [] list) {
		 for (int i = 0; i < list.length - 1; i++)  {  
	            int index = i;  
	            for (int j = i + 1; j < list.length; j++) {  
	                if (list[j] < list[index]){  
	                    index = j;
	                }
	            }
	            //swap
	            int smallerNumber = list[index];   
	            list[index] = list[i];  
	            list[i] = smallerNumber;  
	        }  
	}

	
	
	public static void main(String[] args) {
		SelectionSort s = new SelectionSort ();
		Integer [] list = {8, 7, 6, 5, 4, 3, 2, 1};
		s.selectionSort(list);

		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
	}

}

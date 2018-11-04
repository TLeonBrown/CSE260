	//Tian Brown, 111597217
import java.util.*;

public class SortingExecutionTime10 {
	
	//CREATE A RANDOM ARRAY OF VARIABLE SIZE
	public static Integer [] createRandomArray(int size) {
		Integer [] list = new Integer [size];
		Random rand = new Random();
		for (int i = 0; i < size; i++) {
			int num = rand.nextInt(Integer.MAX_VALUE) + 1;
			list[i] = num;
		}
		return list;
	}
	
	
	//METHODS TO SORT, AND CALCULATE RUNTIME FOR VARIOUS SORTING ALGORITHMS
	public static long selSortRunTime (Integer [] l) {
		SelectionSort s = new SelectionSort();
		long startTime = System.currentTimeMillis();
			s.selectionSort(l);
		long endTime = System.currentTimeMillis();
		long executionTime = endTime - startTime;
		return executionTime;
	}
	public static long bubSortRunTime (Integer [] l) {
		GenericBubbleSort1 b = new GenericBubbleSort1();
		long startTime = System.currentTimeMillis();
			b.bubbleSort(l);
		long endTime = System.currentTimeMillis();
		long executionTime = endTime - startTime;
		return executionTime;
	}	
	public static long mergSortRunTime (Integer [] l) {
		GenericMergeSort2 m = new GenericMergeSort2();
		long startTime = System.currentTimeMillis();
			m.mergeSort(l);
		long endTime = System.currentTimeMillis();
		long executionTime = endTime - startTime;
		return executionTime;
	}	
	public static long quikSortRunTime (Integer [] l) {
		GenericQuickSort3 q = new GenericQuickSort3();
		long startTime = System.currentTimeMillis();
			q.quickSort(l);
		long endTime = System.currentTimeMillis();
		long executionTime = endTime - startTime;
		return executionTime;
	}
	public static long heapSortRunTime (Integer [] l) {
		GenericHeapSort4 h = new GenericHeapSort4();
		long startTime = System.currentTimeMillis();
			h.heapSort(l);
		long endTime = System.currentTimeMillis();
		long executionTime = endTime - startTime;
		return executionTime;
	}
	public static long radixSortRunTime (Integer [] l) {
		RadixSort r = new RadixSort();
		long startTime = System.currentTimeMillis();
			r.radixSort(l);
		long endTime = System.currentTimeMillis();
		long executionTime = endTime - startTime;
		return executionTime;
	}
	
	
//MAIN METHOD
	public static void main(String[] args) {
		
		//CREATE THE GRID
		String [] [] grid = new String [6][7];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				grid[i][j] = "0";
			}
		}
		grid[0][0] = "Array Size"; grid[0][1] = "Selection Sort"; grid[0][2] = "Bubble Sort";
		grid[0][3] = "Merge Sort"; grid[0][4] = "Quick Sort"; grid[0][5] = "Heap Sort";
		grid[0][6] = "Radix Sort";
		grid[1][0] = "50,000"; grid[2][0] = "100,000";
		grid[3][0] = "250,000"; grid[4][0] = "500,000";
		grid[5][0] = "1,000,000";
		long executionTime = 0;
		
		System.out.println("Starting the computation...");
		//CREATE ARRAYS OF THE VARIOUS SIZES AND INSERT RUNTIMES INTO THE GRID
	
		//1 - SELECTION SORT
		//50k
		Integer [] selectionSortList = createRandomArray(50000);
		executionTime = selSortRunTime(selectionSortList);
		grid[1][1] = "" + executionTime;
		//100k
		selectionSortList = createRandomArray(100000);
		executionTime = selSortRunTime(selectionSortList);
		grid[2][1] = "" + executionTime;
		//250k
		selectionSortList = createRandomArray(250000);
		executionTime = selSortRunTime(selectionSortList);
		grid[3][1] = "" + executionTime;
		//500k
		selectionSortList = createRandomArray(500000);
		executionTime = selSortRunTime(selectionSortList);
		grid[4][1] = "" + executionTime;
		//1m
		selectionSortList = createRandomArray(1000000);
		executionTime = selSortRunTime(selectionSortList);
		grid[5][1] = "" + executionTime;									
		System.out.println("Finished selection sort!");
		
		//2 - BUBBLE SORT
		//50k
		Integer [] bubbleSortList = createRandomArray(50000);
		executionTime = bubSortRunTime(bubbleSortList);
		grid[1][2] = "" + executionTime;
		//100k 
		bubbleSortList = createRandomArray(100000);
		executionTime = bubSortRunTime(bubbleSortList);
		grid[2][2] = "" + executionTime;

		//250k
		bubbleSortList = createRandomArray(250000);
		executionTime = bubSortRunTime(bubbleSortList);
		grid[3][2] = "" + executionTime;
		//500k
		bubbleSortList = createRandomArray(500000);
		executionTime = bubSortRunTime(bubbleSortList);
		grid[4][2] = "" + executionTime;
		//1m
		bubbleSortList = createRandomArray(1000000);
		executionTime = bubSortRunTime(bubbleSortList);
		grid[5][2] = "" + executionTime;								
		System.out.println("Finished bubble sort!");	
		
		//3 - MERGE SORT
		//50k
		Integer [] mergeSortList = createRandomArray(50000);
		executionTime = mergSortRunTime(mergeSortList);
		grid[1][3] = "" + executionTime;
		//100k
		mergeSortList = createRandomArray(100000);
		executionTime = mergSortRunTime(mergeSortList);
		grid[2][3] = "" + executionTime;
		//250k
		mergeSortList = createRandomArray(250000);
		executionTime = mergSortRunTime(mergeSortList);
		grid[3][3] = "" + executionTime;
		//500k
		mergeSortList = createRandomArray(500000);
		executionTime = mergSortRunTime(mergeSortList);
		grid[4][3] = "" + executionTime;
		//1m
		mergeSortList = createRandomArray(1000000);
		executionTime = mergSortRunTime(mergeSortList);
		grid[5][3] = "" + executionTime;						
		System.out.println("Finished merge sort!");	
		
		//4 - QUICK SORT
		//50k
		Integer [] quickSortList = createRandomArray(50000);
		executionTime = quikSortRunTime(quickSortList);
		grid[1][4] = "" + executionTime;
		//100k
		quickSortList = createRandomArray(100000);
		executionTime = quikSortRunTime(quickSortList);
		grid[2][4] = "" + executionTime;
		//250k
		quickSortList = createRandomArray(250000);
		executionTime = quikSortRunTime(quickSortList);
		grid[3][4] = "" + executionTime;
		//500k
		quickSortList = createRandomArray(500000);
		executionTime = quikSortRunTime(quickSortList);
		grid[4][4] = "" + executionTime;
		//1m
		quickSortList = createRandomArray(1000000);
		executionTime = quikSortRunTime(quickSortList);
		grid[5][4] = "" + executionTime;					
		System.out.println("Finished quick sort!");
		
		//5 - HEAP SORT
		//50k
		Integer [] heapSortList = createRandomArray(50000);
		executionTime = heapSortRunTime(heapSortList);
		grid[1][5] = "" + executionTime;
		//100k
		heapSortList = createRandomArray(100000);
		executionTime = heapSortRunTime(heapSortList);
		grid[2][5] = "" + executionTime;
		//250k
		heapSortList = createRandomArray(250000);
		executionTime = heapSortRunTime(heapSortList);
		grid[3][5] = "" + executionTime;
		//500k
		heapSortList = createRandomArray(500000);
		executionTime = heapSortRunTime(heapSortList);
		grid[4][5] = "" + executionTime;
		//1m
		heapSortList = createRandomArray(1000000);
		executionTime = heapSortRunTime(heapSortList);
		grid[5][5] = "" + executionTime;					
		System.out.println("Finished heap sort!");
		
		//6 - RADIX SORT
		//50k
		Integer [] radixSortList = createRandomArray(50000);
		executionTime = radixSortRunTime(radixSortList);
		grid[1][6] = "" + executionTime;		
		//100k
		radixSortList = createRandomArray(100000);
		executionTime = radixSortRunTime(radixSortList);
		grid[2][6] = "" + executionTime;
		//250k
		radixSortList = createRandomArray(250000);
		executionTime = radixSortRunTime(radixSortList);
		grid[3][6] = "" + executionTime;
		//500k
		radixSortList = createRandomArray(500000);
		executionTime = radixSortRunTime(radixSortList);
		grid[4][6] = "" + executionTime;
		//1m
		radixSortList = createRandomArray(1000000);
		executionTime = radixSortRunTime(radixSortList);
		grid[5][6] = "" + executionTime;					
		System.out.println("Finished radix sort!");
		System.out.println("Printing...");
		System.out.println();
		
		//PRINT THE RESULTS TO SYSTEM.OUT
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				System.out.print(String.format("%-20s", ""+grid[i][j]));
			}
			System.out.println();
		}

}}

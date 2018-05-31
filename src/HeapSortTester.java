//HeapSortTester
//Programmer: Malcolm Milton
//Date: 10/9/15
//Class that tests the HeapSort class

import java.util.Arrays;

public class HeapSortTester {

	public static void main(String[] args) {

		HeapSort<Integer> heap = new HeapSort<Integer>();
		Integer array[] = {6,1,9,4,0,8,3,2,7,5};
		System.out.println("Before: " + Arrays.toString(array));
		heap.heapsort(array);
		System.out.println("After: " + Arrays.toString(array));
		
		HeapSort<String> heap2 = new HeapSort<String>();
		String array2[] = {"Hi","my","name","is","Malcolm","and","I","am","a","computer","programmer"};
		System.out.println("Before: " + Arrays.toString(array2));
		heap2.heapsort(array2);
		System.out.println("After: " + Arrays.toString(array2));
	}

}

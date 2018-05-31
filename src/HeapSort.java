//HeapSort
//Programmer: Malcolm Milton
//Date: 10/9/15
//Class that sorts a generic array by using the heap property

public class HeapSort<T extends Comparable<T>> {
	
	int length = 0; //Length of the heap, not necessarily length of the array. Can be used by whole class
	
	private int parent(int i)
	{ //Method to calculate the index of the parent of the parameter index
		i++; //Increments i so the formula will work for left and right child
		return (i/2) - 1; //The parent is located in index that's half of (parameter+1) -1
	}
	
	private int leftChild(int i)
	{ //Method to calculate the left child of the parameter index
		return (i*2) + 1; //Left child is located at twice parameter index +1
	}
	
	private int rightChild(int i)
	{ //Method to calculate the right child of the parameter index
		return (i*2) + 2; //Right child is located at twice parameter index +2
	}
	
	private void buildMaxHeap(T[] array)
	{ //Method to satisfy the heap property for every item in the heap
		for(int i=length; i>=0; i--) //Only does the size of heap, not array
			maxHeapify(array, i); //Calls the method to make sure current sub tree is a heap
	}
	
	private int findMax(T[] array, int i)
	{ //Method to find the max out of the parameter and its children
		int max = i; //Assumes the parameter item's index is the max
		if(i*2+1 < length && array[max].compareTo(array[leftChild(i)]) < 0) //If a left child exists and its larger than the parent
			max = leftChild(i); //Makes the max item the left child's index
		if(i*2+2 < length && array[max].compareTo(array[rightChild(i)]) < 0) //If a right child exists and its larger than the parent and left child
			max = rightChild(i); //Makes the max item the right child's index
		return max; //Returns the index of the largest item
	}
	
	private void swap(T[] array, int i, int x)
	{ //Method to swap two items in the array
		T temp = array[i]; //Makes a temporary item
		array[i] = array[x]; //Copies one item to the index
		array[x] = temp; //Copies the other item to the other index
	}
	
	private void maxHeapify(T[] array, int i)
	{ //Method to satisfy heap property for a parent and its children
		int max = findMax(array, i); //Calls the method to find the largest of the three
		if(max != i) //If the largest is not the parent
		{
			swap(array, i, max); //Switches the items in the two parameter indexes
			maxHeapify(array, max); //Calls this method again for the index that used to be a parent to make sure that its new children are smaller than it
		}
	}
	
	public void heapsort(T[] array)
	{ //Method that sorts an array by using the heap property
		length = array.length; //Changes the global variable length to the length of the array
		for(int i=length-1; i>0; i--)
		{ //Starts at the last element and goes down to the first element
			buildMaxHeap(array); //Calls the method to make the elements in the heap a heap
			swap(array, 0, i); //Switches the largest element of the heap with the last element
			length--; //Decrements the size of the heap. Elements outside of the heap are sorted
		}
	}
}

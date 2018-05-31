import java.util.Arrays;

//HeapSort
//Programmer: Malcolm Milton
//Date: 10/9/15
//Class that implements a heap-based max priority queue

public class PriorityQueue<T extends Comparable<T>>{
	
	private int queueSize; //The size of the queue, not the array size
	private int capacity; //The size of the array that the queue is im
	private T array[]; //The array used for the queue
	
	public PriorityQueue()
	{ //Constructor for the priorityQueue
		capacity = 8; //Sets the initial capacity to 8
		queueSize = 0; //Sets the initial amount of elements in the queue to 0
		array = (T[]) new Comparable[capacity]; //Creates an array of 8 comparable objects
	}
	
	void swap(int i, int j)
	{ //Method to swap two elements in the array
		T temp = array[i]; //Makes a temporary item
		array[i] = array[j]; //Copies one item to the index
		array[j] = temp; //Copies the other item to the other index
	}
	
	private int parent(int i)
	{ //Method to calculate the index of the parent of the parameter index
		i++; //Increments i so the formula will work for left and right child
		return (i/2) - 1; //The parent is located in index that's half of (parameter+1) -1
	}
	
	private void maxHeapify(int i)
	{ //Method to satisfy heap property for a parent and its children
		int max = findMax(array, i); //Calls the method to find the largest of the three
		if(max != i) //If the largest is not the parent
		{
			swap(i, max); //Switches the items in the two parameter indexes
			maxHeapify(max); //Calls this method again for the index that used to be a parent to make sure that its new children are smaller than it
		}
	}
	
	private int findMax(T[] array, int i)
	{ //Method to find the max out of the parameter and its children
		int max = i; //Assumes the parameter item's index is the max
		if(i*2+1 < queueSize && array[max].compareTo(array[leftChild(i)]) < 0) //If a left child exists and its larger than the parent
			max = leftChild(i); //Makes the max item the left child's index
		if(i*2+2 < queueSize && array[max].compareTo(array[rightChild(i)]) < 0) //If a right child exists and its larger than the parent and left child
			max = rightChild(i); //Makes the max item the right child's index
		return max; //Returns the index of the largest item
	}
	
	private int leftChild(int i)
	{ //Method to calculate the left child of the parameter index
		return (i*2) + 1; //Left child is located at twice parameter index +1
	}
	
	private int rightChild(int i)
	{ //Method to calculate the right child of the parameter index
		return (i*2) + 2; //Right child is located at twice parameter index +2
	}
	
	public void insert(T item)
	{ //Method to insert a new element into the priority queue
		if(item == null) //If the item trying to put in doesn't have a value
			throw new NullPointerException("The item is null"); //Throws null pointer exception
		else //If the new element has a key
		{
			if(queueSize == capacity) //If there is no more space in the array for a new element
			{
				capacity *= 2; //Increases the capacity (size of the new array)
				T array2[] = Arrays.copyOf(array, capacity); //Makes a copy of the queue
				array = null; //Deletes the array that has no more space
				array = Arrays.copyOf(array2, capacity); //Copies the earlier copy of the queue to the regular array
			}
			array[queueSize] = item; //Inserts the new item into the next spot in the queue
			int itemIndex = queueSize; //Keeps track of where the item was placed in the array
			queueSize++; //Increases the size of the queue
			while(itemIndex!=0 && item.compareTo(array[parent(itemIndex)]) > 0)
			{ //While the new item isn't the first item, and the key of the new item is larger than its parent's key
				swap(parent(itemIndex), itemIndex); //Calls the method to swap the parent and new item
				itemIndex = parent(itemIndex); //Updates the index of the new item
			}
		}
	}
	
	public T maximum()
	{ //Method to return the maximum element in the array
		if(queueSize != 0) //If there are elements in the queue
			return array[0]; //Returns the first element in the array, which is the largest
		else //If there are no elements in the queue
			return null; //Returns that nothing is in the queue
	}
	
	public T extractMax()
	{ //Method to take out the largest element of the queue while still maintaining the heap property
		T temp = null; //Creates a temporary comparable object of nothing
		if(queueSize != 0) //If there are elements in the queue
		{
			temp = array[0]; //Sets temp to the largest element
			swap(0, --queueSize); //Decrements queueSize before swapping the two items
			maxHeapify(0); //Calls the function to satisfy the heap property for each element
		}
		return temp; //Returns the temporary variable
	}
	
	public int size()
	{ //Method to return the size of the queue
		return queueSize; //Returns the queueSize
	}
	
	public int capacity()
	{ //Method to return the size of the array
		return capacity; //Returns the size of the array
	}
	
	public String toString()
	{ //Method to return a string that contains the print out of the order of elements in the queue
		String temp = "The queue is empty"; //Sets the initial value of the string to say this
		if(queueSize != 0) //If there are items in the queue
		{
			temp = ""; //Puts the value of the string to nothing
			temp += array[0]; //Adds the key value of the first item to the string
			for(int x=1; x<queueSize; x++) //Starts at the second item and loops to the last element
				temp += (", " + array[x]); //Adds the key value of the next item to the string
			
		}
		return temp; //Returns the string
	}
}
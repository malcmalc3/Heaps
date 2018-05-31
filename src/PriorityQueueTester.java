//HeapSort
//Programmer: Malcolm Milton
//Date: 10/9/15
//Class that implements a heap-based max priority queue

import java.util.Scanner;

public class PriorityQueueTester {
	
	public static void main(String[] args) {
		
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(); //Creates Integer instance of PriorityQueue class
		PriorityQueue<String> queue2 = new PriorityQueue<String>(); //Creates String instance of PriorityQueue class
		Scanner keyboard = new Scanner(System.in);
		int choice = 1; //Variable for getting user's choice about what to do with queue
		int choice2 = 1; //Variable to get user's choice of which queue to use
		
		while(choice2 != 0) //While the user doesn't want to quit the program
		{
			menu2();
			choice2 = keyboard.nextInt();
			if(choice2 == 1)
			{
				choice = 1;
				while(choice != 0)
				{
					menu();
					choice = keyboard.nextInt();
					
					if(choice == 1)
					{
						int item = 0;
						while(item != -99)
						{
							System.out.print("Enter an integer to insert into the array (Enter -99 to stop): ");
							item = keyboard.nextInt();
							if(item != -99)
								queue.insert(item);
						}
					}
					else if (choice == 2)
						System.out.println("Max item: " + queue.maximum());
					else if (choice == 3)
						System.out.println("Item extracted: " + queue.extractMax());
					else if (choice == 4)
						System.out.println("Queue size: " + queue.size());
					else if (choice == 5)
						System.out.println("Queue capacity: " + queue.capacity());
					else if (choice == 6)
						System.out.println(queue.toString());
					else if (choice != 0)
						System.out.println("Please choose a valid option");
				}
			}
			else if(choice2 ==2)
			{
				choice = 1;
				while(choice != 0)
				{
					menu();
					choice = keyboard.nextInt();
					
					if(choice == 1)
					{
						String item = "";
						while(!item.equals("-99"))
						{
							System.out.print("Enter an integer to insert into the array (Enter -99 to stop): ");
							item = keyboard.nextLine();
							if(!item.equals("-99"))
								queue2.insert(item);
						}
					}
					else if (choice == 2)
						System.out.println("Max item: " + queue2.maximum());
					else if (choice == 3)
						System.out.println("Item extracted: " + queue2.extractMax());
					else if (choice == 4)
						System.out.println("Queue size: " + queue2.size());
					else if (choice == 5)
						System.out.println("Queue capacity: " + queue2.capacity());
					else if (choice == 6)
						System.out.println(queue2.toString());
					else if (choice != 0)
						System.out.println("Please choose a valid option");
				}
			}
		}
		System.out.println("Thankyou come again");
		keyboard.close();
	}
	
	static void menu()
	{ //Method to display menu for what to do with queue
		System.out.println("Please choose an option:");
		System.out.println("0. Exit");
		System.out.println("1. Insert Items");
		System.out.println("2. Return Maximum Item");
		System.out.println("3. Extract Maximum Item");
		System.out.println("4. Return Queue Size");
		System.out.println("5. Return Queue Capacity");
		System.out.println("6. Print the Queue");
	}
	
	static void menu2()
	{ //Method to display menu for which queue to use
		System.out.println("Please choose an option:");
		System.out.println("0. Exit");
		System.out.println("1. Use Integer priority queue");
		System.out.println("2. Use String priority queue");
	}
	
}
/* CSI 213 - Practice1 - Question 4
 * This program sorts data using either bubble sort or selection sort
 * The purpose is to practice inheritance
 */
package session1Answers;

//Class Sort is the superclass
//It also contains a built-in array
public class Sort 
{
	// Built-in array and its size
	protected int[] data;
	protected int size;
	
	// Used to control the boundaries of random numbers
	private static final int maxNumber = 999;
	private static final int minNumber = 100;
	
	// Default constructor
	public Sort()
	{
		size = 1;
		data = new int[size];
		// Not really needed method
		reset();
	}
	
	public Sort(int size)
	{
		// Make sure 'size' is non-negative
		this.size = (size >= 0) ? size : 1;
		data = new int[size];
		reset();
	}
	
	public void print()
	{
		// Print all the numbers in 'data'
		for (int i = 0; i < size; i++)
		{
			System.out.printf("%d ", data[i]);
			
			// Print a new line every 10 numbers
			if((i+1) % 11 == 10)
			{
				System.out.print("\n");
			}
		}
	}
	
	// Populate the 'data' using some random numbers
	public void randomize()
	{
		int randomNumber;
		
		for(int i = 0; i < size; i++)
		{
			// There is an alternative way to create a random number using Random class
			randomNumber = (int) (Math.random() * (maxNumber - minNumber) + minNumber);
			data[i] = randomNumber;
		}
	} // end randomize
	
	// Set all elements to zero
	public void reset()
	{
		for(int i = 0; i < size; i++)
		{
			data[i] = 0;
		}
	}
	
	public static void main(String[] args)
	{
		BubbleSort bubbleSort = new BubbleSort(10);
		SelectionSort selectionSort = new SelectionSort(10);
		
		bubbleSort.randomize();
		bubbleSort.print();
		bubbleSort.sortData();
		bubbleSort.print();
		System.out.println("---------------------------------");
		System.out.println("---------------------------------");
		selectionSort.randomize();
		selectionSort.print();
		selectionSort.sortData();
		selectionSort.print();
	}
}

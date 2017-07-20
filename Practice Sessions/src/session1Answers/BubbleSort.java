package session1Answers;

public class BubbleSort extends Sort 
{
	// Call the super class constructor
	public BubbleSort()
	{
		super();
	}
	
	// Call the super class overload constructor
	public BubbleSort(int size)
	{
		super(size);
	}
	
	// Sort data using bubble sort algorithm
	public void sortData()
	{
		boolean isSorted;
		int j;
		
		// Initially, assume the data is not sorted
		isSorted = false;
		j = 1;
		
		while(!isSorted)
		{
			// Assume data is sorted, unless a swap occurs
			isSorted = true;
			
			// Go through all remaining elements
			for(int i = 0; i < size - j; i++)
			{
				if(data[i] > data[i+1])
				{
					// If a swap occurs, then the array is not sorted
					isSorted = false;
					
					// Swap data
					int temp = data[i];
					data[i] = data[i+1];
					data[i+1] = temp;
				} // end if
			} // end for
			
			// One more element is in its right location
			// We do not need to worry about it anymore
			j++;
		} // end while
	}// end sortData
} // end bubbleSort

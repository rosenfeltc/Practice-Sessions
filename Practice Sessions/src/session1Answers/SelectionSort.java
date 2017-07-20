package session1Answers;

public class SelectionSort extends Sort
{
	// Call the superclass constructor
	public SelectionSort()
	{
		super();
	} // end constructor
	
	// Call the superclass overload constructor
	public SelectionSort(int size)
	{
		super(size);
	} // end constructor
	
	// Sort data using selection sort algorithm
	public void sortData()
	{
		// The location of the smallest number
		int indexMin;
		
		// Find the i-th smallest number
		for(int i = 0; i < size; i++)
		{
			// Assume the current number is the lowest
			indexMin = i;
			
			// Check if the above assumption is right, if not, change indexMin
			for(int j = i + 1; j < size; j++)
			{
				if(data[j] < data[indexMin])
				{
					indexMin = j;
				}
			}
			
			// Put the i-th smallest number in its location
			int holder = data[i];
			data[i] = data[indexMin];
			data[indexMin] = holder;
		} // end for
	} // end sortData
} // end class SelectionSort

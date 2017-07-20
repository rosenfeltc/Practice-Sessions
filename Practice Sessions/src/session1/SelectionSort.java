package session1;

public class SelectionSort extends Sort
{
	public SelectionSort(int n)
	{
		super(n);
	}
	
	public void sortData()
	{
		int lowest;
		int position;
		
		for(int i = 0; i < this.numbers.length; i++)
		{
			lowest = this.numbers[i];
			position = i;
			
			for(int j = i + 1; j < this.numbers.length;j++)
			{
				if(this.numbers[j] < lowest)
				{
					lowest = this.numbers[j];
					position = j;
				}
			}
			
			this.numbers[position] = this.numbers[i];
			this.numbers[i] = lowest;
		}
	}
}

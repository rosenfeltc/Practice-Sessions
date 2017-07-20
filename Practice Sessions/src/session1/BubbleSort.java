package session1;

public class BubbleSort extends Sort 
{
	public BubbleSort(int n)
	{
		super(n);
	}
	
	public void sortData()
	{
		int temp;
		
		for(int i = 0; i < this.numbers.length - 1; i++)
		{
			for(int j = 0; j < this.numbers.length - 1 - i; j++)
			{
				if(this.numbers[j] > this.numbers[j+1])
				{
					temp = this.numbers[j+1];
					this.numbers[j+1] = this.numbers[j];
					this.numbers[j] = temp;
				}
			}
		}
	}
}

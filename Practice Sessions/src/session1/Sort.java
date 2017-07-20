package session1;

import javax.swing.JOptionPane;

public class Sort
{
	protected int[] numbers;
	
	public Sort(int n)
	{
		this.numbers = new int[n];
	}
	
	public void read()
	{
		for(int i = 0; i < this.numbers.length; i++)
		{
			this.numbers[i] = Integer.parseInt(JOptionPane.showInputDialog("Please provide number " + (i + 1)));
		}
	}
	
	public void print()
	{
		String numbersAsWords = "";
		
		for(int i = 0; i < this.numbers.length; i++)
		{
			numbersAsWords += this.numbers[i];
			if(i != this.numbers.length - 1)
			{
				numbersAsWords += ", ";
			}
		}
		
		JOptionPane.showMessageDialog(null, "Your array is:\n" + numbersAsWords);
	}
}

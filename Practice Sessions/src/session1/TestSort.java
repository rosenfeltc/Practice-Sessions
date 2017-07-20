package session1;

import javax.swing.JOptionPane;

public class TestSort 
{
	public static void main(String[] args)
	{
		int number = Integer.parseInt(JOptionPane.showInputDialog("How many numbers are in your array?\n"));
		BubbleSort array1 = new BubbleSort(number);
		SelectionSort array2 = new SelectionSort(number);
		
		array1.read();
		array1.print();
		array1.sortData();
		array1.print();
		
		array2.read();
		array2.print();
		array2.sortData();
		array2.print();
		
		
	}
}

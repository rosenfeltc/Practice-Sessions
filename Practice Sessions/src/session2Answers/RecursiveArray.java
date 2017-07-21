package session2Answers;

import javax.swing.JOptionPane;
import java.util.Random;

public class RecursiveArray
{
	public static void main(String[] args)
	{
		Random generator = new Random();
		String theString = new String();
		int checkRow, checkColumn;
		
		int rows = Integer.parseInt(JOptionPane.showInputDialog("Please enter number of rows"));
		int columns = Integer.parseInt(JOptionPane.showInputDialog("Please enter number of columns"));
		
		char[][] theArray = new char[rows][columns];
		char[] theLetters = {'A', 'E', 'S'};
		
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < columns; j++)
			{
				theArray[i][j] = theLetters[Math.abs(generator.nextInt() % 3)];
			}
		}
		
		
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < columns; j++)
			{
				theString += theArray[i][j] + " ";
			}
			
			theString += "\n";
		}
		
		
		JOptionPane.showMessageDialog(null, theString);
		
		checkRow = palindromeRow(theArray, rows, columns);
		checkColumn = palindromeColumn(theArray, rows, columns);
		
		if(checkColumn >= 0)
		{
			JOptionPane.showMessageDialog(null, "Column Palindrome found at column " + checkColumn);
			theString = "<html> ";
			for(int i = 0; i < rows; i++)
			{
				for(int j = 0; j < columns; j++)
				{
					if(j == checkColumn)
					{
						theString += " <font color=#ff0000> ";
					}
					
					theString += theArray[i][j] + " ";
					
					if(j == checkColumn)
					{
						theString += " </font> ";
					}
				}
				
				theString += " <br> ";
			}
			
			theString += " </html>";
			
			JOptionPane.showMessageDialog(null, theString);
		}
		else if(checkRow >= 0)
		{
			JOptionPane.showMessageDialog(null, "Row Palindrome found at row " + checkRow);
			theString = "<html> ";
			for(int i = 0; i < rows; i++)
			{
				if(i == checkRow)
				{
					theString += " <font color=#ff0000> ";
				}
				
				for(int j = 0; j < columns; j++)
				{
						theString += theArray[i][j] + " ";
				}
				
				if(i == checkRow)
				{
					theString += " </font> ";
				}
				
				theString += " <br> ";
			}
			
			theString += " </html>";
			
			JOptionPane.showMessageDialog(null, theString);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "The random array has no palindromes!");
		}
	}
	
	public static int palindromeRow(char[][] theArray, int rows, int columns)
	{
		String checkRow = new String();
		
		for(int i = 0; i < rows; i++)
		{
			checkRow = "";
			for(int j = 0; j < columns; j++)
			{
				checkRow += theArray[i][j];
			}
			if(isPalindrome(checkRow))
			{
				return i;
			}
		}
		
		return -1;
	}
	
	public static int palindromeColumn(char[][] theArray, int rows, int columns)
	{
		String checkColumn = new String();
		
		for(int i = 0; i < columns; i++)
		{
			checkColumn = "";
			for(int j = 0; j < rows; j++)
			{
				checkColumn += theArray[j][i];
			}
			if(isPalindrome(checkColumn))
			{
				return i;
			}
		}
		
		return -1;
	}
	
	public static boolean isPalindrome(String theWord)
	{
		if(theWord.length() <= 1)
		{
			return true;
		}
		else if(theWord.charAt(0) == theWord.charAt(theWord.length() - 1))
		{
			return isPalindrome(theWord.substring(1,  theWord.length() - 1));
		}
		else
		{
			return false;
		}
	}
}
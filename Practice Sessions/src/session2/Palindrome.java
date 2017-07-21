package session2;

import java.util.Random;
import javax.swing.JOptionPane;

public class Palindrome 
{
	Random generator = new Random();
	char[][] theArray;
	
	public Palindrome(int row, int column)
	{
		theArray = new char[row][column];
	}
	
	public void randomize()
	{
		int randomNumber;
		char randomLetter = 'Z';
		
		for(int i = 0; i < theArray.length; i++)
		{
			for(int j = 0; j < theArray[0].length; j++)
			{
				randomNumber = Math.abs(generator.nextInt()) % 3;
				switch(randomNumber)
				{
				case 0:
					randomLetter = 'A';
					break;
				case 1:
					randomLetter = 'E';
					break;
				case 2:
					randomLetter = 'S';
					break;
				}
				
				theArray[i][j] = randomLetter;
			}
		}
	}
	
	public void printArray()
	{
		String result = "<html><body><font face=\"Comic Sans MS\" size=24>";
		for(int i = 0; i < theArray.length; i++)
		{
			for(int j = 0; j < theArray[0].length; j++)
			{
				result += theArray[i][j] + "&nbsp;";
			}
			result += "<br>";
		}
		
		result +="</font></body></html>";
		
		JOptionPane.showMessageDialog(null, result);
		
	}
	
	public boolean isPalindrome(String word)
	{
		if(word.length() <= 1)
		{
			return true;
		}
		else if(word.charAt(0) == word.charAt(word.length() - 1))
		{
			return isPalindrome(word.substring(1, word.length() - 1));
		}
		else
		{
			return false;
		}
	}
	
	public void checkPalindrome()
	{
		int[][] bool = new int[theArray.length][theArray[0].length];
		
		String word = "";
		String answer = "<html><body>";
		for(int i = 0; i < theArray.length; i++)
		{
			for(int j = 0; j < theArray[0].length; j++)
			{
				word += theArray[i][j];
			}
			
			if(isPalindrome(word))
			{
				for(int j = 0; j < bool[0].length; j++)
				{
					bool[i][j] = 1;
				}
			}
			
			word = "";
		}
		
		for(int i = 0; i < theArray[0].length; i++)
		{
			for(int j = 0; j < theArray.length; j++)
			{
				word += theArray[j][i];
			}
			
			if(isPalindrome(word))
			{
				for(int j = 0; j < bool[0].length; j++)
				{
					bool[j][i] = 1;
				}
			}
			
			word = "";
		}
		
		for(int i = 0; i < bool.length; i++)
		{
			for(int j = 0; j < bool[0].length; j++)
			{
				if(bool[i][j] == 1)
				{
					answer += "<font size=24 face=\"Comic Sans MS\" color=#ff0000>" + theArray[i][j] + "&emsp;" + "</font>";
				}
				else
				{
					answer += "<font size=24 face=\"Comic Sans MS\" color=#000000>" + theArray[i][j] + "&emsp;" + "</font>";
				}
			}
			answer += "<br>";
		}
		
		answer += "</body></html>";
		
		JOptionPane.showMessageDialog(null, answer);
	}
	
	public static void main(String[] args)
	{
		int row = Integer.parseInt(JOptionPane.showInputDialog("How many rows in your 2D array? "));
		int column = Integer.parseInt(JOptionPane.showInputDialog("How many columns in your 2D array? "));
		Palindrome matrix = new Palindrome(row, column);
		matrix.randomize();
		matrix.printArray();
		matrix.checkPalindrome();
		
	}
}

/*CSI213 - Practice1 - Question 2
 * This program receives a number from the user and prints all the prime numbers up to that number.
 * It uses Trial Division algorithm
 */
package session1Answers;

import javax.swing.JOptionPane;

public class Prime 
{
	public static boolean isPrime(int number)
	{
		// We only need to check numbers up to the square root of n
		int squareRoot;
		
		// Any number less than or equal to 1 is not prime by definition
		if(number <= 1)
		{
			return false;
		}
		
		if(number == 2)
		{
			return true;
		}
		
		// Any even number other than 2 is not prime. This allows us to increase i 
		// two at a time, thereby significantly improving performance
		if(number % 2 == 0)
		{
			return false;
		}
		
		// Doing it outside of the for loop improves the performance
		// because squareRoot is a costly operation
		squareRoot = (int) Math.sqrt(number);
		
		for(int i = 3; i <= squareRoot; i += 2)
		{
			if(number % i == 0)
			{
				return false;
			}
		}
		
		return true;
	}
	
	public static void printAllPrimes(int number)
	{
		// Used for formatting
		String message = "";
		int counter = -1;
		
		// Check to see if a number is prime, if so, print it
		for(int i = 2; i <= number; i++)
		{
			if(isPrime(i))
			{
				message += String.format("%04d ", i);
				counter++;
				
				// This is just for formatting purposes
				if(counter % 10 == 9)
				{
					message += "\n";
				}
			}
		}
		
		JOptionPane.showMessageDialog(null, message);
	}
	
	public static void main(String[] args)
	{
		int number;
		String stringNumber;
		stringNumber = JOptionPane.showInputDialog("Please enter an integer");
		number = Integer.parseInt(stringNumber);
		printAllPrimes(number);
	}
}

package session1;

import javax.swing.JOptionPane;

public class Prime 
{
	private int userNumber;
	
	public Prime()
	{
		this.userNumber = 0;
	}
	
	public void letUserPickANumber()
	{
		this.userNumber = Integer.parseInt(JOptionPane.showInputDialog("Please provide a number: "));
	}
	
	public boolean isPrime(int number)
	{
		int squareRoot = (int) Math.sqrt(number);
		
		for(int i = 2; i <= squareRoot; i++)
		{
			if(number % i == 0)
			{
				return false;
			}
		}
		
		return true;
	}
	public void printAllPrimeNumbers()
	{
		String primeNumbers = "";
		int primeCounter = 0;
		
		for(int i = 2; i <= this.userNumber; i++)
		{
			if(isPrime(i))
			{
				primeNumbers += i + " ";
				primeCounter++;
				
				if(primeCounter % 10 == 0)
				{
					primeNumbers += "\n";
				}
			}
		}
		
		JOptionPane.showMessageDialog(null, "All the prime numbers up to and including " + this.userNumber + "are:\n" + primeNumbers);
	}
	
	public static void main(String[] args)
	{
		Prime prime = new Prime();
		prime.letUserPickANumber();
		prime.printAllPrimeNumbers();
	}
}

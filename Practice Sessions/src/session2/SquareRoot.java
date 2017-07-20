package session2;

import javax.swing.JOptionPane;

public class SquareRoot
{
	public static void main(String[] args)
	{
		double n, precision, firstGuess, answer;
		n = Double.parseDouble(JOptionPane.showInputDialog("Enter the number you want the square root of: "));
		
		precision = Double.parseDouble(JOptionPane.showInputDialog("Enter the precision: "));
		
		firstGuess = n/2;
		answer = babylonian(firstGuess, n, precision);
		
		JOptionPane.showMessageDialog(null, "The square root of " + n + " to a precision of " + precision + " = " + answer);
	}
	
	public static double babylonian(double guess, double n, double precision)
	{
		if((Math.abs(n - (guess * guess)) <= precision))
		{
			return guess;
		}
		else
		{
			return babylonian(0.5 * (guess + (n/guess)), n, precision);
		}
	}
}

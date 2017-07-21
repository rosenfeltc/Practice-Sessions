package session2Answers;

import javax.swing.JOptionPane;

public class Babylonian 
{
	public static void main(String[] args)
	{
		double n = Double.parseDouble(JOptionPane.showInputDialog("Enter n (to take square root of)"));
		double precision = Double.parseDouble(JOptionPane.showInputDialog("Enter desired precision"));
		
		JOptionPane.showMessageDialog(null, "The square root of " + n + " to " + precision + " precision is " + babylonian(n, precision));
	}
	
	public static double babylonian(double n, double precision)
	{
		return recursiveBabylonian(n, precision, n/2);
	}
	
	public static double recursiveBabylonian(double n, double precision, double guess)
	{
		if(Math.abs(n - (guess * guess)) <= precision)
		{
			return guess;
		}
		else
		{
			return recursiveBabylonian(n, precision, 0.5 *(guess + (n / guess)));
		}
	}
}

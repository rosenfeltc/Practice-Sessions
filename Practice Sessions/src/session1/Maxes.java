package session1;

import javax.swing.JOptionPane;

public class Maxes 
{
	public static void main(String[] args)
	{
		int userNumber = -1;
		int max1 = 0;
		int max2 = 0;
	
		do
		{
			userNumber = Integer.parseInt(JOptionPane.showInputDialog("Please provide a number (enter -1 to quit): "));
		
			if(userNumber > max1)
			{
				max2 = max1;
				max1 = userNumber;
			}
			else if(userNumber > max2)
			{
				max2 = userNumber;
			}
		}while(userNumber != -1);
		
		JOptionPane.showMessageDialog(null,"The maximum number from the inputted numbers is: " + max1 + "\nThe second maximum number is: " + max2);
	}
}

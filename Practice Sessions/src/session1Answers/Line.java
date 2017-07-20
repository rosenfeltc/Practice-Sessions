/*CSI213 - Practice1 - Question 2
 * Ths program receives two lines and finds their intersecting points
 */
package session1Answers;

import javax.swing.JOptionPane;

public class Line 
{
	private double slope;
	private double intercept;
	
	// A default constructor
	public Line()
	{
		this.slope = 0;
		this.intercept = 0;
	}
	
	// Overload constructor
	public Line(double a, double b)
	{
		this.slope = a;
		this.intercept = b;
	}
	
	// Overload constructor
	// The 'equation' must be in this format:
	// y = ax + b
	// Examples: y = 2 x + 3 or y = 4x or y = x
	public Line(String equation)
	{
		int i;
		String string = "";
		
		// Skip everything before '='
		for(i = 0; equation.charAt(i) != '='; i++)
		{
			;
		}
		
		// Skip '='
		i++;
		
		// Everything after '=' and before 'x' is the slope
		// Skip all white spaces
		for(;equation.charAt(i) != 'x';i++)
		{
			if(equation.charAt(i) == ' ')
			{
				continue;
			}
			
			string += equation.charAt(i);
		}
		
		// If there was nothing between '=' and 'x' then the slope is 1
		if(string.isEmpty())
		{
			string = "1";
		}
		
		// Convert String to a double
		slope = Double.parseDouble(string);
		
		// Skip the 'x' and reset 'string'
		i++;
		string = "";
		
		// Everything after the 'x' is the intercept with y axis
		for(; i < equation.length();i++)
		{
			if(equation.charAt(i) == ' ')
			{
				continue;
			}
			string += equation.charAt(i);
		}
		
		// If there is no intercept, it means that the intercept is 0
		if(string.isEmpty())
		{
			string = "0";
		}
		
		intercept = Double.parseDouble(string);
	}
	
	public double getSlope()
	{
		return slope;
	}
	
	public double getIntercept()
	{
		return intercept;
	}
	
	public void setSlope(double slope)
	{
		this.slope = slope;
	}
	
	public void setIntercept(double intercept)
	{
		this.intercept = intercept;
	}
	
	public void print()
	{
		JOptionPane.showMessageDialog(null, "y = " + slope + "x + (" + intercept + ")");
	}
	
	public void intersect(Line line)
	{
		double x;
		double y;
		
		if(slope - line.slope == 0)
		{
			JOptionPane.showMessageDialog(null, "The lines never intercept");
			return;
		}
		
		x = (this.intercept - line.intercept) / (line.slope - this.slope);
		y = this.slope * x + this.intercept;
		
		JOptionPane.showMessageDialog(null, "Two lines intercept at: (" + x + "," + y +")");
	}
	
	public static void main(String[] args)
	{
		String equation1 = new String();
		String equation2 = new String();
		
		equation1 = JOptionPane.showInputDialog("Please enter the first equation: ");
		equation2 = JOptionPane.showInputDialog("Please enter the second equation: ");
		
		Line line1 = new Line(equation1);
		Line line2 = new Line(equation2);
		
		line1.print();
		line2.print();
		
		line1.intersect(line2);
	}
}

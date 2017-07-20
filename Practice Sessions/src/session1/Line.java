package session1;

import javax.swing.JOptionPane;

public class Line 
{
	private double slope;
	private double intercept;
	private String equation;
	
	public Line()
	{
		this.slope = 0;
		this.intercept = 0;
		this.equation = "";
	}
	
	public void getUserInput()
	{
		String m = "";
		String b = "";
		int index = 0;
		
		this.equation = JOptionPane.showInputDialog("Please provide y = mx + b equation:\n");
		
		while(this.equation.charAt(index) != '=')
		{
			index++;
		}
		
		index++;
		
		while(this.equation.charAt(index) != 'x')
		{
			if(this.equation.charAt(index) == ' ')
			{
				index++;
			}
			else
			{
				m += this.equation.charAt(index);
				index++;
			}
		}
		
		index++;
		
		while(index < this.equation.length())
		{
			if(this.equation.charAt(index) == ' ')
			{
				index++;
			}
			else
			{
				b += this.equation.charAt(index);
				index++;
			}
		}
		
		this.slope = Double.parseDouble(m);
		this.intercept = Double.parseDouble(b);
	}
	
	public void findIntersection(Line line)
	{
		double x = 0;
		double y = 0;
		
		if(line.slope - this.slope == 0)
		{
			JOptionPane.showMessageDialog(null, "The lines are parallel!");
			return;
		}
		else
		{
			x = (this.intercept - line.intercept) / (line.slope - this.slope);
			y = x * this.slope + this.intercept;
			JOptionPane.showMessageDialog(null, "The lines " + this.equation + " and " + line.equation + " intersect at:\nx = " + x + "\ny = " + y);
		}
	}
	
	public static void main(String[] args)
	{
		Line equation1 = new Line();
		Line equation2 = new Line();
		equation1.getUserInput();
		equation2.getUserInput();
		equation1.findIntersection(equation2);
	}
}

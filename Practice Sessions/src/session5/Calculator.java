package session5;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame
{
	// Field
	private int operation;
	private double number1, number2;
	
	// Operation Getter
	private int getOperation()
	{
		return operation;
	}
	
	// Operation Setter
	private void setOperation(int operation)
	{
		this.operation = operation;
	}
	
	// Number1 Getter
	private double getNumber1()
	{
		return number1;
	}
	
	// Number1 Setter
	private void setNumber1(double number1)
	{
		this.number1 = number1;
	}
	
	// Number2 Getter
	private double getNumber2()
	{
		return number2;
	}
		
	// Number2 Setter
	private void setNumber2(double number2)
	{
		this.number2 = number2;
	}
	
	// Constructor
	Calculator()
	{
		operation = 0;
		number1 = 0.0;
		number2 = 0.0;
		
		// Text area?
		JTextField display = new JTextField();
		
		// Operation buttons and panel
		JPanel operations = new JPanel();
		JButton add = new JButton("+");
		JButton subtract = new JButton("-");
		JButton multiply = new JButton("*");
		JButton divide = new JButton("/");
		JButton result = new JButton("=");
		
		// Operation buttons on panel
		operations.add(add);
		operations.add(subtract);
		operations.add(multiply);
		operations.add(divide);
		operations.add(result);
		
		// Other buttons and panel
		JPanel bottom = new JPanel();
		JButton reset = new JButton("Reset");
		JButton exit = new JButton("Exit");
		
		// Other buttons on panel
		bottom.add(reset);
		bottom.add(exit);
		
		
		// Button Listeners
		add.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(getNumber1() != 0)
				{
					JOptionPane.showMessageDialog(null, "The first number was already stored!Clearing results...\nPlease try again!");
					display.setText("");
					setOperation(0);
					setNumber1(0.0);
					setNumber2(0.0);
				}
				else
				{
					setNumber1(Integer.parseInt(display.getText()));
					setOperation(1);
					display.setText("");
				}
			}
		});
		
		subtract.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(getNumber1() != 0)
				{
					JOptionPane.showMessageDialog(null, "The first number was already stored!Clearing results...\nPlease try again!");
					display.setText("");
					setOperation(0);
					setNumber1(0.0);
					setNumber2(0.0);
				}
				else
				{
					setNumber1(Integer.parseInt(display.getText()));
					setOperation(2);
					display.setText("");
				}
			}
		});
		
		multiply.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(getNumber1() != 0)
				{
					JOptionPane.showMessageDialog(null, "The first number was already stored!Clearing results...\nPlease try again!");
					display.setText("");
					setOperation(0);
					setNumber1(0.0);
					setNumber2(0.0);
				}
				else
				{
					setNumber1(Integer.parseInt(display.getText()));
					setOperation(3);
					display.setText("");
				}
			}
		});
		
		divide.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(getNumber1() != 0)
				{
					JOptionPane.showMessageDialog(null, "The first number was already stored!Clearing results...\nPlease try again!");
					display.setText("");
					setOperation(0);
					setNumber1(0.0);
					setNumber2(0.0);
				}
				else
				{
					setNumber1(Integer.parseInt(display.getText()));
					setOperation(4);
					display.setText("");
				}
			}
		});
		
		result.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(getOperation() == 0)
				{
					JOptionPane.showMessageDialog(null, "The first number was never entered!Clearing results...\nPlease try again!");
					display.setText("");
					setOperation(0);
					setNumber1(0.0);
					setNumber2(0.0);
				}
				else
				{
					setNumber2(Integer.parseInt(display.getText()));
					double answer = 0.0;
					
					switch(getOperation())
					{
						case 1:
							answer = number1 + number2;
							break;
						case 2:
							answer = number1 - number2;
							break;
						case 3:
							answer = number1 * number2;
							break;
						case 4:
							answer = number1 / number2;
							break;
					}
					
					display.setText(Double.toString(answer));
				}
			}
		});
		reset.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				display.setText("");
				setOperation(0);
				setNumber1(0.0);
				setNumber2(0.0);
			}
		});
		
		exit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		
		// Window Settings
		setLocation(500, 500);
		setSize(200,154);
		setTitle("Simple Calculator");
		add(display, BorderLayout.PAGE_START);
		add(operations, BorderLayout.CENTER);
		add(bottom, BorderLayout.PAGE_END);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}
}

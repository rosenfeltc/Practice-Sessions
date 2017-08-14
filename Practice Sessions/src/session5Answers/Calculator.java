package session5Answers;

// Import necessary Libraries/Packages
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame
{
	public static void main(String[] args)
	{
		Calculator theCalculator = new Calculator();
	}
	
	private JButton plus = new JButton("+");
	private JButton minus = new JButton("-");
	private JButton times = new JButton("*");
	private JButton divide = new JButton("/");
	private JButton equals = new JButton("=");
	private JButton exit = new JButton("Exit");
	private JButton reset = new JButton("Reset");
	private JPanel bottomButtons = new JPanel();
	private JPanel opButtons = new JPanel();
	private JTextField textField = new JTextField();
	private int operation;
	private double arg1, arg2;
	
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
	
	// Arg1 Getter
	private double getArg1()
	{
		return arg1;
	}
	
	// Arg1 Setter
	private void setArg1(double arg1)
	{
		this.arg1 = arg1;
	}
	
	// Arg2 Getter
	private double getArg2()
	{
		return arg2;
	}
	
	// Arg2 Setter
	private void setArg2(double arg2)
	{
		this.arg2 = arg2;
	}
	
	// Reset operation
	private void reset()
	{
		textField.setText("");
		setOperation(0);
	}
	
	// Constructor
	public Calculator()
	{
		bottomButtons.add(reset);
		bottomButtons.add(exit);
		
		opButtons.add(plus);
		opButtons.add(minus);
		opButtons.add(times);
		opButtons.add(divide);
		opButtons.add(equals);
		
		plus.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(getOperation() != 0)
				{
					JOptionPane.showMessageDialog(null, "Error. Resetting.");
					reset();
				}
				else
				{
					try
					{
						setArg1(Double.parseDouble(textField.getText()));
						setOperation(1);
						textField.setText("");
					}
					catch(Exception badInput)
					{
						JOptionPane.showMessageDialog(null,"Bad input. Resetting.");
						reset();
					}
				}
			}
		});
		
		minus.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(getOperation() != 0)
				{
					JOptionPane.showMessageDialog(null, "Error. Resetting.");
					reset();
				}
				else
				{	
					try
					{
						setArg1(Double.parseDouble(textField.getText()));
						setOperation(2);
						textField.setText("");
					}
					catch(Exception badInput)
					{
						JOptionPane.showMessageDialog(null, "Bad input. Resetting.");
						reset();
					}
				}
			}
		});
		
		times.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(getOperation() != 0)
				{
					JOptionPane.showMessageDialog(null, "Error. Resetting.");
					reset();
				}
				else
				{
					try
					{
						setArg1(Double.parseDouble(textField.getText()));
						setOperation(3);
						textField.setText("");
					}
					catch(Exception badInput)
					{
						JOptionPane.showMessageDialog(null, "Bad input. Resetting.");
						reset();
					}
				}
			}
		});
		
		divide.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(getOperation() != 0)
				{
					JOptionPane.showMessageDialog(null,"Error. Resetting");
					reset();
				}
				else
				{
					try
					{
						setArg1(Double.parseDouble(textField.getText()));
						setOperation(4);
						textField.setText("");
					}
					catch(Exception badInput)
					{
						JOptionPane.showMessageDialog(null, "Bad input. Resetting.");
						reset();
					}
				}
			}
		});
		
		equals.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(getOperation() == 0)
				{
					JOptionPane.showMessageDialog(null, "Error. Resetting.");
					reset();
				}
				else
				{
					try
					{
						setArg2(Double.parseDouble(textField.getText()));
					}
					catch(Exception badInput)
					{
						JOptionPane.showMessageDialog(null, "Bad input. Resetting.");
						reset();
					}
					
					switch(getOperation())
					{
						case 1:
							reset();
							textField.setText(Double.toString(getArg1() + getArg2()));
							JOptionPane.showMessageDialog(null, "Answer = " + textField.getText());
							break;
						case 2:
							reset();
							textField.setText(Double.toString(getArg1() - getArg2()));
							JOptionPane.showMessageDialog(null, "Answer = " + textField.getText());
							break;
						case 3:
							reset();
							textField.setText(Double.toString(getArg1() * getArg2()));
							JOptionPane.showMessageDialog(null, "Answer = " + textField.getText());
							break;
						case 4:
							reset();
							textField.setText(Double.toString(getArg1() / getArg2()));
							JOptionPane.showMessageDialog(null, "Answer = " + textField.getText());
							break;
					}
				}
			}
		});
		
		reset.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				reset();
			}
		});
		
		exit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
		});
		
		add(textField, BorderLayout.PAGE_START);
		add(opButtons, BorderLayout.CENTER);
		add(bottomButtons, BorderLayout.PAGE_END);
		
		setTitle("Simple Calculator");
		setSize(225, 150);
		setResizable(false);
		setLocation(new Point(500, 500));
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setVisible(true);
	}
}

package session4;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class GUI 
{
	public static final String[] OPTIONS = {"Radio Buttons", "Check Boxes", "JButtons", "Drop Down Menu", "Exit"};
	public static String theText = new String();
	
	public static void main(String[] args)
	{
		mainMenu();
	}
	
	public static void mainMenu()
	{
		int selection = JOptionPane.showOptionDialog(null, "Please select one of the following options",
				"Main Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, OPTIONS, 0);
		
		switch(selection)
		{
			case 0:
				radioButtons();
				break;
			case 1:
				checkBoxes();
				break;
			case 2:
				jButtons();
				break;
			case 3:
				dropDown();
				break;
			case 4:
				System.exit(0);
		}
	}
	
	public static void radioButtons()
	{
		// The radio buttons
		JRadioButton displayA = new JRadioButton("Display A");
		JRadioButton displayB = new JRadioButton("Display B");
		JRadioButton displayC = new JRadioButton("Display C");
		
		// Place radio buttons in a button group and on a panel
		JPanel radioPanel = new JPanel();
		ButtonGroup radio = new ButtonGroup();
		radio.add(displayA);
		radio.add(displayB);
		radio.add(displayC);
		radioPanel.add(displayA);
		radioPanel.add(displayB);
		radioPanel.add(displayC);
		
		// The JButtons on a JPanel
		JButton display = new JButton("Display");
		JButton done = new JButton("Done");
		JPanel buttons = new JPanel();
		buttons.add(display);
		buttons.add(done);

		// The JFrame Window
		JFrame window = new JFrame("Radio Buttons");
		window.setLocation(800, 500);
		window.setSize(350, 110);
		window.setResizable(false);
		window.add(radioPanel, BorderLayout.PAGE_START);
		window.add(buttons, BorderLayout.CENTER);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		display.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(displayA.isSelected())
				{
					JOptionPane.showMessageDialog(null, "You selected Display \"A\"");
				}
				else if(displayB.isSelected())
				{
					JOptionPane.showMessageDialog(null, "You selected Display \"B\"");
				}
				else if(displayC.isSelected())
				{
					JOptionPane.showMessageDialog(null, "You selected Display \"C\"");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please select one of the Radio Buttons for display to work!");
				}
			}
		});
		
		done.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				window.dispose();
				mainMenu();
			}
		});

	}
	
	public static void checkBoxes()
	{
		// The checkboxes
		JCheckBox displayA = new JCheckBox("Display A");
		JCheckBox displayB = new JCheckBox("Display B");
		JCheckBox displayC = new JCheckBox("Display C");
		
		// Add the checkboxes to a button group and a panel
		JPanel checkBoxes = new JPanel();
		ButtonGroup checks = new ButtonGroup();
		checks.add(displayA);
		checks.add(displayB);
		checks.add(displayC);
		checkBoxes.add(displayA);
		checkBoxes.add(displayB);
		checkBoxes.add(displayC);
		
		// JButtons and the JPanel
		JButton display = new JButton("Display");
		JButton done = new JButton("Done");
		JPanel buttons = new JPanel();
		buttons.add(display);
		buttons.add(done);
		
		// JFrame Window
		JFrame window = new JFrame("Check Boxes");
		window.setLocation(800, 500);
		window.setSize(350, 110);
		window.add(checkBoxes, BorderLayout.PAGE_START);
		window.add(buttons, BorderLayout.CENTER);
		window.setResizable(false);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		display.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(displayA.isSelected())
				{
					JOptionPane.showMessageDialog(null, "You selected Display A");
				}
				else if(displayB.isSelected())
				{
					JOptionPane.showMessageDialog(null, "You selected Display B");
				}
				else if(displayC.isSelected())
				{
					JOptionPane.showMessageDialog(null,  "You selected Display C");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please make a selection for display to work!");
				}
			}
		});
		
		done.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				window.dispose();
				mainMenu();
			}
		});
		
		
	}
	
	public static void jButtons()
	{
		// The JButtons
		JButton buttonA = new JButton("A");
		JButton buttonB = new JButton("B");
		JButton buttonC = new JButton("C");
		JButton clear = new JButton("Clear");
		JButton done = new JButton("Done");
		
		// The  rest of the stuff
		JLabel option = new JLabel("Press a Button!");
		JTextArea text = new JTextArea();
		text.setText(theText);
		text.setEditable(false);
		JPanel top = new JPanel();
		JPanel bottom = new JPanel();
		
		top.add(buttonA);
		top.add(buttonB);
		top.add(buttonC);
		top.add(option);
		
		bottom.add(clear);
		bottom.add(done);
		
		JFrame window = new JFrame("JButtons");
		window.setLocation(800, 500);
		window.setSize(300, 300);
		window.setResizable(false);
		window.add(top, BorderLayout.PAGE_START);
		window.add(text, BorderLayout.CENTER);
		window.add(bottom, BorderLayout.PAGE_END);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
		buttonA.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				theText += 'A';
				text.setText(theText);
			}
		});
		
		buttonB.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				theText += 'B';
				text.setText(theText);
			}
		});
		
		buttonC.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				theText += 'C';
				text.setText(theText);
			}
		});
		
		clear.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				theText = new String();
				text.setText(theText);
			}
		});
		
		done.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				window.dispose();
				mainMenu();
			}
		});
	}
	
	public static void dropDown()
	{
		// The dropdown choices
		String[] choices = {"1", "2","3"};
		
		// The dropdown box
		JComboBox dropdown = new JComboBox(choices);
		
		// The buttons
		JButton display = new JButton("Display");
		JButton done = new JButton("Done");
		JPanel buttons = new JPanel();
		buttons.add(display);
		buttons.add(done);
		
		// The window
		JFrame window = new JFrame("Drop Down Menu");
		window.setLocation(800, 500);
		window.setSize(300, 100);
		window.add(dropdown, BorderLayout.CENTER);
		window.add(buttons, BorderLayout.PAGE_END);
		window.setResizable(false);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		display.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(dropdown.getSelectedItem().toString().equals(Integer.toString(1)))
				{
					JOptionPane.showMessageDialog(null, "You selected 1");
				}
				else if(dropdown.getSelectedItem().toString().equals(Integer.toString(2)))
				{
					JOptionPane.showMessageDialog(null, "You selected 2");
				}
				else if(dropdown.getSelectedItem().toString().equals(Integer.toString(3)))
				{
					JOptionPane.showMessageDialog(null, "You selected 3");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please make a selection on the dropdown first!");
				}
			}
		});
		
		done.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				window.dispose();
				mainMenu();
			}
		});
	}
}

package session3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MenuWindow extends JFrame 
{
	static final String[] OPTIONS = {"Open File", "Display List", "Search", "Exit"};
	static LinkedList theList = new LinkedList();
	
	private MenuWindow(String content)
	{
		JTextArea text = new JTextArea(content);
		JScrollPane scrollPane = new JScrollPane(text);
		
		setSize(500, 500);
		setTitle("The List");
		add(scrollPane);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
	
	public static void main(String[] args)
	{
		mainMenu();
	}
	
	public static void mainMenu()
	{
		int selection = JOptionPane.showOptionDialog(null, "Please make a selection", "Main Menu", JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, OPTIONS, 0);
		
		switch(selection)
		{
			case 0:
				JFileChooser fileChooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Text", "txt");
				fileChooser.setFileFilter(filter);
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				fileChooser.showOpenDialog(fileChooser);
				File toOpen = fileChooser.getSelectedFile();
				
				try
				{
					Scanner fileScanner = new Scanner(toOpen);
					
					while(fileScanner.hasNextLine())
					{
						int number = fileScanner.nextInt();
						theList.add(number);
					}
					
					fileScanner.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
				
				mainMenu();
				break;
			case 1:
				MenuWindow window = new MenuWindow(theList.display());
				break;
			case 2:
				int toSearch = Integer.parseInt(JOptionPane.showInputDialog("What number would you like to search for in the list?"));
				
				if(theList.search(toSearch))
				{
					JOptionPane.showMessageDialog(null, "The number " + toSearch + " was found in the list!");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "The number " + toSearch + " was not found in the list!");
				}
				
				mainMenu();
				break;
			case 3:
				System.exit(0);
				break;
		}
	}
}

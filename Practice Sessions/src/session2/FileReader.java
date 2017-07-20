package session2;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class FileReader 
{
	public static void main(String[] args)
	{
		JFileChooser fileChooser = new JFileChooser();
		
		fileChooser.showOpenDialog(null);
		
		File theFile = fileChooser.getSelectedFile();
		String fromFile;
		int counter = 0;
		
		try
		{
			Scanner fileScanner = new Scanner(theFile);
			
			while(fileScanner.hasNext())
			{
				fromFile = fileScanner.nextLine();
				counter++;
			}
			fileScanner.close();
		}
		catch(IOException e)
		{
			JOptionPane.showMessageDialog(null, "Error opening file! Exiting Program");
			System.exit(0);
		}
		
		JOptionPane.showMessageDialog(null, "The file " + theFile + " has " + counter + " lines in it!");
	}
}

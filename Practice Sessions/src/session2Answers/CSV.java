package session2Answers;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class CSV 
{
	public static void main(String[] args)
	{
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Comma Separated Value", "csv");
		int counter = 0;
		String theString = "";
		
		fileChooser.setFileFilter(filter);
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		int result = fileChooser.showOpenDialog(fileChooser);
		
		File toOpen = fileChooser.getSelectedFile();
		
		try
		{
			Scanner fileScanner = new Scanner(toOpen);
			while(fileScanner.hasNextLine())
			{
				counter++;
				theString += fileScanner.nextLine() + "\n";
			}
			
			fileScanner.close();
		}
		catch(IOException e)
		{
			JOptionPane.showMessageDialog(null, "Error opening file! Exiting program...");
			System.exit(0);
		}
		
		JOptionPane.showMessageDialog(null, "The file " + toOpen.getAbsolutePath() + " has " + counter + " lines.");
		
		theString = theString.replace(" ", ",");
		System.out.print(theString);
		
	}
}

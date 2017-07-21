package session2;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class Question6 
{
	public static void main(String[] args)
	{
		File openFile = new File("");
		File saveFile = new File("");
		String fromFile = new String();
		mainMenu(openFile, saveFile, fromFile);
	}
	
	public static void mainMenu(File openFile, File saveFile, String fromFile)
	{
		String[] options = {"Open File", "Modify File", "Save File", "Exit"};
		JFileChooser fileChooser = new JFileChooser();
		
		int optionChosen = JOptionPane.showOptionDialog(null, "Please choose an option", "Main Menu", 0, 1, null, options, 0);
		
		switch(optionChosen)
		{
		case 0:
			fileChooser.showOpenDialog(fileChooser);
			openFile = fileChooser.getSelectedFile();
			try
			{
				Scanner fileScanner = new Scanner(openFile);
				
				while(fileScanner.hasNext())
				{
					fromFile += fileScanner.nextLine() + "\n";
				}
				
				fileScanner.close();
			}
			catch(IOException e)
			{
				JOptionPane.showMessageDialog(null, "Error opening file! Exiting Program");
				System.exit(1);
			}
			mainMenu(openFile, saveFile, fromFile);
			break;
		case 1:
			fileChooser.showOpenDialog(fileChooser);
			openFile = fileChooser.getSelectedFile();
			int index;
			String modifiedFile = "";
			
			try
			{
				Scanner fileScanner = new Scanner(openFile);
				
				while(fileScanner.hasNext())
				{
					index = 0;
					fromFile = fileScanner.nextLine();
					while(fromFile.charAt(index) != ' ')
					{
						modifiedFile += fromFile.charAt(index);
						index++;
					}
					modifiedFile += ",";
					modifiedFile += fromFile.substring(index + 1, fromFile.length());
					modifiedFile += "\n";
				}
				fileScanner.close();
				fromFile = modifiedFile;
			}
			catch(IOException e)
			{
				JOptionPane.showMessageDialog(null, "Unable to modify the file");
			}
			
			mainMenu(openFile, saveFile, fromFile);
			break;
		case 2:
			fileChooser.showSaveDialog(fileChooser);
			saveFile = fileChooser.getSelectedFile();
			String tempName = saveFile.toString();
			tempName += ".csv";
			saveFile = new File(tempName);
			
			try
			{
				PrintWriter theWriter = new PrintWriter(saveFile);
				theWriter.println(fromFile);
				theWriter.close();
			}
			catch(IOException e)
			{
				JOptionPane.showMessageDialog(null, "Error writing to file!");
			}
			mainMenu(openFile, saveFile, fromFile);
			break;
			
		case 3:
			System.exit(0);
			break;
		}
	}
}

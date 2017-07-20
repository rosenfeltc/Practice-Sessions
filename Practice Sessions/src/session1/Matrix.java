package session1;

import javax.swing.JOptionPane;

public class Matrix
{
	private int[][] matrix;
	
	public Matrix(int row, int column)
	{
		matrix = new int[row][column];
	}
	
	public void getUserInput()
	{
		for(int i = 0; i < this.matrix.length; i++)
		{
			for(int j = 0; j < this.matrix[0].length; j++)
			{
				this.matrix[i][j] = Integer.parseInt(JOptionPane.showInputDialog("Please provide the number located at row " + (i+1) + 
						", column " + (j+1)));
			}
		}
	}
	
	public void matrixMultiplication(Matrix a)
	{
		String answer = "";
		
		if(this.matrix[0].length != a.matrix.length)
		{
			JOptionPane.showMessageDialog(null, "The matrix multiplication is undefined for the two matrices provided!");
			return;
		}
		
		int[][] result = new int[this.matrix.length][a.matrix[0].length];
		
		for(int i = 0; i < this.matrix.length; i++)
		{
			for(int j = 0; j < a.matrix[0].length; j++)
			{
				for(int k = 0; k < a.matrix.length; k++)
				{
					result[i][j] += this.matrix[i][k] * a.matrix[k][j];
				}
			}
		}
		
		for(int i = 0; i < result.length; i++)
		{
			for(int j = 0; j < result[0].length; j++)
			{
				answer += result[i][j] + "  ";
			}
			answer += "\n";
		}
		
		JOptionPane.showMessageDialog(null, answer);
	}
	
	public static void main(String[] args)
	{
		int row1 = Integer.parseInt(JOptionPane.showInputDialog("Please provide number of rows for first matrix: "));
		int column1 = Integer.parseInt(JOptionPane.showInputDialog("Please provide number of columns for first matrix: "));
		Matrix matrix1 = new Matrix(row1, column1);
		matrix1.getUserInput();
		
		int row2 = Integer.parseInt(JOptionPane.showInputDialog("Please provide number of rows for second matrix: "));
		int column2 = Integer.parseInt(JOptionPane.showInputDialog("Please provide number of columns for second matrix: "));
		Matrix matrix2 = new Matrix(row2, column2);
		matrix2.getUserInput();
		
		matrix1.matrixMultiplication(matrix2);
	}
}

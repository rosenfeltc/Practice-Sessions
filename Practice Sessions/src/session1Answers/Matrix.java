/* CSI 213 - Practice1 - Question 5
 * Matrix multiplication
 * This program multiplies two matrices
 */
package session1Answers;

public class Matrix {
	private double[][] data;
	private int rows;
	private int cols;
	private static final int maxNumber = 10;
	private static final int minNumber = 0;
	
	public Matrix(int rows, int cols)
	{
		this.rows = (rows >= 1) ? rows : 1;
		this.cols = (cols >= 1) ? cols: 1;
		allocateMemory();
		resetData();
	} // end constructor
	
	// Allocate space for a two dimensional array
	public void allocateMemory()
	{
		data = new double[rows][];
		
		for(int i = 0; i < rows; i++)
		{
			data[i] = new double[cols];
		}
	}
	
	// Set all elements to zero
	public void resetData()
	{
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < cols; j++)
			{
				data[i][j] = 0;
			}
		}
	} // end resetData method
	
	// Populate the matrix with some random numbers
	public void randomize()
	{
		double randomNumber;
		
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < cols; j++)
			{
				// Random numbers must be between minNumber and maxNumber
				randomNumber = minNumber + Math.random() * (maxNumber - minNumber);
				randomNumber = Math.floor(randomNumber);
				data[i][j] = randomNumber;
			}
		}
	}
	
	// Print the matrix
	public void print()
	{
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < cols; j++)
			{
				System.out.print(data[i][j] + " ");
			}
			System.out.print("\n");
		}
	}
	
	// Multiply two matrices
	public Matrix multiply(Matrix multiplier)
	{
		// Create a matrix for result
		// Make sure dimensions are right
		Matrix result = new Matrix(this.rows, multiplier.cols);
		
		// If the dimensions do not match, terminate the operation
		if(this.cols != multiplier.rows)
		{
			System.out.println("Cannot multiply these two matrices.");
			return result;
		}
		
		// Multiply two matrices
		for(int i = 0; i < this.rows; i++)
		{
			for(int j = 0; j < multiplier.cols; j++)
			{
				for(int k = 0; k < this.cols; k++)
				{
					result.data[i][j] += data[i][k] * multiplier.data[k][j];
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args)
	{
		Matrix matrix1 = new Matrix(2, 3);
		Matrix matrix2 = new Matrix(3, 5);
		Matrix result = new Matrix(1, 1);
		matrix1.randomize();
		matrix2.randomize();
		matrix1.print();
		matrix2.print();
		result = matrix1.multiply(matrix2);
		result.print();
	}
}

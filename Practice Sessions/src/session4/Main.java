package session4;

import java.util.Random;

public class Main
{
	public static void main(String[] args)
	{
		BinarySearchTree theTree = new BinarySearchTree();
		Random generator = new Random(50);
		
		for(int i = 0; i < 50; i++)
		{
			theTree.insert(generator.nextInt() % 501);
		}

		System.out.println("**************************************");
		System.out.println("The number 14 is in the tree: " + theTree.searchResult(14));
		System.out.println("**************************************");
		theTree.inOrder();
		theTree.delete(60);
		System.out.println("**************************************");
		theTree.postOrder();
		theTree.delete(-454);
		theTree.delete(-481);
		theTree.delete(-498);
		theTree.delete(496);
		System.out.println("**************************************");
		theTree.preOrder();
		System.out.println("**************************************");
		theTree.destroy();
		theTree.inOrder();
	}
}
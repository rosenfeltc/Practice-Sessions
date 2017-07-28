package session3;

public class Main
{
	public static void main(String[] args)
	{
		LinkedList newList = new LinkedList();
		
		for(int i = 1; i <= 25; i++)
		{
			if(i % 7 == 0)
			{
				newList.deleteFirst();
			}
			else
			{
				newList.add(i);
			}
		}
		
		System.out.println("The number 1 is in the list: " + newList.search(1));
		System.out.println("The number 7 is in the list: " + newList.search(7));
		System.out.println("**************************************");
		newList.print();
		System.out.println("**************************************");
		newList.deleteFirst();
		newList.deleteFirst();
		newList.print();
		System.out.println("**************************************");
		System.out.println("Size of the list: " + newList.size());
		newList.destroyList();
		newList.print();
	}
}

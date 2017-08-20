package session6;

public class Main
{
	public static void main(String[] args)
	{
		Queue theQueue = new Queue(5, 2);
		
		try
		{
			theQueue.enqueue(5);
			theQueue.enqueue(3.3);
			theQueue.enqueue(2.5);
			theQueue.enqueue(7);
			theQueue.enqueue(9);
			System.out.println("************************");
			theQueue.print();
			System.out.println("************************");
			theQueue.enqueue(1);
			theQueue.enqueue(2);
			System.out.println("************************");
			theQueue.print();
			System.out.println("************************");
			System.out.println("I removed " + theQueue.dequeue());
			System.out.println("************************");
			theQueue.print();
			System.out.println("************************");
			System.out.println("************************");
			theQueue.enqueue(9);
			theQueue.print();
			theQueue.enqueue(45);
		}
		catch(QueueException e)
		{
			System.out.println(e.getProblem());
		}
		
		System.out.println("I will still print even if I hit an error!");
	}
}

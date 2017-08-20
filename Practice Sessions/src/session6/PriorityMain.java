package session6;

public class PriorityMain
{
	public static void main(String[] args)
	{
		PriorityQueue theQueue = new PriorityQueue(5);
		
		try
		{
			theQueue.enqueue("Lily", 2);
			theQueue.enqueue("Christopher", 1);
			theQueue.enqueue("Stranger", 3);
			theQueue.enqueue("Amanda", 1);
			theQueue.enqueue("Rex", 2);
			theQueue.print();
			System.out.println("******************************");
			System.out.println("I removed: " + theQueue.dequeue());
			System.out.println("******************************");
			theQueue.print();
			System.out.println("******************************");
			System.out.println("I removed: " + theQueue.dequeue());
			System.out.println("I removed: " + theQueue.dequeue());
			System.out.println("******************************");
			theQueue.print();
			System.out.println("******************************");
			theQueue.enqueue("Lily", 2);
			theQueue.enqueue("Christopher", 1);
			theQueue.enqueue("Unknown", 5);
			theQueue.print();
			
		}
		catch(QueueException e)
		{
			System.out.println(e.getProblem());
		}
		
		System.out.println("\n");
		System.out.println("I've reached the end, regardless of any issues");
	}
}

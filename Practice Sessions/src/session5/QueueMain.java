package session5;

public class QueueMain
{
	public static void main(String[] args)
	{
		Queue theQueue = new Queue();
		
		theQueue.enqueue("Chris");
		theQueue.print();
		theQueue.enqueue("Amanda");
		theQueue.enqueue("Rex");
		theQueue.enqueue("Lily");
		theQueue.print();
		theQueue.dequeue();
		System.out.println(theQueue.peek());
		theQueue.dequeue();
		theQueue.print();
		theQueue.dequeue();
		theQueue.dequeue();
		theQueue.print();
		theQueue.dequeue();
	}
}

package session5Answers;

public class StackQueueTest
{
	public static void main(String[] args)
	{
		Stack theStack = new Stack();
		Queue theQueue = new Queue();
		
		for(int i = 0; i < 10; i++)
		{
			theStack.push(i);
			theQueue.enqueue(i);
		}
		
		System.out.println("**********************************");
		System.out.println("Stack contents:");
		theStack.print();
		System.out.println("**********************************");
		System.out.println("Queue contents:");
		theQueue.print();
	}
}
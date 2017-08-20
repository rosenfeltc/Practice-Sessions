package session6answers;

public class QueueTest
{
	public static void main( String[] args )
	{
		QueueWithBuffer myQueue = new QueueWithBuffer( 5,  2 );
		myQueue.enqueue( 10 );
		myQueue.enqueue( 60 );
		myQueue.enqueue( 40 );
		myQueue.enqueue( 10 );
		myQueue.enqueue( 90 );
		myQueue.print();
		myQueue.enqueue( 80 );
		myQueue.enqueue( 20 );
		//myQueue.enqueue( 30 );
		myQueue.dequeue();
		myQueue.print();
		myQueue.dequeue();
		myQueue.print();
		
	} // end method main
	
} // end method QueueTest

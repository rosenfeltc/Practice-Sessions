package session6answers;

public class QueueWithBuffer 
{
	private Queue queue;
	private Queue buffer;
	
	public QueueWithBuffer( final int queueMaxSize, final int bufferMaxSize )
	{
		queue = new Queue( queueMaxSize );
		buffer = new Queue( bufferMaxSize );
	} // end method constructor
	
	public int peek()
	{
		return queue.peek();
	} // end method peek
	
	public boolean isFull()
	{
		return queue.isFull();
	} // end method isFull
	
	public boolean isEmpty()
	{
		return queue.isEmpty();
	} // end method is Empty
	
	public void print()
	{
		queue.print();
	} // end method print
	
	public void enqueue( final int data )
	{
		if( queue.isFull() == false )
		{
			queue.enqueue( data );
			return;
		}
		
		System.out.println( "Queue is full. Writing into the buffer..." );
		buffer.enqueue( data );
	} // end method enqueue
	
	public int dequeue()
	{
		if( buffer.isEmpty() )
			return queue.dequeue();

		int data = queue.dequeue();
		queue.enqueue( buffer.dequeue() );
		return data;
	} // end method dequeue
} // end class QueueWithBuffer

package session6answers;

public class Queue 
{
	private int maxSize;
	private int size;
	private Node front;
	private Node back;
	
	public Queue( final int maxSize )
	{
		size = 0;
		front = null;
		back = null;
		setMaxSize( maxSize );
	} // end constructor
	
	public void setMaxSize( final int size )
	{
		maxSize = ( size >= 1 ) ? size : 1;
	} // end method setMaxSize
	
	public boolean isFull()
	{
		return ( size >= maxSize );
	} // end method isFull
	
	public boolean isEmpty()
	{
		return ( size <= 0 );
	} // end method isEmpty
	
	public void incrementSize()
	{
		size++;
		
		size = ( size < maxSize ) ? size : maxSize;
	} // end method incrementSize
	
	public void decrementSize()
	{
		size--;
		
		size = ( size >= 0 ) ? size : 0;
		
		if( size == 0 )
			destroyQueue();
	} // end method decrementSize
	
	public void enqueue( final int data )
	{	
		if( isFull() )
		{
			System.out.printf( "Failed to enqueue! The queue is full.\n" );
			return;
		}
		
		Node newNode = new Node( data );		
		newNode.setPrevious( front );
		
		if( size > 0 )
			front.setNext( newNode );
		
		else
			setBack( newNode );			
		
		setFront( newNode );
		
		incrementSize();
		
	} // end method enqueue
	
	public int dequeue()
	{
		int data;
		
		if( isEmpty() )
		{
			System.out.printf( "No entry to dequeu. The queue is empty! Returning 0 by default.\n" );
			return 0;		
		}
		
		data = front.getData();
		setFront( front.getPrevious() );
		
		if( front != null )
			front.setNext( null );
		
		decrementSize();
		
		return data;				
	} // end method dequeue
	
	public int peek()
	{
		if( isEmpty() )
			return 0; 
		
		return getFront().getData();
	} // end method peek
	
	public void print()
	{
		Node temp = new Node();
		temp = getBack();
		int data;
		
		while( temp != null )
		{
			data = temp.getData();
			temp = temp.getNext();
			System.out.printf( "%d  ", data );
		} // end method while
		
		System.out.println("");
		
	} // end method print
	
	public void setFront( final Node front )
	{
		this.front = front;
	} // end method setFront
	
	public void setBack( final Node back )
	{
		this.back = back;
	} // end method setBack
	
	public Node getBack()
	{
		return back;
	} // end method getBack
	
	public Node getFront()
	{
		return front;
	} // end method getFront
	
	public int getSize()
	{
		return size;
	} // end method getSize
	
	public void destroyQueue()
	{
		setBack( null );
		size = 0;
		setFront( null );
	} // end method destroyQueue
} // end class Queue

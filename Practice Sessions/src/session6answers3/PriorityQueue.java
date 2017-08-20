package session6answers3;

public class PriorityQueue 
{	
	private int maxSize;
	private int length;
	private Node front;
	private Node back;
	
	public PriorityQueue( final int maxSize )
	{
		setFront( null );
		setBack( null );
		setLength( 0 );
		setMaxSize( maxSize );
	} // end constructor method
	
	public Node findHighestPriorityNode()
	{
		if( isEmpty() )
			return null;
		
		Node temp = new Node();
		Node maxPriority = new Node();
		
		maxPriority = getFront();
		temp = maxPriority.getPrevious();
		
		while( temp != null )
		{			
			if( temp.getPriority() > maxPriority.getPriority() )
				maxPriority = temp;
			
			temp = temp.getPrevious();
		} // end while
		
		return maxPriority;
		
	} // end method findHighestPriorityNode
	
	public int dequeue()
	{
		if( isEmpty() )
			return 0;
		
		Node temp = new Node();
		int data;
		
		temp = findHighestPriorityNode();
		data = temp.getData();
		
		if( temp.getPrevious() != null )
			temp.getPrevious().setNext( temp.getNext() );
		
		if( temp.getNext() != null )
			temp.getNext().setPrevious( temp.getPrevious() );
		
		if( getBack() == temp )
			setBack( temp.getNext() );
		
		if( getFront() == temp )
			setFront( temp.getPrevious() );
		
		if( getLength() == 1 )
		{
			destroy();
			return data;
		}
		
		setLength( getLength() - 1 );
		return data;
		
	} // end method dequeue
	
	public void enqueue( final int data, final int priority )
	{
		if( isFull() )
		{
			System.out.println( "Failed to add the entery to the tree. It is full.\n" );
			return;
		}
		
		Node newNode = new Node( data, priority );
		newNode.setPrevious( getFront() );
		
		if( getFront() != null )
			getFront().setNext( newNode );
		
		if( getBack() == null )
			setBack( newNode );			
		
		setFront( newNode );
		
		setLength( getLength() + 1 );
	} // end method enqueue
	
	public void print()
	{
		Node temp = new Node();
		temp = getBack();
		
		while( temp != null )
		{
			System.out.print( temp.getData() + "  " );
			temp = temp.getNext();
		} // end while
		
		System.out.println( "" );
	} // end method print
	
	public boolean isFull()
	{
		if( getLength() >= getMaxSize() )
			return true;
		
		return false;
	} // end method isFull
	
	public boolean isEmpty()
	{
		if( getLength() <= 0 )
			return true;
		
		return false;
	} // end method isEmpty
	
	public void destroy()
	{
		setFront( null );
		setBack( null );
		setLength( 0 );
	} // end method destroy
	
	public int getMaxSize()
	{
		return maxSize;
	} // end method getMaxSize
	
	public int getLength()
	{
		return length;
	} // end method getLength
	
	public Node getFront()
	{
		return front;
	} // end method getFront
	
	public Node getBack()
	{
		return back;
	} // end method getBack
	
	public void setMaxSize( final int maxSize )
	{
		this.maxSize = ( maxSize >= 1 ) ? maxSize : 1;
	} // end method setMaxSize
	
	public void setLength( final int length )
	{
		this.length = ( length >= 0 && length <= maxSize ) ? length : 0;
	} // end method setLength'

	public void setFront( final Node front )
	{
		this.front = front;
	} // end method setFront
	
	public void setBack( final Node back )
	{
		this.back = back; 
	} // end method setBack
	
} // end PriorityQueue

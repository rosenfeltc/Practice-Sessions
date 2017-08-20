package session6answers3;

public class Node 
{
	private int priority;
	private int data;
	private Node next;
	private Node previous;
	
	public Node()
	{
		next = null;
		previous = null;
		setData( 0 );
		setPriority( 0 );
	} // end constructor
	
	public Node( final int data, final int priority )
	{
		next = null;
		previous = null;
		setData( data );
		setPriority( priority );
	} // end constructor
	
	public int getPriority()
	{
		return priority;
	} // end method getPriority
	
	public int getData()
	{
		return data;
	} // end method getData
	
	public Node getNext()
	{
		return next;
	} // end method getNext
	
	public Node getPrevious()
	{
		return previous;
	} // end method getPrevious
	
	public void setPriority( final int priority )
	{
		this.priority = ( priority >= 0 ) ? priority : 0; 
	} // end method setPriority
	
	public void setData( final int data )
	{
		this.data = data;
	} // end method setData
	
	public void setNext( final Node next )
	{
		this.next = next;
	} // end method setNext
	
	public void setPrevious( final Node previous )
	{
		this.previous = previous;
	} // end method setPrevious
} // end class Node

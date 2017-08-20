package session6answers;

public class Node
{
	private int data;
	private Node next;
	private Node previous;
		
	public Node()
	{
		data = 0;
		next = null;
		previous = null;
	} // end constructor Node
		
	public Node( final int data )
	{
		setData( data );
		next = null;
		previous = null;
	} // end constructor Node
		
	public void setData( final int data )
	{
		this.data = data;
	} // end method setData
		
	public int getData()
	{
		return data;
	} // end method getData
		
	public void setNext( final Node next )
	{
		this.next = next;
	} // end method setNext
	
	public Node getNext()
	{
		return next;
	} // end method getNext
	
	public void setPrevious( final Node previous )
	{
		this.previous = previous;
	} // end method setPrevious
	
	public Node getPrevious()
	{
		return previous;
	} // end method getPrevious
		
} // end class Node
	
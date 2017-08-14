package session5;

import java.util.EmptyStackException;

public class Queue
{
	private Node top;
	private Node bottom;
	
	// Constructor
	public Queue()
	{
		top = null;
		bottom = null;
	}
	
	// Top Getter
	private Node getTop()
	{
		return top;
	}
	
	// Top Setter
	private void setTop(Node top)
	{
		this.top = top;
	}
	
	// Bottom Getter
	public Node getBottom()
	{
		return bottom;
	}
	
	// Bottom Setter
	public void setBottom(Node bottom)
	{
		this.bottom = bottom;
	}
	
	// Is Empty?
	private boolean isEmpty()
	{
		return getTop() == null;
	}
	
	// Enqueue
	public void enqueue(String name)
	{
		Node newNode = new Node(name);
		
		if(isEmpty())
		{
			setTop(newNode);
			setBottom(newNode);
		}
		else
		{
			newNode.setPrevious(getBottom());
			bottom.setNext(newNode);
			setBottom(newNode);
		}
	}
	
	// Dequeue
	public String dequeue() throws EmptyStackException
	{
		if(isEmpty())
		{
			throw new EmptyStackException();
		}
		
		String temp = new String();
		
		if(getTop() == getBottom())
		{
			temp = getTop().getName();
			setTop(null);
			setBottom(null);
		}
		else
		{
			temp = getTop().getName();
			getTop().getNext().setPrevious(null);
			setTop(getTop().getNext());
		}
		
		return temp;
	}
	
	// Peek
	public String peek()
	{
		if(isEmpty())
		{
			return "Queue is empty!\nNothing to return!";
		}
		
		return getTop().getName();
	}
	
	// Print
	public void print()
	{
		if(isEmpty())
		{
			System.out.println("Queue is empty!\nNothing to print!");
			return;
		}
		
		Node traverse = getTop();
		
		System.out.println("-->" + getTop().getName());
		traverse = traverse.getNext();
		
		while(traverse != null)
		{
			System.out.println("   " + traverse.getName());
			traverse = traverse.getNext();
		}
		
		System.out.println("--------------------");
	}
	
	// Destroy
	public void destroy()
	{
		setTop(null);
		setBottom(null);
	}
	
	// Private Node Class
	private class Node
	{
		private String name;
		private Node next;
		private Node previous;
		
		// Constructor
		private Node(String name)
		{
			this.name = name;
			next = null;
			previous = null;
		}
		
		// Name getter
		private String getName()
		{
			return name;
		}
		
		// Next Getter
		private Node getNext()
		{
			return next;
		}
		
		// Next Setter
		private void setNext(Node next)
		{
			this.next = next;
		}
		
		// Previous Getter
		private Node getPrevious()
		{
			return previous;
		}
		
		// Previous Setter
		private void setPrevious(Node previous)
		{
			this.previous = previous;
		}
	}
}

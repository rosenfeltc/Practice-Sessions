package session5;

import java.util.EmptyStackException;

public class Stack
{
	private Node top;
	
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
	
	// Is Stack empty?
	private boolean isEmpty()
	{
		return getTop() == null;
	}
	
	// Push method
	public void push(String name)
	{
		Node newNode = new Node(name);
		
		if(isEmpty())
		{
			setTop(newNode);
		}
		else
		{
			newNode.setNext(getTop());
			setTop(newNode);
		}
	}
	
	// Pop method
	public String pop() throws EmptyStackException
	{
		if(isEmpty())
		{
			throw new EmptyStackException();
		}
		
		String temp = getTop().getName();
		setTop(getTop().getNext());
		
		return temp;
	}
	
	// Peek
	public String peek() throws EmptyStackException
	{
		if(isEmpty())
		{
			throw new EmptyStackException();
		}
		
		return getTop().getName();
	}
	
	// Print
	public void print()
	{
		if(isEmpty())
		{
			System.out.println("The list is empty! Nothing to print!");
			return;
		}
		
		Node traverse = getTop();
		System.out.println("-->" + traverse.getName());
		traverse = traverse.getNext();
		
		while(traverse != null)
		{
			System.out.println("   " + traverse.getName());
			traverse = traverse.getNext();
		}
		
		System.out.println("------------------------------");
	}
	
	// Destroy
	public void destroy()
	{
		setTop(null);
	}
	
	private class Node
	{
		// Field
		private String name;
		private Node next;
		
		// Constructor
		private Node(String name)
		{
			this.name = name;
			next = null;
		}
		
		// Name Getter
		private String getName()
		{
			return name;
		}
		
		// Name Setter
		private void setName(String name)
		{
			this.name = name;
		}
		
		// Next Getter
		private Node getNext()
		{
			return this.next;
		}
		
		// Next Setter
		private void setNext(Node next)
		{
			this.next = next;
		}
	}
}

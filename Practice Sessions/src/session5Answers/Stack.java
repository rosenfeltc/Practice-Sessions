package session5Answers;

public class Stack
{
	private Node top;
	
	// Constructor
	public Stack()
	{
		top = null;
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
	
	// Is empty?
	private boolean isEmpty()
	{
		return getTop() == null;
	}
	
	// Get the current size of the stack
	public int size()
	{
		int counter = 0;
		
		Node sizer = getTop();
		
		while(sizer != null)
		{
			counter++;
			sizer = sizer.getNext();
		}
		
		return counter;
	}
	
	// Push Method
	public void push(int data)
	{
		Node newNode = new Node(data);
		
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
	
	// Peek method
	public int peek()
	{
		if(isEmpty())
		{
			return 0;
		}
		else
		{
			return getTop().getData();
		}
	}
	
	public int pop()
	{
		int temp;
		
		if(isEmpty())
		{
			return 0;
		}
		
		temp = getTop().getData();
		setTop(getTop().getNext());
		
		return temp;
	}
	
	public void print()
	{
		if(isEmpty())
		{
			System.out.println("Stack is empty!");
		}
		else
		{
			Node printer = getTop();
			
			while(printer!= null)
			{
				System.out.println(printer.getData());
				printer = printer.getNext();
			}
		}
	}
	
	public void destroy()
	{
		setTop(null);
	}
	
	private class Node
	{
		private int data;
		private Node next;
		
		// Constructor
		private Node(int data)
		{
			this.data = data;
			next = null;
		}
		
		// Data Getter
		private int getData()
		{
			return data;
		}
		
		// Data Setter
		private void setData(int data)
		{
			this.data = data;
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
	}
}

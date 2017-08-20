package session6;

public class PriorityQueue
{
	// Fields
	private Node front, back;
	private int maxSize, size;
	
	// Constructor
	public PriorityQueue(int maxSize)
	{
		front = null;
		back = null;
		this.maxSize = maxSize;
		size = 0;
	}
	
	// Enqueue method
	public void enqueue(String name, int priority) throws QueueException
	{
		if(size == maxSize)
		{
			throw new QueueException(1);
		}
		
		Node newNode = new Node(name, priority);
		
		if(size == 0)
		{
			front = newNode;
			back = newNode;
		}
		else
		{
			Node traverser = front;
			
			while(traverser != null && newNode.priority < traverser.priority)
			{
				traverser = traverser.next;
			}
			
			if(traverser == null)
			{
				back.next = newNode;
				newNode.previous = back;
				back = newNode;
			}
			else if(traverser == front)
			{
				traverser.previous = newNode;
				newNode.next = traverser;
				front = newNode;				
			}
			else
			{
				newNode.previous = traverser.previous;
				newNode.next = traverser;
				traverser.previous.next = newNode;
				traverser.previous = newNode;
			}
		}
		
		size++;
	}
	
	// Dequeue method
	public String dequeue() throws QueueException
	{
		if(size == 0)
		{
			throw new QueueException(2);
		}
		
		String temp = back.name;
		
		if(size == 1)
		{
			front = null;
			back = null;
		}
		else
		{
			back.previous.next = null;
			back = back.previous;
		}
		
		size--;
		
		return temp;
	}
	
	// Peek method
	public String peek() throws QueueException
	{
		if(size == 0)
		{
			throw new QueueException(3);
		}
		
		return back.name;
	}
	
	// Print method
	public void print()
	{
		if(size == 0)
		{
			System.out.println("Priority Queue is empty!");
			return;
		}
		
		Node traverser = back;
		
		while(traverser != null)
		{
			System.out.println(traverser.name + ", priority: " + traverser.priority);
			traverser = traverser.previous;
		}
	}
	
	// Is Empty
	public boolean isEmpty()
	{
		return size == 0;
	}
	
	// Is Full
	public boolean isFull()
	{
		return size == maxSize;
	}
	
	// Destroy
	public void destroy()
	{
		front = null;
		back = null;
		size = 0;
	}
	
	private class Node
	{
		// Fields
		private String name;
		private int priority;
		private Node next, previous;
		
		// Constructor
		private Node(String name, int priority)
		{
			this.name = name;
			this.priority = priority;
			next = null;
			previous = null;
		}
	}
}

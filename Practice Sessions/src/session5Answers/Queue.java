package session5Answers;

public class Queue
{
	private Node front;
	private Node back;
	
	// Constructor
	public Queue()
	{
		front = null;
		back = null;
	}
	
	// Front Getter
	private Node getFront()
	{
		return front;
	}
	
	// Front Setter
	private void setFront(Node front)
	{
		this.front = front;
	}
	
	// Back Getter
	private Node getBack()
	{
		return back;
	}
	
	// Back Setter
	private void setBack(Node back)
	{
		this.back = back;
	}
	
	// Is Empty?
	public boolean isEmpty()
	{
		return getFront() == null;
	}
	
	// Current Size of queue
	public int size()
	{
		int counter = 0;
		
		Node sizer = getFront();
		
		while(sizer != null)
		{
			counter++;
			sizer = sizer.getNext();
		}
		
		return counter;
	}
	
	// Enqueue method
	public void enqueue(int data)
	{
		Node newNode = new Node(data);
		
		if(isEmpty())
		{
			setFront(newNode);
		}
		else if(size() == 1)
		{
			setBack(newNode);
			getBack().setPrevious(getFront());
			getFront().setNext(getBack());
		}
		else
		{
			newNode.setPrevious(getBack());
			getBack().setNext(newNode);
			setBack(newNode);
		}
	}
	
	// Dequeue method
	public int dequeue()
	{
		int temp;
		
		if(isEmpty())
		{
			return 0;
		}
		else if(size() == 1)
		{
			temp = getFront().getData();
			destroy();
			return temp;
		}
		else
		{
			temp = getFront().getData();
			getFront().getNext().setPrevious(null);
			setFront(getFront().getNext());
			return temp;
		}
	}
	
	public int peek()
	{
		if(isEmpty())
		{
			return 0;
		}
		else if(size() == 1)
		{
			return getFront().getData();
		}
		else
		{
			return getFront().getData();
		}
	}
	
	public void print()
	{
		if(isEmpty())
		{
			System.out.println("Queue is empty.");
		}
		else
		{
			Node printer = getFront();
			
			while(printer != null)
			{
				System.out.println(printer.getData());
				printer = printer.getNext();
			}
		}
	}
	
	public void destroy()
	{
		setFront(null);
		setBack(null);
	}
	private class Node
	{
		private int data;
		private Node next;
		private Node previous;
		
		// Constructor
		private Node(int data)
		{
			this.data = data;
			next = null;
			previous = null;
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

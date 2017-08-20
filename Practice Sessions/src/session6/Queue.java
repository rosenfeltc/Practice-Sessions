package session6;

public class Queue
{
	// Fields
	private Node front, back, bufferFront, bufferBack;
	private int maxSize, size, bufferMaxSize, bufferSize;

	// Constructor
	public Queue(int max1, int max2)
	{
		maxSize = max1;
		bufferMaxSize = max2;
		size = 0;
		bufferSize = 0;
		front = null;
		back = null;
		bufferFront = null;
		bufferBack = null;
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

	// MaxSize Getter
	private int getMaxSize()
	{
		return maxSize;
	}

	// Size Getter
	private int getSize()
	{
		return size;
	}

	// Size Incrementer
	private void incrementSize()
	{
		size++;
	}

	// Size Decrementer
	private void decrementSize()
	{
		size--;
	}

	// Size Setter
	private void setSize(int size)
	{
		this.size = size;
	}

	// Buffer Front Getter
	private Node getBufferFront()
	{
		return bufferFront;
	}

	// Buffer Front Setter
	private void setBufferFront(Node front)
	{
		bufferFront = front;
	}

	// Buffer Back Getter
	private Node getBufferBack()
	{
		return bufferBack;
	}

	// Back Setter
	private void setBufferBack(Node back)
	{
		bufferBack = back;
	}

	// Buffer MaxSize Getter
	private int getBufferMaxSize()
	{
		return bufferMaxSize;
	}

	// Size Getter
	private int getBufferSize()
	{
		return bufferSize;
	}

	// Buffer Size Incrementer
	private void incrementBufferSize()
	{
		bufferSize++;
	}

	// Size Decrementer
	private void decrementBufferSize()
	{
		bufferSize--;
	}

	// Buffer Size Setter
	private void setBufferSize(int size)
	{
		bufferSize = size;
	}

	// Enqueue
	public void enqueue(double data) throws QueueException
	{
		if (getSize() == getMaxSize())
		{
			bufferEnqueue(data);
			return;
		}

		Node newNode = new Node(data);
		
		if (getSize() == 0)
		{
			front = newNode;
			back = newNode;
		}
		else
		{
			getFront().setPrevious(newNode);
			newNode.setNext(getFront());
			setFront(newNode);
		}

		incrementSize();
	}

	// Buffer Enqueue
	private void bufferEnqueue(double data) throws QueueException
	{
		if(getBufferSize() == getBufferMaxSize())
		{
			throw new QueueException(1);
		}
		
		Node newNode = new Node(data);
		
		if(getBufferSize() == 0)
		{
			setBufferFront(newNode);
			setBufferBack(newNode);
		}
		else
		{
			getBufferFront().setPrevious(newNode);
			newNode.setNext(getBufferFront());
			setBufferFront(newNode);
		}
		
		incrementBufferSize();
	}
	
	// Dequeue
	public double dequeue() throws QueueException
	{
		if (getSize() == 0)
		{
			throw new QueueException(2);
		}

		double temp = getBack().getData();

		if (getSize() == 1)
		{
			setFront(null);
			setBack(null);
		}
		else
		{
			getBack().getPrevious().setNext(null);
			setBack(getBack().getPrevious());
		}

		decrementSize();
		
		if(getBufferSize() != 0)
		{
			enqueue(bufferDequeue());
		}
		
		return temp;
	}

	private double bufferDequeue()
	{
		double temp = getBufferBack().getData();
		
		if(getBufferSize() == 1)
		{
			setBufferFront(null);
			setBufferBack(null);
		}
		else
		{
			getBufferBack().getPrevious().setNext(null);
			setBufferBack(getBufferBack().getPrevious());
		}
		
		decrementBufferSize();
		
		return temp;
	}
	
	// Peek method
	public double peek() throws QueueException
	{
		if (getSize() == 0)
		{
			throw new QueueException(3);
		}

		double temp = getBack().getData();

		return temp;
	}

	public void print()
	{
		System.out.println("The main queue:");
		print(getBack());
		System.out.println("The queue buffer:");
		print(getBufferBack());
	}
	// Print method
	private void print(Node start)
	{
		if (start == null)
		{
			System.out.println("Is empty!");
		}

		while (start != null)
		{
			System.out.println(start.getData());
			start = start.getPrevious();
		}
	}

	// Is empty method
	public boolean isEmpty()
	{
		return getSize() == 0;
	}

	// Is full method
	public boolean isFull()
	{
		return getSize() == getMaxSize();
	}

	// Destroy Method
	public void destroy()
	{
		setFront(null);
		setBack(null);
		setBufferFront(null);
		setBufferBack(null);
		setSize(0);
		setBufferSize(0);
	}

	// Node class
	private class Node
	{
		// Fields
		private double data;
		private Node next, previous;

		// Constructor
		private Node(double data)
		{
			this.data = data;
			next = null;
			previous = null;
		}

		// Data Getter
		private double getData()
		{
			return data;
		}

		// Data Setter
		private void setData(double data)
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

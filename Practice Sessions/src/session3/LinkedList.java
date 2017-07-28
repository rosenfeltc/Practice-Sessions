package session3;

public class LinkedList
{
	private class Node
	{
		private int data;
		private Node next;
		
		private Node(int data)
		{
			this.data = data;
			this.next = null;
		}
		
		private void setData(int data)
		{
			this.data = data;
		}
		
		private int getData()
		{
			return this.data;
		}
		
		private void setNext(Node next)
		{
			this.next = next;
		}
		
		private Node getNext()
		{
			return this.next;
		}
	}
	
	private Node root;
	
	private void setRoot(Node root)
	{
		this.root = root;
	}
	
	private Node getRoot()
	{
		return this.root;
	}
	
	public boolean isEmpty()
	{
		return getRoot() == null;
	}
	
	public int size()
	{
		// IMPLEMENT THIS METHOD
		int counter = 0;
		Node traverse = getRoot();
		
		while(traverse != null)
		{
			traverse = traverse.getNext();
			counter++;
		}
		
		return counter;
	}
	
	public void add(int data)
	{
		// IMPLEMENT THIS METHOD
		Node newNode = new Node(data);
		
		if(isEmpty())
		{
			setRoot(newNode);
		}
		else
		{
			newNode.setNext(getRoot());
			setRoot(newNode);
		}
	}
	
	public boolean search(int data)
	{
		// IMPLEMENT THIS METHOD
		Node traverse = getRoot();
		
		while(traverse != null)
		{
			if(traverse.getData() == data)
			{
				return true;
			}
			
			traverse = traverse.getNext();
		}
		
		return false;
	}
	
	public void deleteFirst()
	{
		// IMPLEMENT THIS METHOD
		if(isEmpty())
		{
			System.out.println("The list is empty! Nothing to delete!");
		}
		else
		{
			setRoot(getRoot().getNext());
		}
	}
	
	public void destroyList()
	{
		// IMPLEMENT THIS METHOD
		setRoot(null);
	}
	
	public void print()
	{
		if(isEmpty())
		{
			System.out.println("The list is empty so there is nothing to print!");
			return;
		}
		
		// IMPLEMENT THIS METHOD
		Node traverse = getRoot();
		
		while(traverse != null)
		{
			System.out.println(traverse.getData());
			traverse = traverse.getNext();
		}
	}
	
	public String display()
	{
		// New method
		Node traverse = getRoot();
		String theString = new String();
		
		while(traverse != null)
		{
			theString += traverse.getData() + "\n";
			traverse = traverse.getNext();
		}
		
		return theString;
	}
}
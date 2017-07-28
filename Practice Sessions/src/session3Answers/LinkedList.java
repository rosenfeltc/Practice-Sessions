package session3Answers;

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
	
	private Node root = null;
	
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
		int counter = 0;
		
		if(isEmpty())
		{
			return counter;
		}
		
		else
		{
			Node sizer = getRoot();
			
			while(sizer != null)
			{
				counter++;
				sizer = sizer.getNext();
			}
		}
		
		return counter;
	}
	
	public void add(int data)
	{
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
		if(isEmpty())
		{
			return false;
		}
		else
		{
			Node searcher = getRoot();
			
			while(searcher != null)
			{
				if(data == searcher.getData())
				{	
					return true;
				}
				else
				{
					searcher = searcher.getNext();
				}
			}
		}
		
		return false;
	}
	
	public void deleteFirst()
	{
		setRoot(getRoot().getNext());
	}
	
	public void destroyList()
	{
		setRoot(null);
	}
	
	public void print()
	{
		if(isEmpty())
		{
			System.out.println("List is empty!");
		}
		else
		{
			Node printer = getRoot();
			
			while(printer != null)
			{
				System.out.print(printer.getData() + " ");
				printer = printer.getNext();
			}
			System.out.println("");
		}
	}
}

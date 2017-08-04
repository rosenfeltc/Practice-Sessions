package session4;

public class BinarySearchTree
{
	private class Node
	{
		private int data;
		private int counter;
		private Node leftChild;
		private Node rightChild;
		private Node parent;
		
		private Node(int data)
		{
			this.data = data;
			this.counter = 1;
			this.leftChild = null;
			this.rightChild = null;
			this.parent = null;
		}
		
		private void incrementCounter()
		{
			this.counter++;
		}
		
		private void setData(int data)
		{
			this.data = data;
		}
		
		private int getData()
		{
			return this.data;
		}
		
		private void setLeftChild(Node leftChild)
		{
			this.leftChild = leftChild;
		}
		
		private Node getLeftChild()
		{
			return this.leftChild;
		}
		
		private void setRightChild(Node rightChild)
		{
			this.rightChild = rightChild;
		}
		
		private Node getRightChild()
		{
			return this.rightChild;
		}
		
		private void setParent(Node parent)
		{
			this.parent = parent;
		}
		
		private Node getParent()
		{
			return this.parent;
		}
		
		private int getCounter()
		{
			return this.counter;
		}
	}
	
	private Node root;
	
	private Node getRoot()
	{
		return this.root;
	}
	
	private void setRoot(Node root)
	{
		this.root = root;
	}
	
	public boolean isEmpty()
	{
		return getRoot() == null;
	}
	
	public void insert(int data)
	{
		Node newNode = new Node(data);
		
		if(isEmpty())
		{
			setRoot(newNode);
		}
		else
		{
			insert(newNode, getRoot());
		}
	}
	
	public void insert(Node n, Node r)
	{
		// IMPLEMENT THIS METHOD ** RECURSIVELY **
		// HINT !!! REMEMBER TO "setParent()" !!!
		if(n.getData() == r.getData())
		{
			r.incrementCounter();
		}
		else if(n.getData() < r.getData())
		{
			if(r.getLeftChild() == null)
			{
				r.setLeftChild(n);
				n.setParent(r);
			}
			else
			{
				insert(n, r.getLeftChild());
			}
		}
		else
		{
			if(r.getRightChild() == null)
			{
				r.setRightChild(n);
				n.setParent(r);
			}
			else
			{
				insert(n, r.getRightChild());
			}
		}
	}
	
	public boolean searchResult(int data)
	{
		Node searchIt = search(data);
		
		if(searchIt != null)
			return true;
		
		return false;
	}
	
	public Node search(int data)
	{
		// IMPLEMENT THIS METHOD
		Node traverse = getRoot();
		
		while(traverse != null)
		{
			if(data == traverse.getData())
			{
				return traverse;
			}
			else if(data < traverse.getData())
			{
				traverse = traverse.getLeftChild();
			}
			else
			{
				traverse = traverse.getRightChild();
			}
		}
		
		return null;
	}
	
	public void delete(int data)
	{
		// IMPLEMENT THIS METHOD
		// HINT !!!! USE THE SEARCH METHOD TO HELP YOU
		Node reference = search(data);
		
		if(reference == null)
		{
			System.out.println("Unable to delete the Node!");
			return;
		}
		if(reference == getRoot())
		{
			if(reference.getLeftChild() == null && reference.getRightChild() == null)
			{
				setRoot(null);
			}
			else if(reference.getLeftChild() == null)
			{
				setRoot(reference.getRightChild());
				reference.getRightChild().setParent(null);
			}
			else if(reference.getRightChild() == null)
			{
				setRoot(reference.getLeftChild());
				reference.getLeftChild().setParent(null);
			}
			else
			{
				Node spot = findMinimum(reference.getRightChild());
				reference.setData(spot.getData());
				
				if(spot.getRightChild() == null)
				{
					if(spot.getParent().getLeftChild() == spot)
					{
						spot.getParent().setLeftChild(null);
					}
					else
					{
						spot.getParent().setRightChild(null);
					}
				}
				else
				{
					if(spot.getParent().getLeftChild() == spot)
					{
						spot.getRightChild().setParent(spot.getParent());
						spot.getParent().setLeftChild(spot.getRightChild());
					}
					else
					{
						spot.getRightChild().setParent(spot.getParent());
						spot.getParent().setRightChild(spot.getRightChild());
					}
				}
			}
		}
		else
		{
			if(reference.getLeftChild() == null && reference.getRightChild() == null)
			{
				if(reference.getParent().getLeftChild() == reference)
				{
					reference.getParent().setLeftChild(null);
				}
				else
				{
					reference.getParent().setRightChild(null);
				}
			}
			else if(reference.getLeftChild() == null)
			{
				if(reference.getParent().getLeftChild() == reference)
				{
					reference.getRightChild().setParent(reference.getParent());
					reference.getParent().setLeftChild(reference.getRightChild());
				}
				else
				{
					reference.getRightChild().setParent(reference.getParent());
					reference.getParent().setRightChild(reference.getRightChild());
				}
			}
			else if(reference.getRightChild() == null)
			{
				if(reference.getParent().getLeftChild() == reference)
				{
					reference.getLeftChild().setParent(reference.getParent());
					reference.getParent().setLeftChild(reference.getLeftChild());
				}
				else
				{
					reference.getLeftChild().setParent(reference.getParent());
					reference.getParent().setRightChild(reference.getLeftChild());
				}
			}
			else
			{
				Node spot = findMinimum(reference.getRightChild());
				reference.setData(spot.getData());
				
				if(spot.getRightChild() == null)
				{
					if(spot.getParent().getLeftChild() == spot)
					{
						spot.getParent().setLeftChild(null);
					}
					else
					{
						spot.getParent().setRightChild(null);
					}
				}
				else
				{
					if(spot.getParent().getLeftChild() == spot)
					{
						spot.getRightChild().setParent(spot.getParent());
						spot.getParent().setLeftChild(spot.getRightChild());
					}
					else
					{
						spot.getRightChild().setParent(spot.getParent());
						spot.getParent().setRightChild(spot.getRightChild());
					}
				}
			}
		}
	}
	
	public void inOrder()
	{
		if(isEmpty())
		{
			System.out.println("Tree is empty!");
		}
		else
		{
			inOrder(getRoot());
		}
	}
	
	public void inOrder(Node n)
	{
		// IMPLEMENT THIS METHOD ** RECURSIVELY **
		if(n != null)
		{
			inOrder(n.getLeftChild());
			System.out.println(n.getData() + " " + n.getCounter());
			inOrder(n.getRightChild());
		}
	}
	
	public void preOrder()
	{
		if(isEmpty())
		{
			System.out.println("Tree is empty!");
		}
		else
		{
			preOrder(getRoot());
		}
	}
	
	public void preOrder(Node n)
	{
		// IMPLEMENT THIS METHOD ** RECURSIVELY **
		if(n != null)
		{
			System.out.println(n.getData() + " " + n.getCounter());
			preOrder(n.getLeftChild());
			preOrder(n.getRightChild());
		}
	}
	
	public void postOrder()
	{
		if(isEmpty())
		{
			System.out.println("Tree is empty!");
		}
		else
		{
			postOrder(getRoot());
		}
	}
	
	public void postOrder(Node n)
	{
		// IMPLEMENT THIS METHOD ** RECURSIVELY **
		if(n != null)
		{
			postOrder(n.getLeftChild());
			postOrder(n.getRightChild());
			System.out.println(n.getData() + " " + n.getCounter());
		}
	}
	
	public Node findMinimum(Node n)
	{
		// IMPLEMENT THIS METHOD ** EITHER** RECURSIVELY OR ITERATIVELY
		if(n.getLeftChild() == null)
		{
			return n;
		}
		else
		{
			return findMinimum(n.getLeftChild());
		}
	}

	public void destroy()
	{
		// IMPLEMENT THIS METHOD
		setRoot(null);
	}
}

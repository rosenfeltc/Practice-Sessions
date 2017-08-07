package session4Answers;

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
		if(n.getData() == r.getData()) // the data to insert EQUALS "current" data
		{
			r.incrementCounter();
		}
		else if(n.getData() < r.getData()) // the data to insert goes to the LEFT of "current" data
		{
			if(r.getLeftChild() == null) // if left is unoccupied
			{
				r.setLeftChild(n);
				n.setParent(r);
			}
			else // left is occupied
			{
				insert(n, r.getLeftChild());
			}
		}
		else // the data to insert goes to the RIGHT of "current" data
		{
			if(r.getRightChild() == null) // if right is unoccupied
			{
				r.setRightChild(n);
				n.setParent(r);
			}
			else // right is occupied
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
		if(isEmpty())
			return null;
		else
			return search(getRoot(), data);
	}
	
	public Node search(Node r, int data)
	{
		if(r == null)
			return null;
		if(data == r.getData())
			return r;
		else if(data < r.getData())
			return search(r.getLeftChild(), data);
		else if(data > r.getData())
			return search(r.getRightChild(), data);
		else
			return null;
	}
	
	public void delete(int data)
	{
		Node toDelete = search(data);
		
		if(toDelete == null) // if the data to delete does not exist in the tree
			return;
		
		if(toDelete == getRoot()) // if you're deleting the root
		{
			if(getRoot().getLeftChild() == null && getRoot().getRightChild() == null)
			{
				destroy();
			}
			else if(getRoot().getLeftChild() != null && getRoot().getRightChild() == null)
			{
				setRoot(getRoot().getLeftChild());
			}
			else if(getRoot().getLeftChild() == null && getRoot().getRightChild() != null)
			{
				setRoot(getRoot().getRightChild());
			}
			else
			{
				Node theMinimum = findMinimum(getRoot().getRightChild());
				int tempData = getRoot().getData();
				getRoot().setData(theMinimum.getData());
				theMinimum.setData(tempData);
				
				if(theMinimum.getParent().getLeftChild() == theMinimum)
				{
					theMinimum.getParent().setLeftChild(null);
				}
				else
				{
					theMinimum.getParent().setRightChild(null);
				}
			}
		}
		else // it's not the root, it's somewhere else in the tree
		{
			if(toDelete.getLeftChild() == null && toDelete.getRightChild() == null)
			{
				if(toDelete.getParent().getLeftChild() == toDelete)
				{
					toDelete.getParent().setLeftChild(null);
				}
				else
				{
					toDelete.getParent().setRightChild(null);
				}
			}
			else if(toDelete.getLeftChild() != null && toDelete.getRightChild() == null)
			{
				if(toDelete.getParent().getLeftChild() == toDelete)
				{
					toDelete.getParent().setLeftChild(toDelete.getLeftChild());
				}
				else
				{
					toDelete.getParent().setRightChild(toDelete.getLeftChild());
				}
			}
			else if(toDelete.getLeftChild() == null && toDelete.getRightChild() != null)
			{
				if(toDelete.getParent().getLeftChild() == toDelete)
				{
					toDelete.getParent().setLeftChild(toDelete.getRightChild());
				}
				else
				{
					toDelete.getParent().setRightChild(toDelete.getRightChild());
				}
			}
			else
			{
				Node minimum = findMinimum(toDelete.getRightChild());
				int temp = toDelete.getData();
				toDelete.setData(minimum.getData());
				minimum.setData(temp);
				
				if(minimum.getParent().getLeftChild() == minimum)
				{
					minimum.getParent().setLeftChild(null);
				}
				else
				{
					minimum.getParent().setRightChild(null);
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
		if(n != null)
		{
			inOrder(n.getLeftChild());
			System.out.println(n.getData());
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
		if(n != null)
		{
			System.out.println(n.getData());
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
		if(n != null)
		{
			postOrder(n.getLeftChild());
			postOrder(n.getRightChild());
			System.out.println(n.getData());
		}
	}
	
	public Node findMinimum(Node n)
	{
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
		setRoot(null);
	}
}
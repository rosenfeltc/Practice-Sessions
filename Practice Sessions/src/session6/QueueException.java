package session6;

public class QueueException extends Exception
{
	// Field
	private String problem;
	
	// Constructor
	public QueueException(int code)
	{
		switch(code)
		{
			case 1:
				problem = "The queue is full! Unable to enqueue.";
				break;
			case 2:
				problem = "The queue is empty! Unable to dequeue.";
				break;
			case 3:
				problem = "The queue is empty! Unable to peek.";
				break;
			case 4:
				problem = "The queue is empty! Unable to print.";
				break;
		}
	}
	
	public String getProblem()
	{
		return problem;
	}
}

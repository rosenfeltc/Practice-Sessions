package session6answers3;

public class Tester 
{
	public static void main( String[] args )
	{
		PriorityQueue q = new PriorityQueue( 5 );
		q.enqueue( 10, 10);
		q.enqueue( 20, 30);
		q.enqueue( 30, 30);
		q.enqueue( 40, 4);
		q.dequeue();
		q.print();
		q.dequeue();
		q.print();
	} // end method main
	
} // end class Tester


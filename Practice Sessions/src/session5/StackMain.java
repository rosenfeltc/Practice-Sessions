package session5;

public class StackMain
{
	public static void main(String[] args)
	{
		Stack theStack = new Stack();
		
		theStack.push("Chris");
		theStack.push("Andrew");
		theStack.print();
		theStack.pop();
		theStack.print();
		theStack.pop();
		theStack.print();
		theStack.push("Mario");
		theStack.push("Luigi");
		System.out.println("Peekaboo --> " + theStack.peek());
		theStack.print();
		theStack.push("Princess");
		theStack.print();
		theStack.destroy();
		theStack.print();
		
	}
}

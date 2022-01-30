import java.util.Scanner;

class StackImplement
{
	// store elements of stack
	private int arr[];
	// represent top of stack
	private int top;
	// total capacity of the stack
	private int capacity;
	// Creating a stack

	StackImplement(int size)
	{
		// initialize the array
		// initialize the stack variables
		arr = new int[size];
		capacity = size;
		top = -1;
	}

	// push elements to the top of stack
	public void push(int x)
	{
		if (isFull())
		{
			System.out.println("\nStack OverFlow");
			// terminates the program
			System.exit(1);
		}
		// insert element on top of stack
		System.out.println("\nInserting " + x);
		arr[++top] = x;
	}

	// pop elements from top of stack
    public int pop()
    {
		// if stack is empty
	    // no element to pop
	    if (isEmpty())
		{
			System.out.println("\nSTACK EMPTY");
			// terminates the program
            System.exit(1);
		}
		// pop element from top of stack
	    return arr[top--];
	}

	// return size of the stack
    public int getSize()
    {
		return top + 1;
	}
	// check if the stack is empty
	public Boolean isEmpty()
	{
		return top == -1;
	}
	// check if the stack is full
    public Boolean isFull()
    {
		return top == capacity - 1;
	}

	// display elements of stack
    public void printStack()
    {
		for (int i = 0; i <= top; i++)
		{
			System.out.print(arr[i] + ", ");
		}
	}

	public static void main(String[] args)
	{
		StackImplement stack = new StackImplement(5);
		Scanner sc = new Scanner(System.in);
		int inputNumber;
		while(true)
		{
			System.out.println("\n\nPress 1 :for push the element ");
			System.out.println("Press 2 :for pop the element ");
			System.out.println("Press 3 :for print the element of stack ");
			System.out.println("Press 4 :for Exit ");
			System.out.println("\t\t\tEnter you choice:");
			switch (inputNumber=sc.nextInt())
			{
				case 1:
					int i=sc.nextInt();
					stack.push(i);
					stack.printStack();
					break;
			    case 2:
					stack.pop();
					stack.printStack();
					break;
				case 3 :
					stack.printStack();
					break;
				case 4:
					System.exit(0);
			}
		}
		sc.close();
	}
}
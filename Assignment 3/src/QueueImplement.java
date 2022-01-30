import java.util.Scanner;

class QueueImplement
{
	private static int front, rear, capacity;
	private static int queue[];

	QueueImplement(int size)
	{
		front = rear = 0;
        capacity = size;   
        queue = new int[capacity];   
    }   

	// insert an element into the queue
	void queueEnqueue(int item)
	{
		// check if the queue is full
        if (capacity == rear)
		{
			System.out.printf("\nQueue is full\n");
			return;
		}
		// insert element at the rear
		else
		{
			queue[rear] = item;
            rear++;   
        }
		return;
	}

	//remove an element from the queue
	void queueDequeue()
	{
		// check if queue is empty
        if (front == rear)
		{
			System.out.printf("\nQueue is empty\n");
			return;
		}
		// shift elements to the right by one place uptil rear
        else
		{
			for (int i = 0; i < rear - 1; i++)
			{
				queue[i] = queue[i + 1];
            }
			// set queue[rear] to 0
            if (rear < capacity)
				queue[rear] = 0;
			// decrement rear
            rear--;
		}
        return;   
    }

	// print queue elements
	void queueDisplay()
	{
		int i;
		if (front == rear)
		{
			System.out.printf("Queue is Empty");
			return;
		}
		// traverse front to rear and print elements
		for (i = front; i < rear; i++)
		{
			System.out.printf(" %d , ", queue[i]);
        }   
        return;
	}

	// print front of queue
	void queueFront()
	{
		if (front == rear)
		{
			System.out.printf("Queue is Empty");
			return;
		}
		System.out.printf("\nFront Element of the queue: %d", queue[front]);
		return;
	}

	public static void main(String[] args)
	{
		// Create a queue of capacity 4
    	QueueImplement q = new QueueImplement(4);
		System.out.println("Initial Queue:");
		// print Queue elements
		q.queueDisplay();
		Scanner sc = new Scanner(System.in);
		int inputNumber;
		while(true)
		{
			System.out.println("\n\nOngoing Session...\n ");
			System.out.println("\nPress 1 :for add the element ");
			System.out.println("Press 2 :for delete the element ");
			System.out.println("Press 3 :for print the element of queue ");
			System.out.println("Press 4 :for print the front element of queue ");
			System.out.println("Press 5 :for Exit ");
			System.out.println("\t\t\tEnter you choice:");
			switch (inputNumber=sc.nextInt())
			{
				case 1:
					int i=sc.nextInt();
					q.queueEnqueue(i);
					q.queueDisplay();
					break;
				case 2:
					q.queueDequeue();
					q.queueDisplay();
					break;
				case 3 :
					q.queueDisplay();
					break;
				case 4 :
					q.queueFront();
					break;
				case 5:
					System.out.println("Session Ended ");System.exit(0);
			}
		}
		sc.close();
	}
}
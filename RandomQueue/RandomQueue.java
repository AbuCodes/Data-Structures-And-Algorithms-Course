import java.util.LinkedList;
import java.util.Queue;

public class RandomQueue
{
	public static void main(String[] args)
	{
		//Initialize our linked list
		Queue<Integer> i = new LinkedList<>();

		// Adds elements {0, 1, 2, 3, 4,5,6} to queue
		for (int p = 0; p < 7; p++)
			i.add(p);

		// Display all contents of the queue
		System.out.println("The elements in the que before random removal: " + i);

		// To remove the elements head of queue.
		int removedele = i.remove();
		System.out.println("removed element: " + removedele);
		System.out.println(i);

		// To view the elements head of queue
		int head = i.peek();
		System.out.println("head of queue: " + head);

		// Like size and contains can be used with this
		// implementation.
		int size = i.size();
		System.out.println("Size of queue: " + size);
	}
}
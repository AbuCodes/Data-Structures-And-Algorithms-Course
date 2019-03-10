import java.util.Scanner;

/**
 * This Demo class its the user prompt controller and demos the solution to the
 * user by showing the functionality of the different methods in our program.
 **/

public class Demo {

	public static void main(String[] args) {
		int choice, element, elementPriority;
		Scanner scan = new Scanner(System.in);

		PriorityQueueL pq = new PriorityQueueL();

		while (true) {
			System.out.println("1. add(x) - Insert a new element with its priority");
			System.out.println("2. deleteMin() - Delete minimum priority element");
			System.out.println("3. size() - Display the size");
			System.out.println("4. Quit");
			System.out.println("Enter your choice: ");
			choice = scan.nextInt();

			if (choice == 4) {
				break;
			}

			switch (choice) {
			case 1:
				System.out.println("Enter the element to be inserted: ");
				element = scan.nextInt();
				System.out.println("Enter its priority: ");
				elementPriority = scan.nextInt();
				pq.add(element, elementPriority);
				pq.Display();
				break;

			case 2:
				System.out.println("Deleted element is " + pq.deleteMin());
				pq.Display();
				break;

			case 3:
				System.out.println("The size of the Queue is : " + pq.size());
				pq.Display();
				break;

			default:
				System.out.println("Choice is invalid.");
			}
		}
		scan.close();
	}
}

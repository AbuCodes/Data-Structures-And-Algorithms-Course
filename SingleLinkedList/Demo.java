import java.util.Scanner;

/**
 * This Demo class its the user prompt controller and demos the solution to the
 * user by showing the functionality of the different methods in our program.
 **/

public class Demo {

	public static void main(String[] args) {
		int choice, data, k, x;

		Scanner scan = new Scanner(System.in);

		SingleLinkedList List = new SingleLinkedList();

		List.createList();

		while (true) {
			System.out.println("1. displayList() - Display all the node in the list.");
			System.out.println("2. swapTwoNodes(x) - Swap the selected node with the node on the right of it.");
			System.out.println("3. Quit");
			System.out.println("Enter your choice: ");
			choice = scan.nextInt();

			if (choice == 4) {
				break;
			}

			switch (choice) {
			case 1:
				System.out.println("Display the list");
				List.displayList();
				break;

			case 2:
				System.out.println("Enter element to be swapped");
				x = scan.nextInt();
				List.swapTwoNodes(x);
				break;

			case 3:
				break;

			default:
				System.out.println("Choice is invalid.");
			}
		}
		scan.close();
	}
}

import java.util.Scanner;

public class DoubleLinkedList {
	private Node start;

	// This constructor initializes our double linked list.
	public DoubleLinkedList() {
		start = null;
	}

	// Method displayList loops through each node in our double linked list and
	// displays of each node. It traverses through the list by keeping reference
	// pointer p while setting while moving it self to the next link at each
	// Iteration of the loop
	public void displayList() {
		Node p;

		if (start == null) {
			System.out.println("List is empty");
		}

		p = start;
		System.out.println("List is : ");
		while (p != null) {
			System.out.print(p.info + " ");
			p = p.next;
		}
		System.out.println();
	}// End of displayList()

	// This method is used when we initial don't have any elements in our list
	// It works by creating a new temp node and setting the setting the start
	// Reference pointer to it
	public void insertInEmptyList(int data) {
		Node temp = new Node(data);
		start = temp;
	}

	// This method inserts a new element at the end of the list by traversing
	// through the list in the same way the displayList() method does to find the
	// null value node and insert the new element at that point of reference
	public void insertAtEnd(int data) {
		Node temp = new Node(data);

		Node p = start;
		while (p.next != null) {
			p = p.next;
		}
		p.next = temp;
		temp.prev = p;
	}

	// The method reverse() reverses the list by the links it is a little bit more
	// interesting than just doing it by the value
	// We do this by keeping two pointers p1 and p2 referenced and we loop through
	// the list reversing each .next link with .prev until we reach the end of the
	// list to which we set our new start value and terminate the method
	public void reverse() {

		if (start == null) {
			return;
		}

		Node p1 = start;
		Node p2 = p1.next;
		p1.next = null;
		p1.prev = p2;

		while (p2 != null) {

			p2.prev = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = p2.prev;

		}
		start = p1;
	}

	// The method createList() Is for simplicity when creating the list for the
	// user. It utilizes the methods we already created to make it easier for the
	// user when creating there new list.
	public void createList() {
		int i, n, data;

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter number of nodes to be inserted: ");
		n = scan.nextInt();

		if (n == 0) {
			return;
		}

		System.out.print("Enter the first element to be inserted: ");
		data = scan.nextInt();
		insertInEmptyList(data);

		for (i = 1; i < n; i++) {
			System.out.println("Enter the next item to be inserted: ");
			data = scan.nextInt();
			insertAtEnd(data);
		}
	}
}

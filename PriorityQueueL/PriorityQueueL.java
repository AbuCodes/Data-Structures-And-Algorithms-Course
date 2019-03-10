import java.util.NoSuchElementException;

/* In this class we implement our Single Linked List Priority Queue in which we have the three main methods
 * 
 * add(x) - Adds our element to the Queue by its priority since this is a priority queue interface.
 * deleteMin() - Deletes the highest priority element in our List which is always the first element as well.
 * size() - Returns the amount of elements in our list
 * 
 * Other methods:
 * For debugging and user prompter purposes we also have the method
 * Display - Which simply displays all the elements in the list with there given priority.
 */

public class PriorityQueueL {
	// This will be incremented when we add a node and decremented if we can or do
	// delete a node.
	private static int size;

	// This pointer will always refer to the first node of the list
	private Node front;

	// Here we are initializing the Queue to null which means that the Queue will be
	// empty
	public PriorityQueueL() {
		front = null;
	}

	// Adds the specified element to the list .
	public void add(int element, int elementPriority) {
		Node temp, p;

		temp = new Node(element, elementPriority);
		// Queue is empty or element to be added has priority more than first element
		if (isEmpty() || elementPriority < front.priority) {
			temp.link = front;
			front = temp;
			size++;
		} else {
			p = front;
			while (p.link != null && p.link.priority <= elementPriority) {
				p = p.link;
			}
			temp.link = p.link;
			p.link = temp;
			size++;
		}
	}

	// This method deletes the minimum value or more simply the first item in our
	// list
	public int deleteMin() {
		int element;
		if (isEmpty()) {
			System.out.println("Queue Underflow");
			throw new NoSuchElementException();
		} else {
			element = front.info;
			front = front.link;
			size--;
		}
		return element;
	}

	// This method checks if the list is empty
	public boolean isEmpty() {
		return (front == null);
	}

	// This method size() returns the size of our list
	public int size() {
		return size;
	}

	// The main purpose of this function is to for user debug purposes
	// It will display all of the elements in the queue with there priority
	public void Display() {
		Node p = front;

		if (isEmpty()) {
			System.out.println("Queue is empty \n");
		} else {
			System.out.println("Queue is : ");
			System.out.println("Element Priority");
			while (p != null) {
				System.out.println(p.info + "         " + p.priority);
				p = p.link;
			}
		}
		System.out.println("");
	}
}
/**
 * Runtime of Add(T) in worst case is O(n), in Expected cases is O(n) and in
 * Best cases is O(1). Runtime of Add(T,After) in worst case is O(n), in
 * Expected cases is O(n) and in Best cases is O(1). Runtime of deleteFront() in
 * worst case is O(n), in Expected cases is O(n) and in Best cases is O(1).
 * Runtime of deleteAfter(T after) in worst case is O(n), in Expected cases is
 * O(n) and in Best cases is O(1).
 * 
 * 
 * Explanation: Runtime of any operation in cases will be O(n) because we need
 * to find the node at which we wish to perform that operation. If we keep the
 * pointer at the list's tail, then only we will can get the optimized runtime
 * result upon the operation as O(1). Otherwise, if pointer is not at list's
 * tail, then its runtime for that operation will be O(n).
 */

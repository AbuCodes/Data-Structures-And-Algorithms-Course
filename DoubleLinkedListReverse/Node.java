//This is our double linked list constructor for each node it keeps track of three variables prev info and next
//prev is the pointer to our previous node
//info is the value of our current node
//next is the pointer to our next node
public class Node {
	public Node prev;
	public int info;
	public Node next;

	// This method Node() initializes our node and setting info to our given value
	// of i
	public Node(int i) {
		info = i;
		prev = null;
		next = null;
	}
}

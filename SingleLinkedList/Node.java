//This is our Node constructor that defines each node for our Single Linked List
//info is the stored value of our list
//link is the pointer reference to our next node
public class Node {
	public int info;
	public Node link;

	// This Node(i) method initializes our node and sets the value of info with the
	// given value of i
	public Node(int i) {
		info = i;
		link = null;
	}
}

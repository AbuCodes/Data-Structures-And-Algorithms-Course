//This is the constructor that implements each node of our Priority Queue Interface
//priority stores the the priority of our node
//info stores the value of our node
//link is the the pointer to the next node
public class Node {
	public int priority;
	public int info;
	public Node link;

	// This method Node(i, pr) initializes our node and sets the given values of i
	// and pr to info and priority.
	public Node(int i, int pr) {
		info = i;
		priority = pr;
		link = null;
	}
}

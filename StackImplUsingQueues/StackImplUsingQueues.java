import java.util.LinkedList;
import java.util.Queue;

//Implement the stack methods push(x) and pop() using two queues (5 marks for each method). 

public class StackImplUsingQueues {

	Queue<Integer> q1 = new LinkedList<Integer>();
	Queue<Integer> q2 = new LinkedList<Integer>();

	public int pop() {
		if (q1.peek() == null) {
			System.out.println("The stack is empty, nothing to return");
			int i = 0;
			return i;
		} else {
			int pop = q1.remove();
			return pop;
		}
	}

	public void push(int data) {

		if (q1.peek() == null) {
			q1.add(data);
		} else {
			for (int i = q1.size(); i > 0; i--) {
				q2.add(q1.remove());
			}
			q1.add(data);
			for (int j = q2.size(); j > 0; j--) {
				q1.add(q2.remove());
			}

		}
	}

	public static void main(String[] args) {
		StackImplUsingQueues s1 = new StackImplUsingQueues();
		// Stack s1 = new Stack();
		s1.push(1);
		s1.push(2);
		s1.push(3);
		s1.push(4);
		s1.push(5);
		s1.push(6);
		s1.push(7);
		s1.push(8);
		s1.push(9);
		s1.push(10);
		// s1.push(6);
		System.out.println("1st = " + s1.pop());
		System.out.println("2nd = " + s1.pop());
		System.out.println("3rd = " + s1.pop());
		System.out.println("4th = " + s1.pop());
		System.out.println("5th = " + s1.pop());
		System.out.println("6th = " + s1.pop());
		System.out.println("7th = " + s1.pop());
		System.out.println("8th = " + s1.pop());
		System.out.println("9th = " + s1.pop());
		System.out.println("10th= " + s1.pop());
	}
}

// Analyze the running time of the push(x) and pop() operations based on this
// implementation

// Running time for push operation:

/**
 * Each push operation takes O(1). If we are inserting n elements in an array
 * then we need to push each element one by one and process every element this
 * means that the computation time for push operation is T(n) = O(n).
 **/

// Running time for pop operation:

/**
 * Each pop operation takes O(1). If we are removing n elements in from an array
 * then we need to pop each element one by one and process every element this
 * means that the computation time for pop operation is T(n) = O(n).
 **/

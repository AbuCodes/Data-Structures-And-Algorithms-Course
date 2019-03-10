
public class RedBlackAlgo {
	
	int black;
	int red;
	int odd;
	
	public class Node {
		int color = 0;
		Node leftChild, rightChild;
		public int height;
	}


	
	
	
	
	
	
	
	
	
	
	public void colorBlack (Node p) {
		p.color = black;
		
		if (p != null) {
			colorChildren(p.leftChild, p.rightChild);
		}
	}
	
	public void colorRed (Node p) {
		p.color = red;
		
		if (p != null) {
			colorChildren(p.leftChild, p.rightChild);
		}
	}
	
	public void colorChildren(Node left, Node right) {
		if (left.height < right.height || left.height == odd) {
			colorBlack(left);
		}
		else {
			colorRed(left);
		}
		
		if (right.height < left.height || right.height == odd) {
			colorBlack(right);
		}
		else {
			colorRed(right);
		}
	}

	
	
	
	
	
	
	
	
	
	
	
}

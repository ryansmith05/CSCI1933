public class SparseVector {
	private Node head;
	private int length;

	public SparseVector(int len) {
		head = null;
		length = len;
	}

	// Prints out a sparse vector (including zeros)
	public String toString() {

		String result = "";
		Node currNode = head;
		int currIndex = 0;
		while (currNode != null) {
			int idx = currNode.getIndex();

			// Pad the space between nodes with zero
			while (currIndex < idx) {
				result += "0, ";
				currIndex++;
			}
			result += currNode;
			currNode = currNode.getNext();
			currIndex++;

			// Only add a comma if this isn't the last element
			if (currNode != null) {
				result += ", ";
			}
		}
		return result;
	}

	// TODO: Implement me for milestone 2
	public void addElement(int index, double value) {
		Node newNode = new Node(index, value);
		Node current = head;

		if ((index) <= length) {
			if(head == null){
				head = newNode;
			}
			else{
				while (current.getNext() != null) {
					current = current.getNext();
				}
				current.setNext(newNode);
			}
		}
	}

		// TODO: Implement me for milestone 4
	public static double dot( SparseVector x, SparseVector y ){
		double sum=0.0;
		Node xInx = x.head;
		Node yInx = y.head;
		if (xInx == null || yInx == null) {
			System.out.println("error");
			return 0.0;
		}
		while (xInx != null && yInx != null) {
			int xIdx = xInx.getIndex();
			int yIdx = yInx.getIndex();
			if(xIdx == yIdx){
				sum += xInx.getValue() * yInx.getValue();
				xInx = xInx.getNext();
				yInx = yInx.getNext();
			}
			else if(xIdx > yIdx){
				yInx = yInx.getNext();
			}
			else if (yIdx > xIdx) {
				xInx = xInx.getNext();
			}
		}
		return sum;
	}

		// TODO: Test out your code here!
		public static void main (String[]args){
//			SparseVector vec = new SparseVector(9);
//			//vec.addElement(1,21.1);
//			vec.addElement(1, 25.0);
//			vec.addElement(7, -11.2);
//			vec.addElement(8, 32.0);
//			//vec.addElement(10,20.1);
//			System.out.println(vec);

			SparseVector x = new SparseVector(100000000);
			x.addElement(0, 1.0);
			x.addElement(10000000, 3.0);
			x.addElement(10000001, -2.0);
			SparseVector y = new SparseVector(100000000);
			y.addElement(0, 2.0);
			y.addElement(10000001, -4.0);
			double result = dot(x, y);
			System.out.println(result);
	}
}



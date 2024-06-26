
public class Stack {

	private Node top;
	private int size;

	public Stack() {
		super();
		this.top = null;
		this.size = 0;
	}

	public boolean push(int data) {
		Node nn = new Node(data);
		if (nn == null) {
			return false;
		}

		nn.setNext(top);
		top = nn;

		return true;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public void pop() {
		if (isEmpty()) {
			System.out.println("stack underflow..");
		}

		top = top.getNext();

	}

	public int peek() {
		if (isEmpty()) {
			return -1;
		}
		return top.getData();
	}

	public void display() {
		Node temp = top;
		while (temp != null) {
			System.out.print(temp.getData() + " ");
			temp = temp.getNext();
		}
		System.out.println();
	}

}

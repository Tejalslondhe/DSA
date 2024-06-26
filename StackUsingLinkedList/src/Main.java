
public class Main {

	public static void main(String[] args) {

		Stack st = new Stack();
		
		st.push(5);
		st.push(14);
		st.push(47);
		st.display();

		st.pop();
		st.display();
		
		System.out.println("Top element:" + st.peek());
		
	}

}

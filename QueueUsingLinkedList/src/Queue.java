public class Queue {
	
	private int size;
	private Node front,rare;
	
	public Queue() {
		super();
		this.size = 0;
		this.front = null;
		this.rare = null;
	}
	
	public boolean isEmpty()
	{
		return front == null;
	}
	
	public boolean insert(int data)
	{
		Node nn = new Node(data);
		if(nn == null)
		{
			return false;
		}
		
		if(isEmpty())
		{
			front = rare = nn;
		}
		
		rare.setNext(nn);
		rare = nn;
		return true;
	}
	
	public void remove()
	{
		if(isEmpty())
		{
			System.out.println("No element exist..");
		}
		
		//front.setNext(front.getNext());
		front = front.getNext();
	}
	
	public void display()
	{
		Node temp = front;
		while(temp!= null)
		{
			System.out.print(temp.getData()+" ");
			temp = temp.getNext();
		}
		System.out.println();
	}
	
	
	
	

}

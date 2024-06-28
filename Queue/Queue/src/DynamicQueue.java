public class DynamicQueue {
    private int [] arr;
    private int front, rear;
    private int size;

    public DynamicQueue(int size) {
        this.size = size;
        arr = new int[size];
        front = rear = -1;
    }

    public boolean isEmpty() {
        return (front == -1 && rear == -1) || (front > rear);
    }

    public boolean isFull() {
        return rear == (size - 1);
    }

    public boolean insert(int data) {
        if(isFull()) {
           resize(size*2);
        }
        arr[++rear] = data;
        if(front == -1) {
            front = 0;
        }
        return true;
    }

    public int delete() {
        if(isEmpty()) {
            return -999;
        }
        return arr[front++];
    }
    
    public void resize(int newsize)
    {
      int [] newArr = new int[newsize];
     
     for(int i = 0;i<rear-1;i++)
     {
    	 newArr[i] = arr[i];
     }
     
     arr = newArr;
     size = newsize;
    	
    }
}

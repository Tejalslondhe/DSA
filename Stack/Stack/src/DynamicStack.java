public class DynamicStack<T> {
    private T[] arr;
    private int capacity;
    private int top;

    public DynamicStack(int initialCapacity) {
        this.capacity = initialCapacity;
        top = -1;
        arr = (T[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public boolean push(T data) {
        if (isFull()) {
            // Resize the array when full
            resize(capacity * 2);
        }
        arr[++top] = data;
        return true;
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        return arr[top--];
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return arr[top];
    }

    private void resize(int newCapacity) {
        T[] newArr = (T[]) new Object[newCapacity];
        for (int i = 0; i <= top; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
        capacity = newCapacity;
    }

    public static void main(String[] args) {
        
        DynamicStack<Integer> stack = new DynamicStack<>(2);

        
        stack.push(10);
        stack.push(20);
        stack.push(30);  

        // Pop and peek elements
        System.out.println("Popped: " + stack.pop());
        System.out.println("Top element: " + stack.peek());

        // Push more elements
        stack.push(40);
        stack.push(50);

        
        System.out.print("Stack: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }
}

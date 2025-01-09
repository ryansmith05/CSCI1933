public class Stack<T extends Comparable<T>> {
    private Node <T> top;
    private int howMany;
    private int maxSize;

    public Stack() {
        this.top = null;
        this.howMany = 0;
        this.maxSize = 5;
    }

    public Stack(int size) {
        this.top = null;
        this.howMany = 0;
        this.maxSize = size;
    }

    public T pop() throws StackException {
        if (this.top == null) {
            throw new StackException(-1);
        }

        T data = this.top.getData();
        this.top = this.top.getNext();
        this.howMany--;

        return data;
    }

    public void push(T item) throws StackException {
        if (this.howMany == this.maxSize) {
            throw new StackException(howMany + 1);
        }

        Node<T> newNode = new Node<T>(item, this.top);
        this.top = newNode;
        this.howMany++;
    }
}



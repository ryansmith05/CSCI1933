public class LinkedList<T extends Comparable<T>> implements List<T> {
    private Node <T> head;
    private int size;
    private boolean isSorted;

    public LinkedList() {
        this.head = null;
        this.size = 0;
        this.isSorted = true;
    }

    @Override
    public boolean add(T element) {
        if (element == null) {
            return false;
        }
        Node newNode = new Node(element);
        //if list is empty
        if (head == null) {
            head = newNode;
            size += 1;
            return true;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            size++;
            current.setNext(newNode);
            //check is added element breaks order
            isSorted = isSorted();
            return true;
        }
    }

    @Override
    public boolean add(int index, T element) {
        //if index out of bounds
        if (index < 0 || index >= size) {
            return false;
        }
        Node newNode = new Node(element);
        //if index is head of list
        if (index == 0) {
            newNode.setNext(head);
            head = newNode;
        } else {
            Node previous = head;
            for (int i = 0; i < index - 1; i++) {
                previous = previous.getNext();
            }
            newNode.setNext(previous.getNext());
            previous.setNext(newNode);
        }
        size++;
        isSorted = isSorted();
        return true;
    }

    @Override
    public void clear() {
        //removes pointer at beginning of list
        head = null;
        size = 0;
        isSorted = true;
    }

    @Override
    public T get(int index) {
        //if index out of bounds
        if (index < 0 || index > size - 1) {
            return null;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            return current.getData();
        }
    }

    @Override
    public int indexOf(T element) {
        int index = 0;
        Node current = head;
        //if element matches, returns index of element
        while (current != null) {
            if (current.getData() == element) {
                return index;
            }
            current = current.getNext();
            index++;
        }
        //else returns -1
        return -1;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void sort() {
        Node <T> end = null;
        while (end != head.getNext()) {
            Node <T> current = head;
            Node <T> previous = null;

            while (current.getNext() != end) {
                if (current.getData().compareTo(current.getNext().getData()) > 0) {
                    Node <T> currNext = current.getNext();
                    current.setNext(currNext.getNext());
                    currNext.setNext(current);

                    if (previous == null) {
                        head = currNext;
                    } else {
                        previous.setNext(currNext);
                    }
                    current = currNext;
                }
                previous = current;
                current = current.getNext();
            }
            end = current;
        }
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size || head == null) {
            return null;
        }
        //checks first element
        if (index == 0) {
            T data = head.getData();
            head = head.getNext();
            size--;
            return data;
        } else {
            Node <T> current = head;
            for (int i = 0; i < index -1; i++ ) {
                current = current.getNext();
            }
            T data = current.getNext().getData();
            current.setNext(current.getNext().getNext());
            size--;
            return data;
        }
    }

    @Override
    public void equalTo(T element) {
        Node<T> current = head;
        Node<T> previous = null;

        while (current != null) {
            if (!current.getData().equals(element)) {
                if (previous == null) {
                    head = current.getNext();
                } else {
                    previous.setNext(current.getNext());
                }
                size--;
            } else {
                previous = current;
            }
            current = current.getNext();
        }
    }

    @Override
    public void reverse() {
        if (head == null || head.getNext() == null) {
            return;
        }
        Node<T> previous = null;
        Node<T> current = head;
        Node<T> next = null;

        while (current != null) {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        head = previous;
        isSorted = isSorted();
    }
    @Override
    public void merge(List<T> otherList) {
        Node <T> current = this.head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        Node <T> other = ((LinkedList<T>) otherList).getHead();
        while (other != null) {
            current.setNext(new Node <T>(other.getData()));
            current = current.getNext();
            other = other.getNext();
        }
        sort();
        size = size() + otherList.size();
    }
    private Node <T> getHead() {
        return this.head;
    }

    @Override
    public boolean rotate(int n) {
        if (n <= 0 || size <= 1) {
            return false;
        }
        int rotate = n % size;
        if (rotate == 0) {
            return true;
        }
        Node <T> current = head;
        for (int i = 0; i < size - rotate - 1; i++) {
            current = current.getNext();
        }
        Node <T> newCurr = current.getNext();
        current.setNext(null);
        Node <T> temp = newCurr;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(head);
        head = newCurr;
        return true;
    }


    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        Node current = head;
        while (current != null) {
            string.append(current.getData()).append(" ");
            current = current.getNext();
        }
        return string.toString();
    }

    @Override
    public boolean isSorted() {
        if (this.head == null) {
            return true;
        }
        Node <T> current = this.head;

        while (current.getNext() != null) {
            if (current.getData().compareTo(current.getNext().getData()) > 0) {
                return false;
            }
            current = current.getNext();
        }
        return true;
    }

}

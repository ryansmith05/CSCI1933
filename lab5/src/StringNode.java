public class StringNode {
    public StringNode() {}

    public StringNode(String item, StringNode link) {
        data = item;
        next = link;
    }
    public String getData() { return data; }
    public StringNode getNext() { return next; }
    public void setData(String item) { data = item; }
    public void setNext(StringNode link) { next = link; }
    public void addToStart(StringNode ls, String item) {
        ls = new StringNode(item, null);
    }
    public void addToEnd(StringNode ls, String item) {
        StringNode ptr = ls;
        if (ls == null)
            ls = new StringNode(item, null);
        else {
            while (ptr.getNext() != null) {
                ptr = ptr.getNext();
            }
            ptr.setNext(new StringNode(item, null));
        }
    }
    private String data;
    private StringNode next;
    public static void main(String[] args) {
        StringNode myList = new StringNode("hello", null);
        StringNode ptr;
        myList.addToEnd(myList, "goodbye");
        myList.addToStart(myList, "new start");
        myList.addToEnd(myList, "new end");

        ptr = myList;
        int count = 0;
        while (ptr != null) {
            count++;
            System.out.println("Value " + count + " is: " + ptr.getData().toString());
            ptr = ptr.getNext();
        }

    }
}


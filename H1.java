public class H1 {
    public static void main(String[] args) {
        IntNode begin = null;
        IntNode end = null;

        begin = new IntNode(5, null);
        end = begin;
        //end = new IntNode(500, null);
        // the above line does not work
        end.setNext(new IntNode(500, null))
    }
}
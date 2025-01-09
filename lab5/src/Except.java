public class Except {
    public static void init(char[] a, int index, char c) {
        System.out.println("starting init: " + a[0]);
        a[index] = c;
        System.out.println("ending init: " + a[0]);
    }
    public static void main(String[] args) {
        char[] a = new char[3];
        a[0] = 'a';
        a[1] = 'b';
        a[2] = 'c';
        try {
            init(a, 3, '*'); // attempt to write past end of array
            init(a, 0, '$');
        }
        catch (RuntimeException e) {
            System.out.println("main catch: " + a[0]);
        }
        finally {
            System.out.println("main finally: " + a[0]);
        }
        init(a, 0, '#');
        System.out.println("main near bottom: " + a[0]);
    }
}

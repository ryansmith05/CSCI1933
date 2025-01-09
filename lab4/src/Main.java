public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");
        Owl owl1 = new Owl("owl1", 5, 12.0);
        Owl owl2 = new Owl("owl2", 5, 12.0);
        Owl owl3 = new Owl("owl1", 5, 12.0);
        System.out.println(owl1.equals(owl2)); //return false
        System.out.println(owl1.equals(owl3)); //return true
    }

}
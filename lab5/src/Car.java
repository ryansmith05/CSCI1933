public class Car extends Vehicle {
    public String toString() {
        String result = "Car class; ";
        return result;
    }

    public static void main(String args []){
        Vehicle v = new Car();
        System.out.println(v.toString());
    }
}

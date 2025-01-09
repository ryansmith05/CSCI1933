public class Helicopter extends Vehicle{
    private double mpg;

    public Helicopter(){
        mpg = 0.3;
        nVehicles++;
    }
    public Helicopter(double mpg) {
        this.mpg = mpg;
        nVehicles++;
    }
    @Override
    public double getMPG() {
        return this.mpg;
    }
    @Override
    public void movingForward() {
        System.out.println("Helicopter Moving Forward");
    }
    @Override
    public void movingBackward() {
        System.out.println("Helicopter Moving Backward");
    }
    public void movingUp(){
        System.out.println("Helicopter Moving Up");
    }
    public String toString() {
        String result;
        result = "Helicopter: " + this.mpg;
        return result;
    }
}

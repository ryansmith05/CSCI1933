public class Train extends Vehicle{
    private double mpg;

    public Train(){
        mpg = 470.0;
        nVehicles++;
    }
    public Train(double mpg) {
        this.mpg = mpg;
        nVehicles++;
    }
    @Override
    public double getMPG() {
        return this.mpg;
    }
    @Override
    public void movingForward() {
        System.out.println("Train Moving Forward");
    }
    @Override
    public void movingBackward() {
        System.out.println("Train Moving Backward");
    }
    public void enteringStation(){
        System.out.println("Train Entering Station");
    }
    public void leavingStation(){
        System.out.println("Train Leaving Station");
    }
    public String toString() {
        String result;
        result = "Train: " + this.mpg;
        return result;
    }
}

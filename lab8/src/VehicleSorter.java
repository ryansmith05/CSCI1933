import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class VehicleSorter {
	public static void main(String[] args) {
		List<Vehicle> vehicles = new ArrayList<Vehicle>();

		//TODO: add vehicle objects of different types to your list
		//	e.g. vehicles.add(new Vehicle());
		vehicles.add(new Car(20.0));
		vehicles.add(new Car(1.0));
		vehicles.add(new Train(200.0));
		vehicles.add(new Helicopter(21.0));
		vehicles.add(new Helicopter(19.0));
		vehicles.add(new Train(5.0));


		Collections.sort(vehicles);
		for (Vehicle v : vehicles) {
			System.out.println(v);
		}
	}
}

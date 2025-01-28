//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        float distance = 240;

        Transport car = new Car(distance);
        Transport bike = new Bike(distance);
        Transport train = new Train(distance);

        // Calculate travel times
        float carTime = car.travelTime();
        float bikeTime = bike.travelTime();
        float trainTime = train.travelTime();

        String fastestTransport;
        float minTime;

        if (carTime <= bikeTime && carTime <= trainTime) {
            fastestTransport = "Car";
            minTime = carTime;
        } else if (bikeTime <= carTime && bikeTime <= trainTime) {
            fastestTransport = "Bike";
            minTime = bikeTime;
        } else {
            fastestTransport = "Train";
            minTime = trainTime;
        }

        System.out.println(fastestTransport + " is the fastest mode for " + distance + " km, taking " + minTime + " hours.");

    }
}
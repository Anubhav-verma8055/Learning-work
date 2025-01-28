public class Car extends Transport{
    private static final float SPEED = 60;

    public Car(float distance) {
        super(distance);
    }
    @Override
    public float travelTime() {
        return distance / SPEED;
    }
}

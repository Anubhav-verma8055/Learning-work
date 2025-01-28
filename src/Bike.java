public class Bike extends Transport{
    private static final float SPEED = 40;

    public Bike(float distance) {
        super(distance);
    }
    @Override
    public float travelTime() {
        return distance / SPEED;
    }
}

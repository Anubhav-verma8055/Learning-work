public class Train extends Transport {
    private static final float SPEED = 120;

    public Train(float distance) {
        super(distance);
    }

    @Override
    public float travelTime() {
        return distance / SPEED;
    }
}

package wirecross;

public class IntersectionPoint {

    private final Point coordinates;
    private final Integer loss;

    public IntersectionPoint(Point coordinates, Integer loss) {
        this.coordinates = coordinates;
        this.loss = loss;
    }

    public Integer getLoss() {
        return loss;
    }
}

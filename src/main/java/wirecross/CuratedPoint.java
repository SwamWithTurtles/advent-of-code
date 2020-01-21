package wirecross;

import java.util.Objects;

public class CuratedPoint {

    private final Point point;
    private final Integer countToPath;

    public CuratedPoint(Point point, Integer countToPath) {
        this.point = point;
        this.countToPath = countToPath;
    }

    public Integer getCountToPath() {
        return countToPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CuratedPoint that = (CuratedPoint) o;
        return Objects.equals(point, that.point);
    }

    @Override
    public int hashCode() {

        return Objects.hash(point);
    }

    public Point getPoint() {
        return point;
    }
}

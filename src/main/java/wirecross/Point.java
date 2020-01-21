package wirecross;

import java.util.Objects;

public class Point {

    private final Integer x;
    private final Integer y;

    public Point(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Point travel(Direction direction) {
        switch(direction) {
            case D:
                return new Point(x, y - 1);
            case U:
                return new Point(x, y + 1);
            case L:
                return new Point(x -1, y);
            case R:
                return new Point(x+1, y);
        }

        return new Point(x, y);
    }

    public Integer distanceFromOrigin() {
        return Math.abs(x) + Math.abs(y);
    }

    @Override
    public String toString() {
        return String.format("(%d,%d)", x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Objects.equals(x, point.x) &&
                Objects.equals(y, point.y);
    }

    @Override
    public int hashCode() {

        return Objects.hash(x, y);
    }
}

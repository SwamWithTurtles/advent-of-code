package wirecross.lossfunction;

import wirecross.CuratedPoint;

public class ManhattanDistance implements LossFunction {
    @Override
    public Integer apply(CuratedPoint p1, CuratedPoint p2) {
        return p1.getPoint().distanceFromOrigin();
    }
}

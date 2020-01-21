package wirecross.lossfunction;

import wirecross.CuratedPoint;

public class CombinedStepsDistance implements LossFunction {
    @Override
    public Integer apply(CuratedPoint p1, CuratedPoint p2) {
        return p1.getCountToPath() + p2.getCountToPath();
    }
}

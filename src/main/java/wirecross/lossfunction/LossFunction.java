package wirecross.lossfunction;

import wirecross.CuratedPoint;

@FunctionalInterface
public interface LossFunction {

    public Integer apply(CuratedPoint p1, CuratedPoint p2);

}

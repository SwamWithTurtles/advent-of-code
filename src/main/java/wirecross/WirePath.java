package wirecross;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WirePath {

    private final List<Instruction> instructions;

    private WirePath(List<Instruction> instructions) {
        this.instructions = instructions;
    }

    public static WirePath fromInstructions(String csvInstructions) {
        return new WirePath(Arrays.stream(csvInstructions.split(","))
                .map(Instruction::fromString)
                .collect(Collectors.toList()));
    }

    public Set<CuratedPoint> getPoints() {
        Set<CuratedPoint> points = new HashSet<>();
        Point pointer = new Point(0, 0);
        Integer lengthOfPath = 0;
        for(Instruction instruction : instructions) {
            for (Integer i = 0; i < instruction.getLength(); i++) {
                pointer = pointer.travel(instruction.getDirection());
                lengthOfPath++;
                CuratedPoint curatedPoint = new CuratedPoint(pointer, lengthOfPath);
                if (!points.contains(curatedPoint)) {
                    points.add(curatedPoint);
                }
            }
        }
        return points;
    }

    @Override
    public String toString() {
        return "WirePath{" +
                "instructions=" + instructions +
                '}';
    }
}

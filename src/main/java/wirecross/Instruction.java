package wirecross;

import java.util.Set;

public class Instruction {

    private final Direction direction;
    private final Integer length;

    public Integer getLength() {
        return length;
    }

    public Instruction(Direction direction, Integer length) {
        this.direction = direction;
        this.length = length;
    }

    public static Instruction fromString(String instruction) {
        String directionAsString = instruction.substring(0, 1);
        Integer length = Integer.parseInt(instruction.substring(1));

        return new Instruction(Direction.valueOf(directionAsString), length);
    }

    @Override
    public String toString() {
        return "Instruction{" +
                "direction=" + direction +
                ", length=" + length +
                '}';
    }

    public Direction getDirection() {
        return direction;
    }
}

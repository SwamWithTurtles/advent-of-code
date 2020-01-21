package opcode.input;

public class ConstantOneInputStrategy extends IOStrategy {

    private Integer constantInput;

    public ConstantOneInputStrategy(Integer constantInput) {
        this.constantInput = constantInput;
    }

    @Override
    public Integer getInput() {
        return constantInput;
    }
}

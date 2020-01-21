package opcode.input;

public abstract class IOStrategy {
    private Integer output;

    public abstract Integer getInput();

    public void output(Integer integer) {
        this.output = integer;
    };

    public Integer spitOutput() {
        return this.output;
    }
}

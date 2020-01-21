package opcode;

public class Parameter {

    private final ParameterMode mode;
    private final Integer input;

    public Parameter(ParameterMode mode, Integer input) {
        this.mode = mode;
        this.input = input;
    }

    public ParameterMode getMode() {
        return mode;
    }

    public Integer getInput() {
        return input;
    }

    public Integer getMemLoc() {
        return input;
    }

    public Integer getValue(Opcode oc) {
        switch (mode) {
            case POSITION_MODE:
                return oc.getValueAtPosition(input);
            case IMMEDIATE_MODE:
                return input;
            default:
                throw new RuntimeException("Invalid Parameter Mode");
        }
    }
}



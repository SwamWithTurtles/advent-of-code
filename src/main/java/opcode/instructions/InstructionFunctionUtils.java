package opcode.instructions;

import opcode.Opcode;

public class InstructionFunctionUtils {


    public static final OpcodeInstruction JUMP_IF_TRUE = (oc, parameters, is) -> {
        if (parameters.get(0).getValue(oc) != 0) {
            return oc.setPosition(parameters.get(1).getValue(oc));
        } else {
            return oc.advance(3);
        }
    };

    public static final OpcodeInstruction JUMP_IF_FALSE = (oc, parameters, is) -> {
        if (parameters.get(0).getValue(oc) == 0) {
            return oc.setPosition(parameters.get(1).getValue(oc));
        } else {
            return oc.advance(3);
        }
    };

    public static final OpcodeInstruction LESS_THAN = (oc, parameters, is) -> {
        if (parameters.get(0).getValue(oc) < parameters.get(1).getValue(oc)) {
            return oc.replace(parameters.get(2).getMemLoc(), 1).advance(4);
        } else {
            return oc.replace(parameters.get(2).getMemLoc(), 0).advance(4);
        }
    };

    public static final OpcodeInstruction EQUALS = (oc, parameters, is) -> {
        if (parameters.get(0).getValue(oc).equals(parameters.get(1).getValue(oc))) {
            return oc.replace(parameters.get(2).getMemLoc(), 1).advance(4);
        } else {
            return oc.replace(parameters.get(2).getMemLoc(), 0).advance(4);
        }
    };

    public static final OpcodeInstruction OUTPUT = (oc, parameters, is) -> {
        is.output(parameters.get(0).getValue(oc));
        return oc.advance(2);
    };

    public static final OpcodeInstruction MULTIPLY = (oc, parameters, is) -> oc
            .replace(parameters.get(2).getMemLoc(), parameters.get(0).getValue(oc) * parameters.get(1).getValue(oc))
            .advance(4);

    public static final OpcodeInstruction ADD = (oc, parameters, is) -> oc
            .replace(parameters.get(2).getMemLoc(), parameters.get(0).getValue(oc) + parameters.get(1).getValue(oc))
            .advance(4);

    public static final OpcodeInstruction INPUT = (oc, parameters, is) -> oc
            .replace(parameters.get(0).getMemLoc(), is.getInput())
            .advance(2);

    public static final OpcodeInstruction TERMINATE = (oc, parameters, is) -> oc.halt();
}

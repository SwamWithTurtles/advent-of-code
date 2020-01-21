package opcode.instructions;

import java.util.Arrays;

public enum ExecutionInstruction {
    TERMINATE(99, InstructionFunctionUtils.TERMINATE, 0),
    ADD(1, InstructionFunctionUtils.ADD, 3),
    MULTIPLY(2, InstructionFunctionUtils.MULTIPLY, 3),
    INPUT(3, InstructionFunctionUtils.INPUT, 1),
    OUTPUT(4, InstructionFunctionUtils.OUTPUT ,1),
    JUMP_IF_TRUE(5, InstructionFunctionUtils.JUMP_IF_TRUE, 2),
    JUMP_IF_FALSE(6, InstructionFunctionUtils.JUMP_IF_FALSE, 2),
    LESS_THAN(7, InstructionFunctionUtils.LESS_THAN, 3),
    EQUALS(8, InstructionFunctionUtils.EQUALS, 3);

    private Integer code;
    private OpcodeInstruction instruction;
    private Integer numberOfParameters;

    ExecutionInstruction(Integer code, OpcodeInstruction instruction, Integer numberOfParameters) {
        this.code = code;
        this.instruction = instruction;
        this.numberOfParameters = numberOfParameters;
    }

    public OpcodeInstruction getInstruction() {
        return instruction;
    }

    public Integer getNumberOfParameters() {
        return numberOfParameters;
    }

    public static ExecutionInstruction getFromCode(Integer possibleCode) {
        return Arrays.stream(ExecutionInstruction.values()).filter(i -> i.code.equals(possibleCode)).findFirst().orElseThrow(() -> new RuntimeException("Invalid Key"));
    }
}
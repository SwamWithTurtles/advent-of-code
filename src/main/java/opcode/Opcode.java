package opcode;

import java.util.*;

import opcode.input.IOStrategy;
import opcode.instructions.ExecutionInstruction;

public class Opcode {

    private final IOStrategy ioStrategy;

    private Integer[] memory;
    private Integer instructionPointer;
    private Boolean isHalted;

    private Opcode(Integer[] memory, Integer instructionPointer, Boolean isHalted, IOStrategy ioStrategy) {
        this.ioStrategy = ioStrategy;
        this.memory = memory;
        this.instructionPointer = instructionPointer;
        this.isHalted = isHalted;
    }

    public static Opcode buildFromStringWithCustomVerbNoun(String programmeRepresentation, Integer noun, Integer verb, IOStrategy ioStrategy) {
        Integer[] opCode = Arrays.stream(programmeRepresentation.split(",")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);

        opCode[1] = noun;
        opCode[2] = verb;

        return new Opcode(opCode, 0, false, ioStrategy);
    }

    public static Opcode buildFromString(String programmeRepresentation, IOStrategy ioStrategy) {
        Integer[] opCode = Arrays.stream(programmeRepresentation.split(",")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        return new Opcode(opCode, 0, false, ioStrategy);
    }

    public Opcode execute() {
        Opcode nextIteration = runIteration();
        if(nextIteration.isHalted) {
            return nextIteration;
        } else {
            return nextIteration.execute();
        }
    }

    public Integer getOutput() {
        return this.memory[0];
    }

    private Opcode runIteration() {
        Integer opcodeInstruction = memory[instructionPointer] % 100;
        ExecutionInstruction instructionToApply = ExecutionInstruction.getFromCode(opcodeInstruction);

        Integer numberOfParameters = instructionToApply.getNumberOfParameters();

        List<Parameter> parameters = new ArrayList<>();
        for (int i = 0; i < numberOfParameters; i++) {
            ParameterMode parameterMode = ParameterMode.values()[(memory[instructionPointer] / ((Double)Math.pow(10, i + 2)).intValue()) % 10];
            Integer parameterValue = memory[instructionPointer + (i + 1)];
            parameters.add(new Parameter(parameterMode, parameterValue));
        }

        return instructionToApply.getInstruction().apply(this, parameters, ioStrategy);
    }
    
    public Opcode replace(Integer pointerToReplace, Integer whatToReplaceItWith) {
        Integer[] newProgramme = memory.clone();
        newProgramme[pointerToReplace] = whatToReplaceItWith;

        return new Opcode(newProgramme, instructionPointer, false, ioStrategy);
    }

    public Opcode advance(Integer numberOfPositionsToAdvance) {
        return new Opcode(memory, instructionPointer + numberOfPositionsToAdvance, false, ioStrategy);
    }

    public Opcode setPosition(Integer newPosition) {
        return new Opcode(memory, newPosition, false, ioStrategy);
    }

    public Opcode halt() {
        return new Opcode(memory, instructionPointer, true, ioStrategy);
    }

    public Integer getValueAtPosition(Integer input) {
        return memory[input];
    }

    public Integer flushOutput() {
        return ioStrategy.spitOutput();
    }

    @Override
    public String toString() {
        return "Opcode{" +
                "opcodeProgramme=" + Arrays.toString(memory) +
                '}';
    }

}

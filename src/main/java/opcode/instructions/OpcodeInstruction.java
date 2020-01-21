package opcode.instructions;

import opcode.input.IOStrategy;
import opcode.Opcode;
import opcode.Parameter;

import java.util.List;

@FunctionalInterface
public interface OpcodeInstruction {
    Opcode apply(Opcode oc, List<Parameter> params, IOStrategy is);
}

package bootstrap;

import opcode.input.IOStrategy;

import java.util.Iterator;
import java.util.List;

public class IterableInputStrategy extends IOStrategy {
    Iterator<Integer> inputParameters;
    public IterableInputStrategy(Iterator<Integer> list) {
        this.inputParameters = list;
    }


    @Override
    public Integer getInput() {
        if(inputParameters.hasNext()) {
            return inputParameters.next();
        } else {
            throw new RuntimeException("Not enough input parameters");
        }

    }
}

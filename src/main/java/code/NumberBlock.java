package code;

import java.util.Collections;

public class NumberBlock {
    private final Integer value;
    private final Integer count;

    public NumberBlock(Integer value, Integer count) {
        this.value = value;
        this.count = count;
    }

    public Integer getValue() {
        return value;
    }

    public Integer getCount() {
        return count;
    }

    @Override
    public String toString() {
        return String.join("", Collections.nCopies(count, value.toString()));
    }
}
package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Passcode {

    private final List<NumberBlock> prospectiveCode;

    public Passcode(String prospectiveCode) {
        this.prospectiveCode = passcodeAsList(prospectiveCode, new ArrayList<>());
    }

    private List<NumberBlock> passcodeAsList(String possibleCode, List<NumberBlock> asNumberBlock) {
        if(possibleCode.length() < 1) {
            return asNumberBlock;
        }

        Integer nextDigit = Integer.parseInt(possibleCode.substring(0, 1));
        String tail = possibleCode.substring(1, possibleCode.length());

        if(asNumberBlock.size() == 0) {
            return passcodeAsList(tail, Arrays.asList(new NumberBlock(nextDigit, 1)));
        }

        NumberBlock lastNumberBlock = asNumberBlock.get(asNumberBlock.size() - 1);

        if(lastNumberBlock.getValue().equals(nextDigit)) {
            List<NumberBlock> newNumberBlock = new ArrayList<>(asNumberBlock.subList(0, asNumberBlock.size() - 1));
            newNumberBlock.add(new NumberBlock(lastNumberBlock.getValue(), lastNumberBlock.getCount() + 1));
            return passcodeAsList(tail, newNumberBlock);
        } else {
            List<NumberBlock> newNumberBlock = new ArrayList<>(asNumberBlock);
            newNumberBlock.add(new NumberBlock(nextDigit, 1));
            return passcodeAsList(tail, newNumberBlock);
        }
    }

    private boolean isAscending() {
        for (int i = 0; i < prospectiveCode.size(); i++) {
            if(i != 0 && prospectiveCode.get(i).getValue() < prospectiveCode.get(i - 1).getValue()) {
                return false;
            }
        }
        return true;
    }

    private boolean containsExactDouble() {
        return prospectiveCode.stream()
                .anyMatch(nb -> nb.getCount() == 2);
    }

    private boolean containsDouble() {
        return prospectiveCode.stream()
                .anyMatch(nb -> nb.getCount() >= 2);
    }

    @Override
    public String toString() {
        return prospectiveCode.stream().map(NumberBlock::toString).collect(Collectors.joining(""));
    }

    public boolean isValidForDay1() {
        return containsDouble() && isAscending();
    }

    public boolean isValidForDay2() {
        return containsExactDouble() && isAscending();
    }
}

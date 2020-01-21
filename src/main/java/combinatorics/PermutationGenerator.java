package combinatorics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationGenerator<T> {

    private final List<T> masterList;


    public PermutationGenerator(List<T> masterList) {
        this.masterList = masterList;
    }

    public Set<List<T>> generatePermutations() {
        if(masterList.isEmpty()) {
            return new HashSet<List<T>>() {{
                add(new ArrayList<>());
            }};
        }

        Set<List<T>> permutations = new HashSet<>();

        for (T item: masterList) {
            List<T> clonedList = new ArrayList<>(masterList);
            clonedList.remove(item);

            Set<List<T>> permutationsOfTail = new PermutationGenerator<>(clonedList).generatePermutations();
            permutationsOfTail.forEach(s -> s.add(item));

            permutations.addAll(permutationsOfTail);
        }

        return permutations;
    }
}

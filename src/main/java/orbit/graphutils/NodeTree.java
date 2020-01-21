package orbit.graphutils;

import java.util.HashSet;
import java.util.Set;

public class NodeTree {

    private DjikstraReadyNode topLevel;
    private Set<DjikstraReadyNode> nestedChildren;

    public NodeTree(DjikstraReadyNode topLevel, Set<DjikstraReadyNode> nestedChildren) {
        this.topLevel = topLevel;
        this.nestedChildren = nestedChildren;
    }

    public Set<DjikstraReadyNode> getAllChildren() {
        Set<DjikstraReadyNode> pros = new HashSet<>();
        pros.add(topLevel);
        pros.addAll(nestedChildren);
        return pros;
    }

    public DjikstraReadyNode getTopLevel() {
        return topLevel;
    }
}
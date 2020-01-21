package orbit.graphutils;

import sun.plugin.dom.exception.InvalidStateException;

import java.util.Comparator;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class DjikstraTreeSet {
    private final Set<DjikstraReadyNode> djikstraReadyNodes;
    private final DjikstraReadyNode currentNode;

    public DjikstraTreeSet(Set<DjikstraReadyNode> djikstraReadyNodes, DjikstraReadyNode currentNode) {
        this.djikstraReadyNodes = djikstraReadyNodes;
        this.currentNode = currentNode;
    }

    public DjikstraTreeSet iterate() {
        if(isAtDest()) {
           return this;
        }

        currentNode.visit();
        Set<DjikstraReadyNode> updatedWeights = updatedWeights();
        DjikstraReadyNode newCurrentNode = updatedWeights.stream().filter(v -> !v.isVisited()).min(Comparator.comparing(DjikstraReadyNode::getWeight)).get();

        return constructNewTreeSet(updatedWeights, newCurrentNode);
    }

    public abstract DjikstraTreeSet constructNewTreeSet(Set<DjikstraReadyNode> nodes, DjikstraReadyNode current);

    private Set<DjikstraReadyNode> updatedWeights() {
        return djikstraReadyNodes.stream().map(node -> {
            if (node.getAdjacentNodes().contains(currentNode)) {
                return node.updateWithNewWeight(currentNode.getWeight() + 1);
            } else {
                return node;
            }
            }).collect(Collectors.toSet());
    }

    public boolean isAtDest() {
        return currentNode.isDest();
    }

    public Integer extractPathLength() {
        if(isAtDest()) {
            return currentNode.getWeight();
        } else {
            throw new InvalidStateException("Called Extract Length before ready");
        }
    }
}

package orbit;

import orbit.graphutils.DjikstraReadyNode;
import orbit.graphutils.DjikstraTreeSet;
import orbit.graphutils.NodeTree;

import java.util.*;
import java.util.stream.Collectors;

public class OrbiterTreeSet extends DjikstraTreeSet {
    private OrbiterTreeSet(Set<DjikstraReadyNode> djikstraReadyNodes, DjikstraReadyNode currentNode) {
        super(djikstraReadyNodes, currentNode);
    }

    @Override
    public DjikstraTreeSet constructNewTreeSet(Set<DjikstraReadyNode> nodes, DjikstraReadyNode current) {
        return new OrbiterTreeSet(nodes, current);
    }

    public static DjikstraTreeSet fromPlanetarySystem(PlanetarySystem orbiters, String startName, String destName) {
        Orbiter treeRoot = orbiters.getCentreOfMassNode();
        Set<DjikstraReadyNode> djikstraReadyNodes = buildDjikstraTreeSetBeneathOrbiter(treeRoot, Optional.empty(), startName, destName).getAllChildren();

        DjikstraReadyNode firstNode = djikstraReadyNodes.stream().filter(DjikstraReadyNode::isStart).findFirst().get();

        return new OrbiterTreeSet(djikstraReadyNodes, firstNode);
    }

    private static NodeTree buildDjikstraTreeSetBeneathOrbiter(Orbiter orbiter, Optional<DjikstraReadyNode> parentNode, String startName, String destName) {
        DjikstraReadyNode node = new DjikstraReadyNode(orbiter, startName, destName);
        parentNode.ifPresent(node::addAdjacentNode);

        if (orbiter.getOrbiters().isEmpty()) {
            return new NodeTree(node, new HashSet<>());
        }

        List<NodeTree> children = orbiter.getOrbiters().stream()
                .map(oc -> buildDjikstraTreeSetBeneathOrbiter(oc, Optional.of(node), startName, destName))
                .collect(Collectors.toList());

        children.stream().map(NodeTree::getTopLevel).forEach(node::addAdjacentNode);

        Set<DjikstraReadyNode> allChildren = children.stream().map(NodeTree::getAllChildren).flatMap(Collection::stream).collect(Collectors.toSet());

        return new NodeTree(node, allChildren);
    }
}

package orbit.graphutils;

import orbit.Orbiter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class DjikstraReadyNode {

    private Set<DjikstraReadyNode> adjacentNodes = new HashSet<>();
    private Integer djikstraWeight = Integer.MAX_VALUE;
    private boolean isStart = false;
    private boolean isDest = false;
    private boolean isVisited = false;
    private final String name;

    public DjikstraReadyNode(Orbiter orbiter, String startName, String destName) {
        this.name = orbiter.getName();
        if (orbiter.getOrbiters().stream().anyMatch(o -> o.getName().equals(startName))) {
            this.isStart = true;
            this.isVisited = true;
            this.djikstraWeight = 0;
        } else if(orbiter.getOrbiters().stream().anyMatch(o -> o.getName().equals(destName))) {
            this.isDest = true;
        }
    }

    public DjikstraReadyNode updateWithNewWeight(Integer weight) {
        if(this.djikstraWeight > weight) {
            this.djikstraWeight = weight;
        }
        return this;
    }

    public void addAdjacentNode(DjikstraReadyNode orbiter) {
        this.adjacentNodes.add(orbiter);
    }

    public boolean isStart() {
        return isStart;
    }

    public Set<DjikstraReadyNode> getAdjacentNodes() {
        return adjacentNodes;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public Integer getWeight() {
        return djikstraWeight;
    }

    public boolean isDest() {
        return isDest;
    }

    public void visit() {
        this.isVisited = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DjikstraReadyNode that = (DjikstraReadyNode) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}

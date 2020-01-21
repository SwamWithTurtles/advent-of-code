package orbit;

import java.util.Objects;
import java.util.Set;

public class Orbiter {

    private final String name;
    private Set<Orbiter> childOrbiters;

    public Orbiter(String name, Set<Orbiter> childOrbiters) {
        this.name = name;
        this.childOrbiters = childOrbiters;
    }

    public String getName() {
        return name;
    }

    public void addOrbiter(Orbiter orbiter) {
        childOrbiters.add(orbiter);
    }

    public Integer countNumberOfDirectAndIndirectOrbiters() {
        if(childOrbiters.isEmpty()) {
            return 0;
        } else {
            Integer indirectOrbiters = childOrbiters.stream().mapToInt(Orbiter::countNumberOfDirectAndIndirectOrbiters).sum();
            return childOrbiters.size() + indirectOrbiters;
        }
    }

    public Set<Orbiter> getOrbiters() {
        return this.childOrbiters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orbiter orbiter = (Orbiter) o;
        return Objects.equals(name, orbiter.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}

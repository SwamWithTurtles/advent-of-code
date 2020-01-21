package orbit;

import orbit.graphutils.DjikstraTreeSet;

import java.util.*;

public class PlanetarySystem {

    private static final String CENTRE_OF_MASS = "COM";
    private static final String START_NAME = "YOU";
    private static final String DEST_NAME = "SAN";

    private final Set<Orbiter> orbiters;

    private PlanetarySystem(Set<Orbiter> orbiters) {
        this.orbiters = orbiters;
    }

    public static PlanetarySystem fromString(String orbitString) {
        Set<Orbiter> orbiters = new HashSet<>();

        Arrays.stream(orbitString.split(","))
                .forEach(orbit -> {
                    String[] orbitRelationship = orbit.split("\\)");
                    Optional<Orbiter> optionalCentre = orbiters.stream().filter(orbiter -> orbiter.getName().equals(orbitRelationship[0])).findFirst();
                    Optional<Orbiter> optionalOrbiter = orbiters.stream().filter(orbiter -> orbiter.getName().equals(orbitRelationship[1])).findFirst();

                    Orbiter centre = optionalCentre.orElseGet(() -> new Orbiter(orbitRelationship[0], new HashSet<>()));
                    Orbiter orbiter = optionalOrbiter.orElseGet(() -> new Orbiter(orbitRelationship[1], new HashSet<>()));

                    orbiters.add(orbiter);
                    orbiters.add(centre);

                    centre.addOrbiter(orbiter);
                });

        return new PlanetarySystem(orbiters);
    }

    public Integer getPathLengthBetweenTwoNodes() throws PlanetDoesNotExistException {
        DjikstraTreeSet djikstraOrbiterSet = OrbiterTreeSet.fromPlanetarySystem(this, START_NAME, DEST_NAME);

        while(!djikstraOrbiterSet.isAtDest()) {
            djikstraOrbiterSet = djikstraOrbiterSet.iterate();
        }

        return djikstraOrbiterSet.extractPathLength();
    }

    public Integer checksum() {
        return orbiters.stream().mapToInt(Orbiter::countNumberOfDirectAndIndirectOrbiters).sum();
    }


    public Orbiter getCentreOfMassNode() throws PlanetDoesNotExistException {
        return getOrbiterFromName(CENTRE_OF_MASS);
    }

    private Orbiter getOrbiterFromName(String name) throws PlanetDoesNotExistException {
        Optional<Orbiter> optionalCentre = orbiters.stream().filter(orbiter -> orbiter.getName().equals(name)).findFirst();
        if(optionalCentre.isPresent()) {
            return optionalCentre.get();
        } else {
            throw new PlanetDoesNotExistException();
        }
    }
}

import fuel.MassfulFuelRequirement;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class ModuleTest {

    @Test
    public void whenMulitpleOfThree() {
        MassfulFuelRequirement massfulFuelRequirement = new MassfulFuelRequirement(12);
        assertThat(massfulFuelRequirement.getAmountOfFuel()).isEqualTo(2);
    }

    @Test
    public void whenMulitpleOfThreePlusOne() {
        MassfulFuelRequirement massfulFuelRequirement = new MassfulFuelRequirement(13);
        assertThat(massfulFuelRequirement.getAmountOfFuel()).isEqualTo(2);
    }

    @Test
    public void whenMulitpleOfThreePlusTwo() {
        MassfulFuelRequirement massfulFuelRequirement = new MassfulFuelRequirement(14);
        assertThat(massfulFuelRequirement.getAmountOfFuel()).isEqualTo(2);
    }
}


package fuel;

public class MassfulFuelRequirement extends FuelRequirement {

    public MassfulFuelRequirement(Integer mass) {
        super(mass);
    }

    public Integer getAmountOfFuel() {
        Integer nominalFuel = getNominalFuel();
        if (nominalFuel <= 0) {
            return 0;
        } else {
            return nominalFuel + new MassfulFuelRequirement(nominalFuel).getAmountOfFuel();
        }
    }
}

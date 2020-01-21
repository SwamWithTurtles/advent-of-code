package fuel;

public class MasslessFuelRequirement extends FuelRequirement {

    public MasslessFuelRequirement(Integer mass) {
        super(mass);
    }

    public Integer getAmountOfFuel() {
        return this.getNominalFuel();
    }
}

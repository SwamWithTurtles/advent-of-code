package fuel;

public abstract class FuelRequirement {

    protected final Integer mass;

    protected FuelRequirement(Integer mass) {
        this.mass = mass;
    }

    protected Integer getNominalFuel() {
        return (this.mass/3) - 2;
    }

    protected abstract Integer getAmountOfFuel();


}

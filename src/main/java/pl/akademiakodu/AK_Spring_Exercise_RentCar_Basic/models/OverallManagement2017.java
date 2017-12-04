package pl.akademiakodu.AK_Spring_Exercise_RentCar_Basic.models;

/**
 * Class sroting statics variables used in some calculations
 */
public class OverallManagement2017 {

    /**
     * Variables declaration and initialization
     */
    private final static int COST_OF_ONE_FUEL = 5;
    private final static int INSURANCE = 22;
    private final static int CAR_EXPLORATION_PERIOD = 5;
    private final static int CAR_EXPLORATION_COST_EVERY_100KM = 10;

    /**
     * Getters of final variables
     * @return
     */
    public static int getCostOfOneFuel() {
        return COST_OF_ONE_FUEL;
    }

    public static int getInsurance() {
        return INSURANCE;
    }

    public static int getCarExplorationPeriod() {
        return CAR_EXPLORATION_PERIOD;
    }

    public static int getCarExplorationCostEvery100km() {
        return CAR_EXPLORATION_COST_EVERY_100KM;
    }
}

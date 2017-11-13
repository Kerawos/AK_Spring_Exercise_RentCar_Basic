package pl.akademiakodu.AK_Spring_Exercise_RentCar_Basic.models;

public class OverallManagement2017 {
    private static int costOfOneFuel = 5;
    private static int insurance = 22;
    private static int carExplorationPeriod = 5;
    private static int carExplorationCostEvery100km = 10;

    public static int getCostOfOneFuel() {
        return costOfOneFuel;
    }

    public static int getInsurance() {
        return insurance;
    }

    public static int getCarExplorationPeriod() {
        return carExplorationPeriod;
    }

    public static int getCarExplorationCostEvery100km() {
        return carExplorationCostEvery100km;
    }
}

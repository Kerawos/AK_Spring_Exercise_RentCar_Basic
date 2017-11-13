package pl.akademiakodu.AK_Spring_Exercise_RentCar_Basic.models;

public class CarAmortization {

    public static int dailyAmortization(int carValue){
        return carValue / (356 * OverallManagement2017.getCarExplorationPeriod()) > 10 ? carValue/(356 * OverallManagement2017.getCarExplorationPeriod()) : 10;
    }

    public static int distanceAmortization(int carValue, int passengerCapacity, int fuelConsumption){
        return carValue / ((OverallManagement2017.getCarExplorationCostEvery100km()) * ((passengerCapacity + fuelConsumption) * 25));
    }
}

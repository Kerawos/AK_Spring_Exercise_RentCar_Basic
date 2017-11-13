package pl.akademiakodu.AK_Spring_Exercise_RentCar_Basic.models.bags;

import pl.akademiakodu.AK_Spring_Exercise_RentCar_Basic.models.CarAmortization;

public class CarModel {

    private String model;
    private int dailyCost;
    private int costPer100Km;
    private int passengerCapacity;
    private int fuelConsumption;
    private int carValue;

    public CarModel(String model, int passengerCapacity, int fuelConsumption, int carValue) {
        this.model = model;
        this.dailyCost = CarAmortization.dailyAmortization(carValue);
        this.costPer100Km = CarAmortization.distanceAmortization(carValue, passengerCapacity, fuelConsumption);
        this.passengerCapacity = passengerCapacity;
        this.fuelConsumption = fuelConsumption;
        this.carValue = carValue;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getDailyCost() {
        return dailyCost;
    }

    public void setDailyCost(int dailyCost) {
        this.dailyCost = dailyCost;
    }

    public int getCostPer100Km() {
        return costPer100Km;
    }

    public void setCostPer100Km(int costPer100Km) {
        this.costPer100Km = costPer100Km;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public int getCarValue() {
        return carValue;
    }

    public void setCarValue(int carValue) {
        this.carValue = carValue;
    }
}

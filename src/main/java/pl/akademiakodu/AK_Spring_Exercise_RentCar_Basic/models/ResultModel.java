package pl.akademiakodu.AK_Spring_Exercise_RentCar_Basic.models;

/**
 * Class for holding results as object.
 */
public class ResultModel {

    /**
     * Variables declarations
     */
    private CarModel carModel;
    private int totalCost;
    private int extraDayCost;
    private int extraDistanceCostPer100Km;

    /**
     * constructors
     */
    public ResultModel(CarModel carModel, int totalCost, int extraDayCost, int extraDistanceCostPer100Km) {
        this.carModel = carModel;
        this.totalCost = totalCost;
        this.extraDayCost = extraDayCost;
        this.extraDistanceCostPer100Km = extraDistanceCostPer100Km;
    }

    /**
     * Getters and setters section
     */
    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public int getExtraDayCost() {
        return extraDayCost;
    }

    public void setExtraDayCost(int extraDayCost) {
        this.extraDayCost = extraDayCost;
    }

    public int getExtraDistanceCostPer100Km() {
        return extraDistanceCostPer100Km;
    }

    public void setExtraDistanceCostPer100Km(int extraDistanceCostPer100Km) {
        this.extraDistanceCostPer100Km = extraDistanceCostPer100Km;
    }
}

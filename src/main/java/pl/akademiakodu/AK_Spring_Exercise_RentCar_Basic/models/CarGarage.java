package pl.akademiakodu.AK_Spring_Exercise_RentCar_Basic.models;

/**
 * Imports section
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Class responsible for storage all available cars in this exercise
 */
public class CarGarage {

    /**
     * Variable declaration
     */
    private List<CarModel> availableModels;

    /**
     * Method gets available cars from gartge
     * @return car list
     */
    public List<CarModel> getAvailableModels() {
        availableModels = new ArrayList<>();
        availableModels.add(new CarModel("Fiat500", 2, 4, 50000));
        availableModels.add(new CarModel("Fiat124p",  4, 8, 5000));
        availableModels.add(new CarModel("MercedesVito",  9, 12, 150000));
        availableModels.add(new CarModel("RenaultClio",  5, 5, 40000));
        availableModels.add(new CarModel("AudiS6",  5, 16, 350000));
        availableModels.add(new CarModel("VWTouran",  7, 7, 90000));
        availableModels.add(new CarModel("SkodaSuperb",  5, 4, 110000));
        availableModels.add(new CarModel("SubaruImpreza", 5, 20, 220000));
        availableModels.add(new CarModel("PeugeotCC", 2, 6, 90000));
        return availableModels;
    }

    /**
     * Method calculating current cars available in garage
     * @return number of current car available
     */
    public int getNumberOfAvailableModels(){
        return getAvailableModels().size();
    }

}

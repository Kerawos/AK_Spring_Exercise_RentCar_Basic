package pl.akademiakodu.AK_Spring_Exercise_RentCar_Basic.models.services;

/**
 * Imports section
 */

import org.springframework.stereotype.Service;
import pl.akademiakodu.AK_Spring_Exercise_RentCar_Basic.models.CarGarage;
import pl.akademiakodu.AK_Spring_Exercise_RentCar_Basic.models.CarModel;
import pl.akademiakodu.AK_Spring_Exercise_RentCar_Basic.models.UserPreferencesModel;

import java.util.List;

/**
 * Service responsible for calculating optimal car to rent
 */
@Service
public class OptimalCarFounder {

    /**
     * Variables and services declarations
     */
    private List<CarModel> listOfPotentialCarsToRent;
    private int potentialLeftMoney;
    private int potentialTotalDailyCost;
    private int potentialDistanceCost;
    private CostCalculator costCalculator;
    private CarGarage carGarage;

    /**
     * Method calculating potential car to rent based on user inputs
     * @param userPreferencesModel stored user inputs
     * @return list of potential cars to rent
     */
    public List<CarModel> optimalCarsToRent(UserPreferencesModel userPreferencesModel){
        carGarage = new CarGarage();
        listOfPotentialCarsToRent = carGarage.getAvailableModels();
        costCalculator = new CostCalculator();
        for (int i = 0; i < listOfPotentialCarsToRent.size(); i++) {
            //1. check passenger capacity
            if (userPreferencesModel.getPassengerCapacity() > listOfPotentialCarsToRent.get(i).getPassengerCapacity()){
                listOfPotentialCarsToRent.remove(i);
                i--;
                continue;
            } else { //2. check if user have money for daily and distance car
                potentialDistanceCost = costCalculator.totalDistanceCost(userPreferencesModel.getProximalDistance(),
                        listOfPotentialCarsToRent.get(i).getCostPer100Km(), listOfPotentialCarsToRent.get(i).getFuelConsumption());
                potentialTotalDailyCost = costCalculator.dailyTotalRentCost(userPreferencesModel.getRentDuration(),
                        listOfPotentialCarsToRent.get(i).getDailyCost());
                potentialLeftMoney = userPreferencesModel.getMoneyForRent() - potentialDistanceCost - potentialTotalDailyCost;
                if (potentialLeftMoney<0){
                    listOfPotentialCarsToRent.remove(i);
                    i--;
                    continue;
                }
            }
        }
        return listOfPotentialCarsToRent;
    }


}
package pl.akademiakodu.AK_Spring_Exercise_RentCar_Basic.models;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import pl.akademiakodu.AK_Spring_Exercise_RentCar_Basic.models.bags.CarModel;
import pl.akademiakodu.AK_Spring_Exercise_RentCar_Basic.models.bags.ResultModel;
import pl.akademiakodu.AK_Spring_Exercise_RentCar_Basic.models.bags.UserPreferencesModel;

import java.util.ArrayList;
import java.util.List;

public class OptimalCarFounder {

    private List<CarModel> listOfPotentialCarsToRent;
    private int potentialLeftMoney;
    private int potentialTotalDailyCost;
    private int potentialDistanceCost;
    private CostCalculator costCalculator;


    public List<CarModel> optimalCarsToRent(UserPreferencesModel userPreferencesModel){
        listOfPotentialCarsToRent = CarGarage.getAvailableModels();
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

package pl.akademiakodu.AK_Spring_Exercise_RentCar_Basic.models.services;

import org.springframework.stereotype.Service;
import pl.akademiakodu.AK_Spring_Exercise_RentCar_Basic.models.CarModel;
import pl.akademiakodu.AK_Spring_Exercise_RentCar_Basic.models.ResultModel;
import pl.akademiakodu.AK_Spring_Exercise_RentCar_Basic.models.UserPreferencesModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Service responsible for calculating potential results
 */
@Service
public class ResultToUser {

    /**
     * Variables and services declarations
     */
    private List<ResultModel> resultList;
    private int potentialTotalDailyCost;
    private int potentialDistanceCost;
    private CostCalculator costCalculator;

    /**
     * Method calculating potential cars with all costs
     * @param potentialCarsToRent stored potential cars
     * @param userPreferencesModel stored user inputs
     * @return list of potential results (cars and costs)
     */
    public List<ResultModel> generateResults(List<CarModel> potentialCarsToRent, UserPreferencesModel userPreferencesModel){
        resultList = new ArrayList<>();
        costCalculator = new CostCalculator();

        for (int i = 0; i < potentialCarsToRent.size(); i++) {
            potentialDistanceCost = costCalculator.totalDistanceCost(userPreferencesModel.getProximalDistance(),
                    potentialCarsToRent.get(i).getCostPer100Km(), potentialCarsToRent.get(i).getFuelConsumption());
            potentialTotalDailyCost = costCalculator.dailyTotalRentCost(userPreferencesModel.getRentDuration(),
                    potentialCarsToRent.get(i).getDailyCost());
            resultList.add(new ResultModel(potentialCarsToRent.get(i), (potentialDistanceCost +
                    potentialTotalDailyCost), potentialCarsToRent.get(i).getDailyCost(), potentialCarsToRent.get(i).getCostPer100Km()));
        }
        return resultList;
    }

}
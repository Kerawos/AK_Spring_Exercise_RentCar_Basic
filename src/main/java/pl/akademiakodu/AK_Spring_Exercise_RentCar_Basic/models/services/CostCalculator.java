package pl.akademiakodu.AK_Spring_Exercise_RentCar_Basic.models.services;

/**
 * Imports section
 */
import org.springframework.stereotype.Service;
import pl.akademiakodu.AK_Spring_Exercise_RentCar_Basic.models.OverallManagement2017;

/**
 * Service responsible for overall cost connecting with rent
 */
@Service
public class CostCalculator {

    /**
     * Method calculating cost rent per one day of usage based on given params
     * @param userDailyRentTime
     * @param carDailyRentTime
     * @return daily cost
     */
    public int dailyTotalRentCost(int userDailyRentTime, int carDailyRentTime){
        return userDailyRentTime * carDailyRentTime;
    }

    /**
     * Method calculating cost amortization per every 100km based on given params
     * @param proximalDistance
     * @param carCostPer100Km
     * @return car amortization per every 100km
     */
    public int carAmortizationPer100Km(int proximalDistance, int carCostPer100Km){
        return carCostPer100Km * (proximalDistance/100);
    }

    /**
     * Method calculating cost fuel consumption per 100 km based on given params
     * @param proximalDistance
     * @param carFuelConsumption
     * @return fuel consumption per 100 km
     */
    public int costOfFuelConsumption(int proximalDistance, int carFuelConsumption){
        return ((carFuelConsumption * proximalDistance) / 100) * OverallManagement2017.getCostOfOneFuel() > 200 ?
                200 : ((carFuelConsumption * proximalDistance) / 100) * OverallManagement2017.getCostOfOneFuel();
    }

    /**
     * Method calculating total distance cost based on given params
     * @param proximalDistance
     * @param carCostPer100Km
     * @param carFuelConsumption
     * @return total distance cost
     */
    public int totalDistanceCost(int proximalDistance, int carCostPer100Km, int carFuelConsumption){
        return carAmortizationPer100Km(proximalDistance, carCostPer100Km) + costOfFuelConsumption(proximalDistance, carFuelConsumption);
    }

    /**
     * Method calculating total potential cost of rent based on given params
     * @param potentialTotalDistanceCost
     * @param potentialTotalDailyCost
     * @return total potential cost of rent
     */
    public int totalPodentialCost(int potentialTotalDistanceCost, int potentialTotalDailyCost){
        return potentialTotalDistanceCost + potentialTotalDailyCost;
    }

}

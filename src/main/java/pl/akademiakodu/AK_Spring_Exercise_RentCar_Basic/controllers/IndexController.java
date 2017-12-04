package pl.akademiakodu.AK_Spring_Exercise_RentCar_Basic.controllers;

/**
 * Import section
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.akademiakodu.AK_Spring_Exercise_RentCar_Basic.models.CarModel;
import pl.akademiakodu.AK_Spring_Exercise_RentCar_Basic.models.ResultModel;
import pl.akademiakodu.AK_Spring_Exercise_RentCar_Basic.models.UserPreferencesModel;
import pl.akademiakodu.AK_Spring_Exercise_RentCar_Basic.models.services.OptimalCarFounder;
import pl.akademiakodu.AK_Spring_Exercise_RentCar_Basic.models.services.ResultToUser;

import java.util.ArrayList;
import java.util.List;

/**
 * Control index page with exercise
 */
@Controller
public class IndexController {

    /**
     * Declaration services and variables
     */
    @Autowired OptimalCarFounder optimalCarFounder;
    @Autowired ResultToUser resultToUser;
    List<CarModel> potentialRentCarList;
    List<ResultModel> resultModelList;
    StringBuilder sb;

    /**
     * Method responsible for loading requested index template also get user inputs and stored it into given model
     * @param model stored user inputs
     * @return ready index template
     */
    @GetMapping("/") public String getIndex(Model model){
        model.addAttribute("userPreferencesModel", new UserPreferencesModel());
        return "index";
    }

    /**
     * ethod responsible to manage rent service logic
     * @param userPreferencesModel given user inputs
     * @param model to display messages to user
     * @return calculated results. Potential rent car costs.
     */
    @PostMapping("/") public String postIndex(@ModelAttribute UserPreferencesModel userPreferencesModel, Model model){

        //initializations
        potentialRentCarList = new ArrayList<>();
        resultModelList = new ArrayList<>();
        sb = new StringBuilder();

        potentialRentCarList = optimalCarFounder.optimalCarsToRent(userPreferencesModel);
        resultModelList = resultToUser.generateResults(potentialRentCarList, userPreferencesModel);

        model.addAttribute("message1", "Your Criteria match those cars:");
        for (int i = 0; i < resultModelList.size(); i++) {
            sb.append("CAR MODEL: " + resultModelList.get(i).getCarModel().getModel() +
            ", TOTAL COST: $" + resultModelList.get(i).getTotalCost() +
            ", COST PER EXTRA DAY: $" + resultModelList.get(i).getExtraDayCost() +
            ", COST PER EXTRA 100KM: $" + resultModelList.get(i).getExtraDistanceCostPer100Km() + "****");
        }
        model.addAttribute("message2", sb.toString());

        return "index";
    }


}

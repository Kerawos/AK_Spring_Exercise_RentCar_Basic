package pl.akademiakodu.AK_Spring_Exercise_RentCar_Basic.controllers;
/**
 * Import Section
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Control description
 */
@Controller
public class DescController {

    /**
     * Method to get description image from description template to user
     * @return description predefined template containing description of exercise
     */
    @GetMapping("/desc")
    public String descGet(){
        return "desc";
    }
}

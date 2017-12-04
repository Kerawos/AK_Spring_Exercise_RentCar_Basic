package pl.akademiakodu.AK_Spring_Exercise_RentCar_Basic.controllers;
/**
 * Import Section
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Control description template
 */
@Controller
public class DescController {

    /**
     * Method responsible for loading requested description template
     * @return desc template
     */
    @GetMapping("/desc")
    public String descGet(){
        return "desc";
    }
}

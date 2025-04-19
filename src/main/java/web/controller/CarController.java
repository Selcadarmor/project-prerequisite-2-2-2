package web.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

import java.util.Collections;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/cars")
    public String getCars(@RequestParam(name = "count",required = false, defaultValue = "5")int count, ModelMap model) {
        System.out.println("Получен параметр count = " + count);
        if(count < 0){
            System.out.println("Отрицательный count, возвращаем пустой список");
            model.addAttribute("cars", Collections.emptyList());
                return "cars";
        }
        model.addAttribute("cars", carService.getCars(count));
        return "cars";
    }
}

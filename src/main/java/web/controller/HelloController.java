package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.repository.CarRepository;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HelloController {
	@Autowired
	CarService carService;

	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {
		List<String> messages = new ArrayList<>();
		messages.add("Hello!");
		messages.add("I'm Spring MVC application");
		messages.add("5.2.0 version by sep'19");
		model.addAttribute("messages", messages);
		return "index";
	}

	@GetMapping("/cars")
	public String printCar(@RequestParam(value = "count", required = false, defaultValue = "1") @PathVariable(value = "count") Integer count, ModelMap model){
		List<Car> cars = carService.getCarRepository().getCars();
		if (count < 5 && count > 0){
			List<Car> mycars = cars.stream().limit(count).collect(Collectors.toList());
			model.addAttribute("cars", mycars);
		}
		else model.addAttribute("cars", cars);
		return "car";
	}
}

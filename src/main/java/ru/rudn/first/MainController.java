package ru.rudn.first;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    // автопривязка к CRUD операциям
    @Autowired
    private CityOperation operation;

    // http://127.0.0.1:8080/
    @GetMapping(path="/")
    public String bbb() {
        return "index";
    }

    @GetMapping(path="/test")
    public String test() {
        return "test";
    }

    // добавление города в таблицу
    @GetMapping(path="/add")
    @ResponseBody String addNewCity(@RequestParam String name) {
        City city = new City();
        city.setName(name);
        operation.save(city);
        return "Saved successefully!";
    }


    // получение всего списка из таблицы в формате JSON
    @GetMapping(path="/all")
    @ResponseBody Iterable<City> getAllCities() {
        return operation.findAll();
    }
}

package co.develhope.firstapi5.controllers;

import co.develhope.firstapi5.DTO.CarDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cars")
public class CarController{

    @GetMapping
    public CarDTO getCar(){
        CarDTO car = new CarDTO();
        car.setId("1");
        car.setModelName("Fiat 2001");
        car.setPrice(4500.00);
        return car;
    }

    @PostMapping
    public ResponseEntity<String> printCar(@Valid @RequestBody CarDTO car){

        if(car.getPrice() != 4500.00){
            return new ResponseEntity<>("Can't create car due to invalid pricing", HttpStatus.BAD_REQUEST);
        }
        System.out.println(car);
        return new ResponseEntity<>("Car created successfully", HttpStatus.CREATED);
    }
}
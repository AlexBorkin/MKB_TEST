package com.mcb.creditfactory.model;

import com.mcb.creditfactory.service.car.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Component
public class DataInit implements ApplicationRunner
{
    @Autowired
    private CarService carService;

    @Override
    public void run(ApplicationArguments args) throws Exception
    {
//        Car car_1 = new Car();
//
//        car_1.setBrand("Mercedes");
//
//        car_1.setModel("E-400");
//        car_1.setPower(400.2);
//        car_1.setYear((short) 2012);
//        car_1.setValue(new BigDecimal(54500.0));
//
//        carService.save(car_1);
//
//        Car car_2 = new Car();
//
//        car_2.setBrand("Mercedes");
//
//        car_2.setModel("C-320");
//        car_2.setPower(600.0);
//        car_2.setYear((short) 1992);
//        car_2.setValue(new BigDecimal(34500.0));
//
//        carService.save(car_2);

    }
}


package com.mcb.creditfactory.service;

import com.mcb.creditfactory.dto.AirplaneDto;
import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.dto.Collateral;
import com.mcb.creditfactory.service.airplane.AirplaneService;
import com.mcb.creditfactory.service.car.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

// TODO: reimplement this
@Service
public class CollateralService
{
    @Autowired
    private CarService carService;
    @Autowired
    private AirplaneService airplaneService;

    @SuppressWarnings("ConstantConditions")
    public Long saveCollateral(Collateral object)
    {
        if (object instanceof CarDto)
        {
            return carService.saveCollateral((CarDto) object);
        }
        else if (object instanceof AirplaneDto)
        {
            return airplaneService.saveCollateral((AirplaneDto) object);
        }
        else
        {
            return null;
        }
    }

    public Collateral getInfo(Collateral object)
    {
        if (object instanceof CarDto)
        {
            return carService.getInfo((CarDto) object);
        }
        else if (object instanceof AirplaneDto)
        {
            return airplaneService.getInfo((AirplaneDto) object);
        }
        else
        {
            return null;
        }
    }
}

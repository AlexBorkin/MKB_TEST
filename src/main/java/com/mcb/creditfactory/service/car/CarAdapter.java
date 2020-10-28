package com.mcb.creditfactory.service.car;

import com.mcb.creditfactory.dto.AirplaneDto;
import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.external.CollateralObject;
import com.mcb.creditfactory.external.CollateralType;
import com.mcb.creditfactory.model.AssessedValues;
import com.mcb.creditfactory.repository.CarRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@Data
public class CarAdapter implements CollateralObject
{
    private CarDto carDto;
    private AssessedValues assessedValues;

    public CarAdapter(CarDto carDto)
    {
        this.carDto    = carDto;
        this.assessedValues = carDto.getAssessedValues().stream()
                                    .max(AssessedValues::compareTo).get();
    }

    @Override
    public BigDecimal getValue()
    {
        return assessedValues != null ? assessedValues.getValue() : null;
    }

    @Override
    public Short getYear()
    {
        return carDto.getYear();
    }

    @Override
    public LocalDate getDate()
    {
        // Для автомобилей дата оценки не используется, поэтому всегда берем текущую
        return LocalDate.now();
    }

    @Override
    public CollateralType getType()
    {
        return CollateralType.CAR;
    }
}

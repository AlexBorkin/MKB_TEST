package com.mcb.creditfactory.service.airplane;

import com.mcb.creditfactory.dto.AirplaneDto;
import com.mcb.creditfactory.external.CollateralObject;
import com.mcb.creditfactory.external.CollateralType;
import com.mcb.creditfactory.model.Airplane;
import com.mcb.creditfactory.model.AssessedValues;
import com.mcb.creditfactory.repository.AirplaneRepository;
import com.mcb.creditfactory.repository.AssessedValueRepository;
import com.mcb.creditfactory.repository.CarRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

//@AllArgsConstructor
@Data
public class AirplaneAdapter implements CollateralObject
{
    //@Autowired
    private AirplaneDto airplane;
    @Autowired
    private AirplaneRepository airplaneRepository;
    @Autowired
    private AssessedValueRepository assessedValueRepository;

    public AirplaneAdapter(AirplaneDto airplane)
    {
        this.airplane = airplane;
    }

    //    private AssessedValues assessedValues
//            = assessedValueRepository.findFirstByCollateralParentAndTypeOrderByAssesedDateDesc(
//                    airplane.,
//            CollateralType.AIRPLANE)

    @Override
    public BigDecimal getValue()
    {
        return null;
    }

    @Override
    public Short getYear()
    {
        return airplane.getYear();
    }

    @Override
    public LocalDate getDate()
    {
        //TODO Максимальная дата оценки!
        return null;
    }

    @Override
    public CollateralType getType()
    {
        return CollateralType.AIRPLANE;
    }
}

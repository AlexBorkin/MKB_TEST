package com.mcb.creditfactory.service.airplane;

import com.mcb.creditfactory.dto.AirplaneDto;
import com.mcb.creditfactory.external.CollateralObject;
import com.mcb.creditfactory.external.CollateralType;
import com.mcb.creditfactory.model.AssessedValues;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class AirplaneAdapter implements CollateralObject
{
    private AirplaneDto airplaneDto;
    private AssessedValues assessedValues;

    public AirplaneAdapter(AirplaneDto airplaneDto)
    {
        this.airplaneDto    = airplaneDto;
        this.assessedValues = airplaneDto.getAssessedValues().stream()
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
        return airplaneDto.getYear();
    }

    @Override
    public LocalDate getDate()
    {
        return assessedValues != null ? assessedValues.getAssesedDate() : null;
    }

    @Override
    public CollateralType getType()
    {
        return CollateralType.AIRPLANE;
    }
}

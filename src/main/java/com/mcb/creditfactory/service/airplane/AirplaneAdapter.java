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
        if (assessedValues != null)
        {
            return assessedValues.getValue();
        }
        else
        {
            return null;
        }
    }

    @Override
    public Short getYear()
    {
        return airplaneDto.getYear();
    }

    @Override
    public LocalDate getDate()
    {
        if (assessedValues != null)
        {
            return assessedValues.getAssesedDate();
        }
        else
        {
            return null;
        }
    }

    @Override
    public CollateralType getType()
    {
        return CollateralType.AIRPLANE;
    }
}

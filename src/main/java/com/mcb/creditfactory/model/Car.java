package com.mcb.creditfactory.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mcb.creditfactory.external.CollateralType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CAR")
public class Car extends CollateralParent
{
    private Double power;

    public Car(Long id,
               String brand,
               String model,
               Double power,
               Short year,
               List<AssessedValues> assessedValues)
    {
        if (id != null)
        {
            this.setId(id);
        }

        this.setBrand(brand);
        this.setModel(model);
        this.power = power;
        this.setYear(year);
       // this.setType(CollateralType.CAR);
        this.setAssessedValues(assessedValues);
    }
}

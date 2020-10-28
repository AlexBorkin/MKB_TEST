package com.mcb.creditfactory.model;

import com.mcb.creditfactory.dto.Collateral;
import com.mcb.creditfactory.external.CollateralType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "AIRPLANE")
public class Airplane extends CollateralParent
{
    private String manufacturer;
    private Integer fuelcapacity;
    private Integer seats;

    public Airplane(Long id,
                    String brand,
                    String model,
                    String manufacturer,
                    Short year,
                    Integer fuelcapacity,
                    Integer seats,
                    List<AssessedValues> assessedValues)
    {
        if (id != null)
        {
            this.setId(id);
        }

        this.setBrand(brand);
        this.setModel(model);
        this.manufacturer = manufacturer;
        this.setYear(year);
        this.fuelcapacity = fuelcapacity;
        this.seats = seats;
        this.setAssessedValues(assessedValues);
    }

}

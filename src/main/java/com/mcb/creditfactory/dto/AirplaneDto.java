package com.mcb.creditfactory.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.mcb.creditfactory.external.CollateralType;
import com.mcb.creditfactory.model.AssessedValues;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonTypeName("airplane")
public class AirplaneDto implements Collateral
{
    private Long id;
    private String brand;
    private String model;
    private String manufacturer;
    private Short year;
    private Integer fuelcapacity;
    private Integer seats;

    private List<AssessedValues> assessedValues = new ArrayList<>();
}

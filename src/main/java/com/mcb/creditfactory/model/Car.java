package com.mcb.creditfactory.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CAR")
public class Car extends CollateralParent
{
//    private String brand;
//    private String model;
    private Double power;

//    @Column(name = "year_of_issue")
//    private Short year;
//
//    @Column(name = "assessed_value")
//    private BigDecimal value;

    public Car(Long id, String brand, String model, Double power, Short year, List<AssessedValues> assessedValues)
    {
        this.setId(id);
        this.setBrand(brand);
        this.setModel(model);
        this.power = power;
        this.setYear(year);
        this.setAssessedValues(assessedValues);

    }


    //    @Override
//    public long getId()
//    {
//        return super.getId();
//    }
//
//    @Override
//    public List<AssessedValues> getAssessedValues()
//    {
//        return super.getAssessedValues();
//    }

    //    public Car()
//    {
//    }
//
//    public Car(Long id, String brand, String model, Double power, List<AssessedValues> assessedValues)
//    {
//
//    }

//    @Column(name = "year_of_issue")
//    private Short year;
//
//    @Column(name = "assessed_value")
//    private BigDecimal value;

//    public Car(Long id, String brand, String model, Double power, Short year, BigDecimal value)
//    {
//    }
//
//    public Car(Long id,
//               String brand,
//               String model,
//               Double power,
//               Short year,
//               BigDecimal value,
//               List<AssessedValues> assessedValues)
//    {
//
//    }

//    @JsonIgnore
//   @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//   @JoinColumn(name = "assessed_valueid")
//    private List<AssessedValues> assessedValues = new ArrayList<>();

//
//    @Override
//    public long getId()
//    {
//        return super.getId();
//    }
//
//    @Override
//    public List<AssessedValues> getAssessedValues()
//    {
//        return super.getAssessedValues();
//    }
}

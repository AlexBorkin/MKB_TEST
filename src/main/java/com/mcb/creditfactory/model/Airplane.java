package com.mcb.creditfactory.model;

import com.mcb.creditfactory.dto.Collateral;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//@DiscriminatorValue("AIRPLANE")
@Table(name = "AIRPLANE")
public class Airplane extends CollateralParent
{
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long Id;

//    private String brand;
//    private String model;
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

        this.setId(id);
        this.setBrand(brand);
        this.setModel(model);
        this.manufacturer = manufacturer;
        this.setYear(year);
        this.fuelcapacity = fuelcapacity;
        this.seats = seats;
        this.setAssessedValues(assessedValues);

    }

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "assessed_values_itemid")
//    private List<AssessedValues> assessedValues = new ArrayList<>();
}

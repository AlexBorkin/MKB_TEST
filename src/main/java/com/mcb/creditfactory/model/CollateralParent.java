package com.mcb.creditfactory.model;

import com.mcb.creditfactory.dto.Collateral;
import com.mcb.creditfactory.external.CollateralType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
//@MappedSuperclass
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
@Table(name = "COLLATERAL_PARENT")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class CollateralParent
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private CollateralType type;

    private String brand;
    private String model;
    private Short year;


    @OneToMany(mappedBy = "collateralParent", targetEntity = AssessedValues.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  //  @JoinColumn(name = "item_Id")
    private List<AssessedValues> assessedValues = new ArrayList<>();

}

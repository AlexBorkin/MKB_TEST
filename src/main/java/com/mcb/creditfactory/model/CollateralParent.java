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
import java.util.Set;
import java.util.TreeSet;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "COLLATERAL_PARENT")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class CollateralParent
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
  
    private String brand;
    private String model;
    @Column(name = "year_of_issue")
    private Short year;

    @OneToMany(mappedBy = "collateralParent",
               targetEntity = AssessedValues.class,
               cascade = CascadeType.ALL,
               fetch = FetchType.LAZY)
   private List<AssessedValues> assessedValues = new ArrayList<>();

}

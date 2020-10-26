package com.mcb.creditfactory.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mcb.creditfactory.dto.Collateral;
import com.mcb.creditfactory.external.CollateralType;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "ASSESSED_VALUES")
public class AssessedValues
{
//    @EmbeddedId
//    private AssessedId assessedId;

    @Id
    private long id;

    private BigDecimal value;

    //private long collateralId;
    private CollateralType type;

    //@JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate assesedDate;

    @ManyToOne(targetEntity = CollateralParent.class)
  // @Column(name = "collateral_id")
    @JoinColumn(name = "collateral_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_value_id"))
    private CollateralParent collateralParent;

//    @ManyToOne
//    private Car car;
//
//    @ManyToOne
//    private Airplane airplane;
}

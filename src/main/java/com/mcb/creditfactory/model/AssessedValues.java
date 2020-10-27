package com.mcb.creditfactory.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mcb.creditfactory.dto.Collateral;
import com.mcb.creditfactory.external.CollateralType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ASSESSED_VALUES",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"collateral_id", "assesedDate"},
                                                name = "collateralid_date")})
public class AssessedValues implements Comparable<AssessedValues>
{
    @Override
    public int compareTo(AssessedValues o)
    {
        return this.getAssesedDate().compareTo(o.getAssesedDate());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private BigDecimal value;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate assesedDate;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "collateral_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_Collateral_Id"))
    @JsonIgnore
    private CollateralParent collateralParent;

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof AssessedValues))
        {
            return false;
        }

        AssessedValues that = (AssessedValues) o;

        return assesedDate.equals(that.assesedDate);
    }

    @Override
    public int hashCode()
    {
        return assesedDate.hashCode();
    }

    //    @Override
//    public boolean equals(Object o)
//    {
//        if (this == o)
//        {
//            return true;
//        }
//        if (!(o instanceof AssessedValues))
//        {
//            return false;
//        }
//
//        AssessedValues that = (AssessedValues) o;
//
//        if (!assesedDate.equals(that.assesedDate))
//        {
//            return false;
//        }
//        return collateralParent.equals(that.collateralParent);
//    }
//
//    @Override
//    public int hashCode()
//    {
//        int result = assesedDate.hashCode();
//        result = 31 * result + collateralParent.hashCode();
//        return result;
//    }
}

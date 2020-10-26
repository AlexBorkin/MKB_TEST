package com.mcb.creditfactory.model;

import com.mcb.creditfactory.external.CollateralType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
@Data
@NoArgsConstructor
public class AssessedId implements Serializable
{
    private static final long serialVersionUID = 1L;

    //@ManyToOne
  //  @Column(name = "item_id")
    @ManyToOne(targetEntity = CollateralParent.class)
    @JoinColumn(name = "item_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_Collateral_Id"))
    private long itemId;
    private CollateralType type;
    private LocalDate assesedDate;

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof AssessedId))
        {
            return false;
        }

        AssessedId that = (AssessedId) o;

        if (itemId != that.itemId)
        {
            return false;
        }
        if (type != that.type)
        {
            return false;
        }
        return assesedDate.equals(that.assesedDate);
    }

    @Override
    public int hashCode()
    {
        int result = (int) (itemId ^ (itemId >>> 32));
        result = 31 * result + type.hashCode();
        result = 31 * result + assesedDate.hashCode();
        return result;
    }
}

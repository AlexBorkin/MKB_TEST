package com.mcb.creditfactory.repository;

import com.mcb.creditfactory.external.CollateralType;
import com.mcb.creditfactory.model.AssessedValues;
import com.mcb.creditfactory.model.CollateralParent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssessedValueRepository extends CrudRepository<AssessedValues, Long>
{
    AssessedValues findFirstByCollateralParentOrderByAssesedDateDesc(CollateralParent id);

    List<AssessedValues> findByCollateralParentOrderByAssesedDateDesc(CollateralParent id);


}

package com.mcb.creditfactory.repository;

import com.mcb.creditfactory.model.AssessedValues;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssessedValueRepository extends CrudRepository<AssessedValues, Long>
{
}

package com.mcb.creditfactory.service;

import com.mcb.creditfactory.dto.Collateral;
import java.util.Optional;

public interface ICollateralService<Dto, T>
{
    Long saveCollateral(Dto dto);

    Collateral getInfo(Dto dto);

    boolean approve(Dto dto);

    T save(T t);

    Optional<T> load(Long id);

    T fromDto(Dto dto);

    Dto toDTO(T t);

    Long getId(T t);
}

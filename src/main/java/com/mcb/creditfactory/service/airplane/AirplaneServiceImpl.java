package com.mcb.creditfactory.service.airplane;
import com.mcb.creditfactory.dto.AirplaneDto;
import com.mcb.creditfactory.dto.Collateral;
import com.mcb.creditfactory.external.ExternalApproveService;
import com.mcb.creditfactory.model.Airplane;
import com.mcb.creditfactory.model.AssessedValues;
import com.mcb.creditfactory.repository.AirplaneRepository;
import com.mcb.creditfactory.repository.AssessedValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class AirplaneServiceImpl implements AirplaneService
{
    @Autowired
    private ExternalApproveService approveService;

    @Autowired
    private AirplaneRepository airplaneRepository;

    @Override
    public boolean approve(AirplaneDto dto)
    {
        return approveService.approve(new AirplaneAdapter(dto)) == 0;
    }

    @Override
    public Airplane save(Airplane airplane)
    {
        return airplaneRepository.save(airplane);
    }

    @Override
    public Optional<Airplane> load(Long id)
    {
        return airplaneRepository.findById(id);
    }

    @Override
    public Airplane fromDto(AirplaneDto dto)
    {
        return new Airplane(
                dto.getId(),
                dto.getBrand(),
                dto.getModel(),
                dto.getManufacturer(),
                dto.getYear(),
                dto.getFuelcapacity(),
                dto.getSeats(),
                dto.getAssessedValues());
    }

    @Override
    public AirplaneDto toDTO(Airplane airplane)
    {
        return new AirplaneDto(
                airplane.getId(),
                airplane.getBrand(),
                airplane.getModel(),
                airplane.getManufacturer(),
                airplane.getYear(),
                airplane.getFuelcapacity(),
                airplane.getSeats(),
                airplane.getAssessedValues());
    }

    @Override
    public Long getId(Airplane airplane)
    {
        return airplane.getId();
    }

    @Override
    public Long saveCollateral(AirplaneDto airplaneDto)
    {
//        if (airplaneDto.getId() != null)
//        {
//            Airplane airplaneCurr = airplaneRepository.findById(airplaneDto.getId()).orElse(null);
//
//            List<AssessedValues> list = Stream.concat(airplaneCurr.getAssessedValues().stream(),
//                                                      airplaneDto.getAssessedValues().stream())
//                                                       .sorted(Comparator.comparing(AssessedValues::getAssesedDate))
//                                                       .collect(Collectors.toList());
//            airplaneDto.setAssessedValues(list);
//        }

        boolean approved = this.approve(airplaneDto);

        if (!approved)
        {
            return null;
        }

        return Optional.of(airplaneDto)
                .map(this::fromDto)
                .map(airplane ->
                {
                    List<AssessedValues> list = airplane.getAssessedValues().stream()
                                                    .map(assessedValues ->
                                                    {
                                                        assessedValues.setCollateralParent(airplane);
                                                        return assessedValues;
                                                    }).collect(Collectors.toList());

                    airplane.setAssessedValues(list);

                    return airplane;
                })
                .map(this::save)
                .map(this::getId)
                .orElse(null);
    }

    @Override
    public Collateral getInfo(AirplaneDto airplaneDto)
    {
        if (!(airplaneDto instanceof AirplaneDto))
        {
            throw new IllegalArgumentException();
        }

        return Optional.of(airplaneDto)
                .map(this::fromDto)
                .map(this::getId)
                .flatMap(this::load)
                .map(this::toDTO)
                .orElse(null);
    }
}

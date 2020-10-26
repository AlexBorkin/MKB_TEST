package com.mcb.creditfactory.service.airplane;

import com.mcb.creditfactory.dto.AirplaneDto;
import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.dto.Collateral;
import com.mcb.creditfactory.external.ExternalApproveService;
import com.mcb.creditfactory.model.Airplane;
import com.mcb.creditfactory.model.Car;
import com.mcb.creditfactory.repository.AirplaneRepository;
import com.mcb.creditfactory.repository.CarRepository;
import com.mcb.creditfactory.service.car.CarAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        boolean approved = this.approve(airplaneDto);

        if (!approved)
        {
            return null;
        }

        return Optional.of(airplaneDto)
                .map(this::fromDto)
                .map(this::save)
                .map(this::getId)
                .orElse(null);
    }

    @Override
    public Collateral getInfo(AirplaneDto airplaneDto)
    {
        return null;
    }
}

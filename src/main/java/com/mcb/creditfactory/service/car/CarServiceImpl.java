package com.mcb.creditfactory.service.car;

import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.dto.Collateral;
import com.mcb.creditfactory.external.ExternalApproveService;
import com.mcb.creditfactory.model.AssessedValues;
import com.mcb.creditfactory.model.Car;
import com.mcb.creditfactory.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private ExternalApproveService approveService;

    @Autowired
    private CarRepository carRepository;

    @Override
    public boolean approve(CarDto dto) {
        return approveService.approve(new CarAdapter(dto, carRepository)) == 0;
    }

    @Override
    public Car save(Car car)
    {
        return carRepository.save(car);
    }

    @Override
    public Optional<Car> load(Long id) {
        return carRepository.findById(id);
    }

    @Override
    public Car fromDto(CarDto dto) {
        return new Car(
                dto.getId(),
                dto.getBrand(),
                dto.getModel(),
                dto.getPower(),
                dto.getYear(),
                dto.getAssessedValues()
        );
    }

    @Override
    public CarDto toDTO(Car car) {
        return new CarDto(
                car.getId(),
                car.getBrand(),
                car.getModel(),
                car.getPower(),
                car.getYear(),
                car.getAssessedValues()
        );
    }

    @Override
    public Long getId(Car car) {
        return car.getId();
    }

    @Override
    public Long saveCollateral(CarDto carDto)
    {
        boolean approved = this.approve(carDto);

        if (!approved)
        {
            return null;
        }

        return Optional.of(carDto)
                .map(this::fromDto)
                .map(this::save)
                .map(car ->
                {
                    List<AssessedValues> list = car.getAssessedValues().stream()
                            .map(assessedValues ->
                            {
                                assessedValues.setCollateralParent(car);
                                return assessedValues;
                            }).collect(Collectors.toList());

                    car.setAssessedValues(list);

                    return car;
                })
                .map(this::getId)
                .orElse(null);
    }

    @Override
    public Collateral getInfo(CarDto carDto)
    {
        if (!(carDto instanceof CarDto))
        {
            throw new IllegalArgumentException();
        }

        return Optional.of(carDto)
                .map(this::fromDto)
                .map(this::getId)
                .flatMap(this::load)
                .map(this::toDTO)
                .orElse(null);
    }
}

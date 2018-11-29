package carservice.web.service.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import carservice.web.data.model.Car;
import carservice.web.data.repository.CarRepository;

@Service
@Transactional(readOnly=false)
public class CarServiceTx {

    @Autowired
    private CarRepository carRepository;

    public void createCar(Car car) {
        carRepository.save(car);
    }

}

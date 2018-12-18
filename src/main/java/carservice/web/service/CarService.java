package carservice.web.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carservice.web.data.model.Car;
import carservice.web.data.model.ServiceItem;
import carservice.web.data.repository.CarRepository;
import carservice.web.service.tx.CarServiceTx;

@Service
public class CarService {

    @Autowired
    private CarServiceTx carServiceTx;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    public void saveCar(Car car) {
        carServiceTx.saveCar(car);
    }

    public List<Car> getAllCarsByUserId(long userId) {
        List<Car> result = getSession()
                .createNamedQuery(Car.FIND_ALL_CARS_BY_USER_ID, Car.class)
                .setParameter("userId", userId)
                .getResultList();
        return result;
    }

    public Optional<Car> getCarById(long carId) {
        return carRepository.findById(carId);
    }

    public void deleteCarById(long carId) {
        carServiceTx.deleteCarById(carId);
    }

    public void createServiceItem(ServiceItem serviceItem) {

    }

    public List<ServiceItem> getServiceItems(long carId) {
        return null;
    }

}

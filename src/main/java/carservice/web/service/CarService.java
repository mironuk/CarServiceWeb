package carservice.web.service;

import java.util.List;
import java.util.Optional;

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

	public void createCar(Car car) {
		carServiceTx.createCar(car);
	}

	public List<Car> getCars() {
		return carRepository.findAll();
	}

	public Optional<Car> getCar(long carId) {
		return carRepository.findById(carId);
	}

	public void createServiceItem(ServiceItem serviceItem) {
		
	}

	public List<ServiceItem> getServiceItems(long carId) {
		return null;
	}

}

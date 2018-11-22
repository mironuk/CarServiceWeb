package carservice.web.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import carservice.web.data.model.Car;

public interface CarRepository extends JpaRepository<Car, Long> {

}

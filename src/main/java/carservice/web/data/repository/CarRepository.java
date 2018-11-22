package carservice.web.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import carservice.web.data.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

}

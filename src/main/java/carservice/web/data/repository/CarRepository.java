package carservice.web.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import carservice.web.data.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findAllCarsByUserId(@Param("userId") Long userId);

}

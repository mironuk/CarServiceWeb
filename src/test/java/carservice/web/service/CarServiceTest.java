package carservice.web.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import carservice.web.data.model.Car;
import carservice.web.data.model.User;
import carservice.web.data.repository.CarRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarServiceTest {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CarService carService;

    @Before
    public void init() {
        carRepository.deleteAll();
    }

    @Test
    public void testCreateCar() {
        // Arrange
        Car car = new Car();
        User user = new User();
        user.setUserId(1L);
        car.setUser(user);
        car.setMake("Mazda");
        car.setModel("3");
        car.setYear(2004);

        // Act
        carService.createCar(car);

        // Assert
        long carId = car.getCarId();
        Car testCar = carService.getCar(carId).get();
        assertNotNull(testCar);

        assertEquals("Mazda", testCar.getMake());
        assertEquals("3", testCar.getModel());
        assertEquals(2004, testCar.getYear());
    }

}

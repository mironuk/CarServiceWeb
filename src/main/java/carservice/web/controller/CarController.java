package carservice.web.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import carservice.web.data.dto.CarDto;
import carservice.web.data.model.Car;
import carservice.web.service.CarService;

@RestController()
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/rest", consumes = { "*/*", "application/json" }, produces = "application/json")
public class CarController extends AbstractController {

    private static final int MIN_CAR_YEAR = 1950;

    @Autowired
    private CarService carService;

    // TODO: implement this method somewhere else
    private static long getCurrentUserId() {
        return 1;
    }

    @GetMapping("/car/{carId}")
    public ResponseEntity<?> getCar(@PathVariable("carId") String carIdString) {
        try {
            long carId = Long.valueOf(carIdString);
            Optional<Car> optionalCar = carService.getCarById(carId);
            if (!optionalCar.isPresent()) {
                return errorResponse("Car not found for this carId", HttpStatus.NOT_FOUND);
            }
            Car car = optionalCar.get();
            CarDto carDto = carEntityToCarDto(car);
            String bodyJson = gson.toJson(carDto, CarDto.class);
            return ResponseEntity.ok(bodyJson);
        } catch (NumberFormatException ex) {
            return errorResponse("Wrong parameter", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/list-cars")
    public String getCars() {
        List<Car> cars = carService.getAllCarsByUserId(getCurrentUserId());
        List<CarDto> carDtos = new ArrayList<CarDto>();
        for (Car car : cars) {
            carDtos.add(carEntityToCarDto(car));
        }
        return gson.toJson(carDtos, List.class);
    }

    @PostMapping("/save-car")
    public ResponseEntity<?> saveCar(@RequestBody String carJson) {
        CarDto carDto = gson.fromJson(carJson, CarDto.class);
        if (isEmpty(carDto.getMake())) {
            return validationFailedResponse("Validation failed: make is empty");
        } else if (isEmpty(carDto.getModel())) {
            return validationFailedResponse("Validation failed: model is empty");
        } else if (!isEmpty(carDto.getYear()) && !isYearValid(carDto.getYear())) {
            return validationFailedResponse("Validation failed: year is wrong");
        } else {
            Car car = carDtoToCarEntity(carDto);
            carService.saveCar(car);
            return ResponseEntity.ok(EMPTY_JSON);
        }
    }

    private boolean isYearValid(String yearString) {
        if (yearString == null) {
            return true;
        }
        if (yearString.trim().equals("")) {
            return true;
        }
        try {
            int currentYear = new GregorianCalendar().get(Calendar.YEAR);
            int year = Integer.valueOf(yearString.trim());
            return year >= MIN_CAR_YEAR && year <= currentYear;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    @DeleteMapping(value="/car/{carId}")
    public ResponseEntity<?> deleteCarById(@PathVariable("carId") long carId) {
        carService.deleteCarById(carId);
        return ResponseEntity.ok(EMPTY_JSON);
    }

}

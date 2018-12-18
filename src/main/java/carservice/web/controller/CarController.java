package carservice.web.controller;

import java.util.ArrayList;
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
import carservice.web.data.model.User;
import carservice.web.service.CarService;

@RestController()
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/rest", consumes = { "*/*", "application/json" }, produces = "application/json")
public class CarController extends AbstractController {

    @Autowired
    private CarService carService;

    @GetMapping("/car/{carId}")
    public ResponseEntity<?> getCar(@PathVariable("carId") String carIdString) {
        try {
            long carId = Long.valueOf(carIdString);
            Optional<Car> optionalCar = carService.getCar(carId);
            if (!optionalCar.isPresent()) {
                return errorResponse("Car not found for this carId", HttpStatus.NOT_FOUND);
            }
            Car car = carService.getCar(carId).get();
            CarDto carDto = carEntityToCarDto(car);
            String bodyJson = gson.toJson(carDto, CarDto.class);
            return ResponseEntity.ok(bodyJson);
        } catch (NumberFormatException ex) {
            return errorResponse("Wrong parameter", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/list-cars")
    public String getCars() {
        // TODO: get cars for one user only
        List<Car> cars = carService.getCars();
        List<CarDto> carDtos = new ArrayList<CarDto>();
        for (Car car : cars) {
            carDtos.add(carEntityToCarDto(car));
        }
        return gson.toJson(carDtos, List.class);
    }

    @PostMapping("/save-car")
    public ResponseEntity<?> saveCar(@RequestBody String carJson) {
        System.out.println("saveCar() method started.");
        CarDto carDto = gson.fromJson(carJson, CarDto.class);
        System.out.println(carDto);
        // TODO: validation
        Car car = carDtoToCarEntity(carDto);
        if (carDto.getYear() == null) {
            return validationFailedResponse("Validation failed");
        } else {
            carService.saveCar(car);
            return ResponseEntity.ok(EMPTY_JSON);
        }
    }

    @DeleteMapping(value="/car/{carId}")
    public ResponseEntity<?> deleteCarById(@PathVariable("carId") long carId) {
        carService.deleteCarById(carId);
        return ResponseEntity.ok(EMPTY_JSON);
    }

    private ResponseEntity<String> validationFailedResponse(String validationErrorMessage) {
        return errorResponse(validationErrorMessage, HttpStatus.PRECONDITION_FAILED);
    }

    private ResponseEntity<String> errorResponse(String errorMessage, HttpStatus httpStatus) {
        String bodyJson = gson.toJson(new ResponseErrorMessage(errorMessage));
        return new ResponseEntity<String>(bodyJson, httpStatus);
    }

    private Car carDtoToCarEntity(CarDto carDto) {
        User user = new User();
        user.setUserId(carDto.getUserId());

        Car car = new Car();
        car.setCarId(carDto.getCarId());
        car.setUser(user);
        car.setNickname(trim(carDto.getNickname()));
        car.setVin(trim(carDto.getVin()));
        car.setLicensePlate(trim(carDto.getLicensePlate()));
        car.setMake(trim(carDto.getMake()));
        car.setModel(trim(carDto.getModel()));
        car.setYear(getIntegerFromString(carDto.getYear()));
        car.setColor(trim(carDto.getColor()));
        car.setDescription(trim(carDto.getDescription()));
        return car;
    }

    private Integer getIntegerFromString(String str) {
        if (str == null) {
            return null;
        }
        String trimmed = trim(str);
        if (trimmed.equals("")) {
            return null;
        }
        return Integer.valueOf(trimmed);
    }

    private String trim(String str) {
        return str != null ? str.trim() : null;
    }

    private CarDto carEntityToCarDto(Car car) {
        CarDto carDto = new CarDto();
        carDto.setCarId(car.getCarId());
        carDto.setUserId(car.getUser().getUserId());
        carDto.setNickname(car.getNickname());
        carDto.setVin(car.getVin());
        carDto.setLicensePlate(car.getLicensePlate());
        carDto.setMake(car.getMake());
        carDto.setModel(car.getModel());
        carDto.setYear(String.valueOf(car.getYear()));
        carDto.setColor(car.getColor());
        carDto.setDescription(car.getDescription());
        return carDto;
    }

}

class ResponseErrorMessage {

    private String message;

    public ResponseErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

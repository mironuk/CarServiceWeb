package carservice.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.google.gson.Gson;

import carservice.web.data.dto.CarDto;
import carservice.web.data.model.Car;
import carservice.web.data.model.User;

public abstract class AbstractController {

    protected static final Gson gson = new Gson();

    protected static final String EMPTY_JSON = "{}";

    protected static ResponseEntity<String> validationFailedResponse(String validationErrorMessage) {
        return errorResponse(validationErrorMessage, HttpStatus.BAD_REQUEST);
    }

    protected static ResponseEntity<String> errorResponse(String errorMessage, HttpStatus httpStatus) {
        String bodyJson = gson.toJson(new ResponseErrorMessage(errorMessage));
        return new ResponseEntity<String>(bodyJson, httpStatus);
    }

    protected static Car carDtoToCarEntity(CarDto carDto) {
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

    protected static CarDto carEntityToCarDto(Car car) {
        CarDto carDto = new CarDto();
        carDto.setCarId(car.getCarId());
        carDto.setUserId(car.getUser().getUserId());
        carDto.setNickname(car.getNickname());
        carDto.setVin(car.getVin());
        carDto.setLicensePlate(car.getLicensePlate());
        carDto.setMake(car.getMake());
        carDto.setModel(car.getModel());
        carDto.setYear(getStringFromInteger(car.getYear()));
        carDto.setColor(car.getColor());
        carDto.setDescription(car.getDescription());
        return carDto;
    }

    /**
     * Returns null if string parameter is null or trimmed string is empty.
     */
    protected static String trim(String str) {
        if (str == null) {
            return null;
        }
        String result = str.trim();
        if (result.isEmpty()) {
            return null;
        }
        return result;
    }

    protected static Integer getIntegerFromString(String str) {
        if (str == null) {
            return null;
        }
        String trimmed = trim(str);
        if (trimmed.equals("")) {
            return null;
        }
        return Integer.valueOf(trimmed);
    }

    protected static String getStringFromInteger(Integer num) {
        if (num == null) {
            return null;
        }
        return String.valueOf(num);
    }

    protected boolean isEmpty(String str) {
        return str == null || str.equals("");
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

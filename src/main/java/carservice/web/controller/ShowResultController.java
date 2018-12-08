package carservice.web.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import carservice.web.data.dto.TextWrapperDto;

@RestController()
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/rest", produces = "application/json")
public class ShowResultController {

    private static Gson gson = new Gson();

    @GetMapping(path = "/show-result")
    public String showResult() {
        TextWrapperDto textWrapperDto = new TextWrapperDto();
        textWrapperDto.setText("Pi = 3.14159265358979323846");
        return gson.toJson(textWrapperDto, TextWrapperDto.class);
    }

}

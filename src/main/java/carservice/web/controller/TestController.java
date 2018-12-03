package carservice.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import carservice.web.data.dto.TextDto;

@RestController()
@RequestMapping(path="/rest", produces = "application/json")
public class TestController {

    private static Gson gson = new Gson();

    @GetMapping(path = "/show-result")
    public String showResult() {
        TextDto textDto = new TextDto();
        textDto.setText("Pi = 3.14159265358979323846");
        return gson.toJson(textDto, TextDto.class);
    }

}

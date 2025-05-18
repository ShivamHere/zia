package com.teamified.zia.controller;

import com.teamified.zia.objects.WeatherResponse;
import com.teamified.zia.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/weather")
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @GetMapping
    public ResponseEntity<WeatherResponse> getWeather(@RequestParam(defaultValue = "Melbourne") String city){
        WeatherResponse response =  weatherService.getWeather(city);
        return ResponseEntity.ok(response);
    }
}

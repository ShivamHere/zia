package com.teamified.zia.service;

import com.teamified.zia.weather.WeatherHandler;
import com.teamified.zia.objects.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
    private final WeatherHandler entryPointHandler;

    @Autowired
    public WeatherService(WeatherHandler entryPointHandler) {
        this.entryPointHandler = entryPointHandler;
    }

    public WeatherResponse getWeather(String city) {
        return entryPointHandler.getWeather(city); // Start the chain
    }
}

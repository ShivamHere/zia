package com.teamified.zia.weather;

import com.teamified.zia.objects.WeatherResponse;
import org.springframework.stereotype.Component;

@Component
public class StaleCacheHandler extends WeatherHandler{

    @Override
    public WeatherResponse getWeather(String city) {
        return WeatherCachingHandler.getCachedResponse();
    }
}

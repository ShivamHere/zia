package com.teamified.zia.weather;

import com.teamified.zia.objects.WeatherResponse;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
public class WeatherCachingHandler extends WeatherHandler {
    @Getter
    private static WeatherResponse cachedResponse;
    private static long cachedAt;

    @Override
    public WeatherResponse getWeather(String city) {
        long now = System.currentTimeMillis();

        if (cachedResponse != null && now - cachedAt <= 3000) {
            System.out.println("Returning from cache");
            return cachedResponse;
        }

        WeatherResponse response = next.getWeather(city);
        cachedResponse = response;
        cachedAt = now;
        return response;
    }
}

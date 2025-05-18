package com.teamified.zia.weather;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class WeatherChainConfig {

    @Bean
    @Primary
    public WeatherHandler weatherHandler(
            WeatherCachingHandler caching,
            WeatherStackHandler weatherStack,
            OpenWeatherMapHandler openWeather,
            StaleCacheHandler stale
    ) {
        caching.setNext(weatherStack);
        weatherStack.setNext(openWeather);
        openWeather.setNext(stale);
        return caching; // top of chain
    }
}

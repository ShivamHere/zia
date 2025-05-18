package com.teamified.zia.weather;

import com.teamified.zia.objects.WeatherResponse;

public abstract class WeatherHandler {
    protected WeatherHandler next;

    public void setNext(WeatherHandler next) {
        this.next = next;
    }

    public abstract WeatherResponse getWeather(String city);
}

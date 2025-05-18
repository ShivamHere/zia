package com.teamified.zia.objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class WeatherResponse {
    @JsonProperty("wind_speed")
    private int windSpeed;
    @JsonProperty("temperature_degrees")
    private int temperatureDegrees;
}

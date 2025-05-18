package com.teamified.zia.weather;

import com.fasterxml.jackson.databind.JsonNode;
import com.teamified.zia.objects.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherStackHandler extends WeatherHandler {

    @Autowired
    RestTemplate restTemplate;

    @Value("${api.key.ws}")
    private String apiKey;

    @Override
    public WeatherResponse getWeather(String city) {
        try {
            // Call WeatherStack API
            String url = "http://api.weatherstack.com/current?access_key="+
                    apiKey+"&query=" + city;

            ResponseEntity<JsonNode> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    JsonNode.class
            );

            JsonNode root = response.getBody();
            assert root != null;
            JsonNode current = root.get("current");

            int temperature = current.get("temperature").asInt();
            int windSpeed = current.get("wind_speed").asInt();

            return new WeatherResponse(temperature, windSpeed);
        } catch (Exception e) {
            return next != null ? next.getWeather(city) : null;
        }
    }
}

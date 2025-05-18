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
public class OpenWeatherMapHandler extends WeatherHandler{

    @Value("${api.key.ow}")
    private String apiKey;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public WeatherResponse getWeather(String city) {
        try{
            String url = "https://api.openweathermap.org/data/2.5/weather?q="+
                    city+"&appid="+apiKey+"&units=metric";
            ResponseEntity<JsonNode> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    JsonNode.class
            );

            JsonNode root = response.getBody();
            assert root != null;
            JsonNode main = root.get("main"), wind = root.get("wind");

            int temperature = main.get("temp").asInt();
            int windSpeed = wind.get("speed").asInt();

            return new WeatherResponse(temperature, windSpeed);
        } catch (Exception e) {
            return next != null ? next.getWeather(city) : null;
        }
    }
}

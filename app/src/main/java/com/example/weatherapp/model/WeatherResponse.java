package com.example.weatherapp.model;

import java.util.List;

public class WeatherResponse {
    private List<Weather> weather;
    private Main main;
    private Wind wind;
    private String name;


    //Getter methods
    public List<Weather> getWeather() {
        return weather;
    }

    public Main getMain() {
        return main;
    }

    public Wind getWind() {
        return wind;
    }

    public String getName() {
        return name;
    }

}

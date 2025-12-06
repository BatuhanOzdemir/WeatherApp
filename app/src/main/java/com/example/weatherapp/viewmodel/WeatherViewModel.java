package com.example.weatherapp.viewmodel;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.weatherapp.model.WeatherResponse;
import com.example.weatherapp.repository.WeatherRepository;


public class WeatherViewModel extends ViewModel {

    private WeatherRepository repository;

    public WeatherViewModel(){
        repository = new WeatherRepository();
    }


    public LiveData<WeatherResponse> getWeather(String city){
        return repository.getWeather(city);
    }
}

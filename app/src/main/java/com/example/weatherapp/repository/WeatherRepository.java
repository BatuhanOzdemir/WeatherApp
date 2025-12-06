package com.example.weatherapp.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.weatherapp.model.WeatherResponse;
import com.example.weatherapp.network.ApiClient;
import com.example.weatherapp.network.ApiInterface;
import com.example.weatherapp.utils.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class WeatherRepository {

            private ApiInterface apiInterface;

            public WeatherRepository(){
                apiInterface = ApiClient.getClient().create(ApiInterface.class);
            }

            public LiveData<WeatherResponse> getWeather(String city){
                MutableLiveData<WeatherResponse> data = new MutableLiveData<>();
                apiInterface.getWeather(city,Constants.API_KEY,"metric").enqueue(new Callback<WeatherResponse>() {
                    @Override
                    public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                        if(response.isSuccessful()){
                            data.setValue(response.body());
                        }else{
                            data.setValue(null);
                        }
                    }

                    @Override
                    public void onFailure(Call<WeatherResponse> call, Throwable t) {

                        data.setValue(null);

                    }
                });

                return data;
            }

}

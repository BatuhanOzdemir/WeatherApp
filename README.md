# 🌤 WeatherApp — Android Weather Application (Java + MVVM)

WeatherApp is a simple Android application built using **Java**, **MVVM architecture**, **Retrofit**, and **LiveData**.  
The app fetches real-time weather data from the **OpenWeatherMap API** and displays temperature, humidity, and wind information for any city the user searches.

---

## 🚀 Features

- Search weather by city name  
- Fetch real-time data from OpenWeatherMap API  
- MVVM architecture with ViewModel + Repository layers  
- Retrofit for networking  
- Gson for JSON parsing  
- LiveData for reactive UI updates  
- Clean and simple UI  

---


## 📐 Project Structure

com.example.weatherapp
│
├── model
│ ├── WeatherResponse.java
│ ├── Main.java
│ ├── Weather.java
│ └── Wind.java
│
├── network
│ ├── ApiClient.java
│ └── ApiInterface.java
│
├── repository
│ └── WeatherRepository.java
│
├── viewmodel
│ └── WeatherViewModel.java
│
├── ui
│ └── MainActivity.java
│
└── utils
└── Constants.java

## 🔑 Setup & Usage

1. Create an account at **https://openweathermap.org**
2. Generate an API key  
3. Add your key to `Constants.java`:

```java
public static final String API_KEY = "YOUR_API_KEY";

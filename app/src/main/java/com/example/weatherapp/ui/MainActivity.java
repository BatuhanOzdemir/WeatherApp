package com.example.weatherapp.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.example.weatherapp.R;
import com.example.weatherapp.viewmodel.WeatherViewModel;

public class MainActivity extends AppCompatActivity {

    private WeatherViewModel viewmodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText city = findViewById(R.id.city);
        Button btn = findViewById(R.id.search);
        TextView answer = findViewById(R.id.answer);


        viewmodel = new ViewModelProvider(this).get(WeatherViewModel.class);


        btn.setOnClickListener(v ->{
            String ecity = city.getText().toString().trim();

            if(ecity.isEmpty()){
                answer.setText("Please Enter a City Name");
                return;
            }

            viewmodel.getWeather(ecity).observe(this,weather ->{
                if(weather != null){
                    answer.setText(
                            "City: " + weather.getName() +
                            "\nTemperature: " + weather.getMain().getTemp() + "°C" +
                            "\nHumidity: " + weather.getMain().getHumidity() + "%" +
                            "\nWind: " + weather.getWind().getSpeed() + " m/s"
                    );
                }else {
                    answer.setText("Error fetching data.");
                }
            });
        });


//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
       // });
    }
}
package com.example.gmd507;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class WeatherActivity extends AppCompatActivity {
    private EditText cityET;
    private Button button;
    private ProgressDialog progressDialog;
    private TextView weatherMain;
    private TextView latitude;
    private TextView longitude;
    private TextView temp;
    private TextView feelsLike;
    private TextView minimum;
    private TextView maximum;
    private TextView description;
    private TextView pressure;
    private TextView humidity;
    private TextView speed;
    private TextView degree;
    private TextView sunrise;
    private TextView sunset;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.activity_weather);

        // TODO : show a progress bar on the screen while making the request
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog = new ProgressDialog(WeatherActivity.this);
                progressDialog.show();
                progressDialog.setContentView(R.layout.activity_weather);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cityName = cityET.getText().toString();

                if (!cityName.isEmpty()) {
                    new NetworkTask(cityName, new NetworkCompletionHandler() {
                        @Override
                        public void onError(String error) {
                            // show the error response

                        }

                        @Override
                        public void onSuccess(WeatherInfo weatherInfo) {
                            // take values from weather info and put it on the view

                            // TODO : show all the values on the screen
                            weatherMain = findViewById(R.id.main);
                            weatherMain.setText((weatherInfo.getWeatherMain()));
                            latitude = findViewById(R.id.lat);
                            latitude.setText("LATITUDE: "+(weatherInfo.getLat()));
                            longitude = findViewById(R.id.lon);
                            longitude.setText("LONGITUDE: "+(weatherInfo.getLon()));
                            temp = findViewById(R.id.temp);
                            temp.setText("TEMPERATURE: " +(weatherInfo.getTemp()));
                            feelsLike = findViewById(R.id.feels_like);
                            feelsLike.setText("FEELS LIKE: " +(weatherInfo.getTempFeelLike()));
                            minimum = findViewById(R.id.temp_min);
                            minimum.setText("MINIMUM: " +(weatherInfo.getTempMin()));
                            maximum = findViewById(R.id.temp_max);
                            minimum.setText("MAXIMUM: " +(weatherInfo.getTempMax()));
                            description = findViewById(R.id.desc);
                            description.setText("DESCRIPTION: " +(weatherInfo.getWeatherDesc()));
                            pressure = findViewById(R.id.pressue);
                            pressure.setText("PRESSURE: " +(weatherInfo.getPressure()));
                            humidity = findViewById(R.id.humidity);
                            humidity.setText("HUMIDITY: " +(weatherInfo.getHumidity()));
                            speed = findViewById(R.id.speed);
                            speed.setText("WIND SPEED: " +(weatherInfo.getWindSpeed()));
                            degree = findViewById(R.id.degree);
                            degree.setText("DEGREE: " +(weatherInfo.getWindDeg()));
                            sunrise = findViewById(R.id.rise);
                            sunrise.setText("SUN RISE" +(weatherInfo.getSunrise()));
                            sunset = findViewById(R.id.set);
                            sunset.setText("SUN SET: " +(weatherInfo.getSunset()));
                        }
                    }).execute();
                }
            }
        });
    }
}

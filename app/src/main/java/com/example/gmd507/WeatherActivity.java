package com.example.gmd507;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class WeatherActivity extends AppCompatActivity {
    private EditText cityET;
    private Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_weather);

        // TODO : show a progress bar on the screen while making the request
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
                        }
                    }).execute();
                }
            }
        });
    }
}

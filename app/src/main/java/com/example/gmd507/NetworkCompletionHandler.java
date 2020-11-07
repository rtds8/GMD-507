package com.example.gmd507;

public interface NetworkCompletionHandler {
    void onError(String error);

    void onSuccess(WeatherInfo weatherInfo);
}

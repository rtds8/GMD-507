package com.example.gmd507;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkTask extends AsyncTask<Object, Object, Object> {
    private String cityName = "";
    private NetworkCompletionHandler completionHandler;

    private String errorResponse;
    private WeatherInfo infoObject;

    private static final String API_KEY = "ddaaececd2a74663e921e44def4e72c6";
    private static final String API = "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s";

    public NetworkTask(String cityName, NetworkCompletionHandler completionHandler) {
        this.cityName = cityName;
        this.completionHandler = completionHandler;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    private WeatherInfo parseResponse(String response) throws Exception {
        if (response != null && !response.isEmpty()) {
            JSONObject responseObject = new JSONObject(response);
            this.infoObject = new WeatherInfo();

            if (responseObject.has("coord")) {
                JSONObject coordObject = responseObject.getJSONObject("coord");

                double lon = coordObject.getDouble("lon");
                double lat = coordObject.getDouble("lat");

                this.infoObject.setLon(lon);
                this.infoObject.setLat(lat);
            }

            if (responseObject.has("weather")) {
                JSONArray weatherArr = responseObject.getJSONArray("weather");
                if (weatherArr.length() > 0) {
                    JSONObject weatherObject = weatherArr.getJSONObject(0);

                    infoObject.setWeatherMain(
                            weatherObject.getString("main")
                    );

                    infoObject.setWeatherDesc(
                            weatherObject.getString("description")
                    );
                }
            }

            // TODO: complete this parsing
        }

        return null;
    }

    private void networkCall() throws Exception {
        // call the API
        // get the response JSON String
        String url = String.format(API, this.cityName, API_KEY);
        System.out.println("Weather API URL: " + url);

        // create url object
        URL urlObject = new URL(url);
        // get connection object
        HttpURLConnection httpConnection = (HttpURLConnection) urlObject.openConnection();
        // set request method
        httpConnection.setRequestMethod("GET");
        // create connection
        httpConnection.connect();
        // get input stream from connection to get output from the server
        if (httpConnection.getResponseCode() == 200) {
            BufferedInputStream bis = new BufferedInputStream(httpConnection.getInputStream());
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int res = bis.read();
            // read response from the server
            while (res != -1) {
                baos.write((byte) res);
                res = bis.read();
            }

            this.infoObject = parseResponse(baos.toString());
        } else {
            BufferedInputStream bis = new BufferedInputStream(httpConnection.getErrorStream());
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int res = bis.read();
            // read response from the server
            while (res != -1) {
                baos.write((byte) res);
                res = bis.read();
            }
            // finally return response when reading from server is completed
            this.errorResponse = baos.toString();
        }
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        try {
            networkCall();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);

        if (infoObject != null) {
            completionHandler.onSuccess(this.infoObject);
        } else if (errorResponse != null) {
            completionHandler.onError(errorResponse);
        } else {
            completionHandler.onError("Unknown Error");
        }
    }
}

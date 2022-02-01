package com.example.lesson11;

import android.app.Application;

import com.example.lesson11.data.remote.FilmApi;
import com.example.lesson11.data.remote.FilmsApiService;
import com.example.lesson11.data.remote.RetrofitClient;

public class App extends Application {
    public static FilmApi api;
    public static FilmsApiService apiService;

    @Override
    public void onCreate() {
        super.onCreate();
        RetrofitClient client = new RetrofitClient();
        api = client.provideFilmApi();
        apiService = new FilmsApiService();
    }
}

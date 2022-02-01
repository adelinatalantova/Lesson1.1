package com.example.lesson11.data.remote;

import androidx.annotation.NonNull;

import com.example.lesson11.App;
import com.example.lesson11.data.models.Film;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmsApiService {

    public void getFilms(OnReadyCallback callback) {
        App.api.getFilms().enqueue(new Callback<List<Film>>() {
            @Override
            public void onResponse(@NonNull Call<List<Film>> call, @NonNull Response<List<Film>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.success(response.body());
                } else if (response.code() > 500) {
                    callback.onServerError();
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Film>> call, @NonNull Throwable t) {
                callback.failure(t.getLocalizedMessage());
            }
        });
    }

    public void getDetailFilms(String id, OnDetailFilmsCallback filmsCallback) {
        App.api.getDetailFilms(id).enqueue(new Callback<Film>() {
            @Override
            public void onResponse(@NonNull Call<Film> call, @NonNull Response<Film> response) {
                if (response.isSuccessful() && response.body() != null) {
                    filmsCallback.success(response.body());
                } else if (response.code() > 500) {
                    filmsCallback.serverError();
                }
            }

            @Override
            public void onFailure(@NonNull Call<Film> call, @NonNull Throwable t) {
                filmsCallback.failure(t.getLocalizedMessage());
            }
        });
    }
}

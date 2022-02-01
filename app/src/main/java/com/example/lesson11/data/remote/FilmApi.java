package com.example.lesson11.data.remote;

import com.example.lesson11.data.models.Film;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FilmApi {
    @GET("/films")
    Call<List<Film>> getFilms();

    @GET("/films/{id}")
    Call<Film> getDetailFilms(
            @Path("id") String position
    );
}

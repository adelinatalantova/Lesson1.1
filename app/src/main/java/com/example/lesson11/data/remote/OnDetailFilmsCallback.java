package com.example.lesson11.data.remote;


import com.example.lesson11.data.models.Film;

public interface OnDetailFilmsCallback {
    void success(Film film);

    void serverError();

    void failure(String msg);
}

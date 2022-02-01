package com.example.lesson11.data.remote;


import com.example.lesson11.data.models.Film;

import java.util.List;

public interface OnReadyCallback {
    void success(List<Film> films);

    void onServerError();

    void failure(String msg);
}

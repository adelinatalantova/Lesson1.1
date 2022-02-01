package com.example.lesson11.ui.films;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.lesson11.App;
import com.example.lesson11.R;
import com.example.lesson11.data.models.Film;
import com.example.lesson11.data.remote.OnReadyCallback;
import com.example.lesson11.databinding.FragmentFilmsBinding;

import java.util.List;

public class FilmsFragment extends Fragment {

    private FragmentFilmsBinding binding;
    private FilmsAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new FilmsAdapter();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFilmsBinding.inflate(inflater, container, false);
        adapter = new FilmsAdapter();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.recycler.setAdapter(adapter);
        sendInformation();
        getInformation();

        App.apiService.getFilms(new OnReadyCallback() {
            @Override
            public void success(List<Film> films) {
                Log.e("TAG", "success: ");
                adapter.setFilms(films);
            }

            @Override
            public void onServerError() {
                Log.e("TAG", "onServerError: ");

            }

            @Override
            public void failure(String msg) {
                Log.e("TAG", "failure: ");
            }
        });
    }

    private void getInformation() {
        App.apiService.getFilms(new OnReadyCallback() {
            @Override
            public void success(List<Film> films) {
                adapter.setFilms(films);
            }

            @Override
            public void onServerError() {

            }

            @Override
            public void failure(String msg) {

            }
        });
    }

    private void sendInformation() {
        adapter.setItemClick(position -> {
            Bundle bundle = new Bundle();
            Log.e("TAG", position);
            bundle.putString("id", position);
            Navigation.findNavController(requireView()).navigate(R.id.detailFilmsFragment, bundle);
        });
    }
}
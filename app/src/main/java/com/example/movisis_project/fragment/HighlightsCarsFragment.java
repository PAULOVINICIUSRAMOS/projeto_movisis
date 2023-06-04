package com.example.movisis_project.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movisis_project.adapter.UsedCarAdapter;
import com.example.movisis_project.databinding.FragmentAppointmentsBinding;
import com.example.movisis_project.model.Car;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class HighlightsCarsFragment extends Fragment {

    private FragmentAppointmentsBinding binding;
    private RecyclerView recyclerView;
    private UsedCarAdapter mAdapter;

    public static HighlightsCarsFragment newInstance() {
        return new HighlightsCarsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAppointmentsBinding.inflate(inflater, container, false);
        recyclerView = binding.recyclerViewUsed;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        List<Car> listCars = loadItemsFromJson();
        mAdapter = new UsedCarAdapter(listCars);
        recyclerView.setAdapter(mAdapter);

        return binding.getRoot();
    }

    private List<Car> loadItemsFromJson() {
        List<Car> items = new ArrayList<>();
        try {
            InputStream inputStream = requireContext().getAssets().open("used.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();

            String json = new String(buffer, StandardCharsets.UTF_8);
            Gson gson = new Gson();
            Type listType = new TypeToken<List<Car>>() {
            }.getType();
            items = gson.fromJson(json, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return items;
    }
}


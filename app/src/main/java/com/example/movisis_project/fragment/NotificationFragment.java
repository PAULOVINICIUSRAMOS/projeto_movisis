package com.example.movisis_project.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movisis_project.adapter.NotificationsAdapter;
import com.example.movisis_project.databinding.FragmentNotificationBinding;
import com.example.movisis_project.model.Notification;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class NotificationFragment extends Fragment {

    private FragmentNotificationBinding binding;
    private RecyclerView recyclerView;
    private NotificationsAdapter mAdapter;


    public static NotificationFragment newInstance() {
        return new NotificationFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentNotificationBinding.inflate(inflater, container, false);
        recyclerView = binding.recyclerViewNotification;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        List<Notification> listNotification = loadItemsFromJson();
        mAdapter = new NotificationsAdapter(listNotification);
        recyclerView.setAdapter(mAdapter);

        configButtonDelete();

        return binding.getRoot();
    }

    private List<Notification> loadItemsFromJson() {
        List<Notification> items = new ArrayList<>();
        try {
            InputStream inputStream = getContext().getAssets().open("notification.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();

            String json = new String(buffer, StandardCharsets.UTF_8);
            Gson gson = new Gson();
            Type listType = new TypeToken<List<Notification>>() {
            }.getType();
            items = gson.fromJson(json, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return items;
    }

    private void configButtonDelete() {
        binding.deleteAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteAll();
            }
        });
    }

    @SuppressLint("NotifyDataSetChanged")
    private void deleteAll() {
        List<Notification> emptyList = new ArrayList<>();
        String emptyJson = new Gson().toJson(emptyList);

        try {
            OutputStreamWriter writer = new OutputStreamWriter(requireContext().openFileOutput("notification.json", Context.MODE_PRIVATE));
            writer.write(emptyJson);
            writer.close();
            Toast.makeText(requireContext(), "Dados apagados com sucesso!", Toast.LENGTH_SHORT).show();

            mAdapter.setNotificationList(emptyList);
            mAdapter.notifyDataSetChanged();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(requireContext(), "Erro ao apagar os dados!", Toast.LENGTH_SHORT).show();
        }
    }
}



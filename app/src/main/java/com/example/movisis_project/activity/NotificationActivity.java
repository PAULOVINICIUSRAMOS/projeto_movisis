package com.example.movisis_project.activity;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.movisis_project.databinding.FragmentContainerBinding;
import com.example.movisis_project.fragment.NotificationFragment;

public class NotificationActivity extends AppCompatActivity {

    private FragmentContainerBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentContainerBinding.inflate(getLayoutInflater());
        configActionBar();
        setContentView(binding.getRoot());

        replaceFragment();
    }

    private void configActionBar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Central Notificações");
    }

    private void replaceFragment() {
        Fragment fragment = new NotificationFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(binding.fragmentContainer.getId(), fragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

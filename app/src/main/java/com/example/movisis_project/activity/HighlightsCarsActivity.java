package com.example.movisis_project.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.movisis_project.databinding.FragmentContainerBinding;
import com.example.movisis_project.fragment.HighlightsCarsFragment;

public class HighlightsCarsActivity extends AppCompatActivity {

    private FragmentContainerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentContainerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment();
    }

    private void replaceFragment() {
        Fragment fragment = new HighlightsCarsFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(binding.fragmentContainer.getId(), fragment);
        fragmentTransaction.commit();
    }
}

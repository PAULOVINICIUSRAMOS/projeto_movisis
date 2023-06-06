package com.example.movisis_project.activity;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.movisis_project.MainActivity;
import com.example.movisis_project.databinding.ActivityPersonalDataBinding;
import com.example.movisis_project.model.User;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

public class PersonalDataActivity extends AppCompatActivity {

    private ActivityPersonalDataBinding binding;
    private static User user = new User();
    View mRoot;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPersonalDataBinding.inflate(getLayoutInflater());
        mRoot = binding.getRoot();
        mContext = mRoot.getContext();
        loadUserFromJson();
        setContentView(mRoot);
        configActionBar();
        user = loadUserFromJson();
        setValuesInterface();
    }

    private void configActionBar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Dados Usuário");
    }

    private User loadUserFromJson() {
        User user = new User();
        try {
            AssetManager assetManager = getAssets();
            InputStream inputStream = assetManager.open("user.json");
            Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            Gson gson = new Gson();
            user = gson.fromJson(reader, User.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }

    void setValuesInterface() {
        binding.name.setText(user.getFullname());
        binding.socialName.setText(user.getSocialname());
        binding.document.setText(user.getDocument());
        binding.birthday.setText(user.getDatebirth().toString());
        binding.countryId.setText(user.getCountry());
        binding.stateId.setText(user.getState());
        binding.cityId.setText(user.getCity());
        binding.emailId.setText(user.getEmail());
        binding.telephoneId.setText(user.getMobilenumber());
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
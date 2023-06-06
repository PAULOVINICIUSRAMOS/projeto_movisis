package com.example.movisis_project;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.ViewPager2;

import com.example.movisis_project.activity.HighlightsCarsActivity;
import com.example.movisis_project.activity.NotificationActivity;
import com.example.movisis_project.activity.PersonalDataActivity;
import com.example.movisis_project.activity.ProfileActivity;
import com.example.movisis_project.activity.SupportActivity;
import com.example.movisis_project.databinding.ActivityMainBinding;
import com.example.movisis_project.util.ViewPagerHelper;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ActivityMainBinding binding;
    private ViewPager2 viewPagerCars;
    private final Handler handler = new Handler();
    private DrawerLayout drawerLayout;
    private ViewPagerHelper viewPagerHelper;

    View mRoot;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        mRoot = binding.getRoot();
        mContext = mRoot.getContext();
        setContentView(mRoot);
        configViewPager();
        configButtonUsedCars();

        drawerLayout = binding.drawerLayout;
        NavigationView navigationView = binding.navigationView;
        navigationView.setNavigationItemSelectedListener(this);
        configButtonMenu();
        configButtonProfile();
        configButtonNotification();
    }

    private void configButtonNotification() {
        binding.headerId.notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, NotificationActivity.class);
                startActivity(intent);
            }
        });
    }

    private void configButtonProfile() {
        binding.headerId.photoHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, PersonalDataActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START);
            } else {
                drawerLayout.openDrawer(GravityCompat.START);
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void configViewPager() {
        viewPagerCars = findViewById(R.id.viewPagerImageSlider);
        viewPagerHelper = new ViewPagerHelper(mContext, viewPagerCars);
        viewPagerHelper.generateViewPagerCars();
    }

    private void configButtonMenu() {
        binding.headerId.btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    private void configButtonUsedCars() {
        binding.fragmentDestaque.imgUsedCars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, HighlightsCarsActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.nav_menu, menu);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(sliderRunnable, 2000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(sliderRunnable);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private final Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            viewPagerCars.setCurrentItem(viewPagerCars.getCurrentItem() + 1);
        }
    };

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_support) {
            Intent intent = new Intent(mContext, SupportActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_profile) {
            Intent intent = new Intent(mContext, ProfileActivity.class);
            startActivity(intent);
        }
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}

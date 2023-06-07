package com.example.movisis_project.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.example.movisis_project.adapter.CarSliderAdapter;
import com.example.movisis_project.model.Car;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ViewPagerHelper {

    private ViewPager2 viewPagerCars;
    private Context mContext;

    public ViewPagerHelper(Context context, ViewPager2 viewPagerCars) {
        this.mContext = context;
        this.viewPagerCars = viewPagerCars;
    }

    public void generateViewPagerCars() {
        List<Car> slidersItemsCars = generateSliderItems();
        List<String> modelList = new ArrayList<>();
        List<Integer> imageResourceIds = new ArrayList<>();
        for (Car car : slidersItemsCars) {
            int imageResourceId = mContext.getResources().getIdentifier(car.getUrlImage(), "drawable", mContext.getPackageName());
            imageResourceIds.add(imageResourceId);
            modelList.add(car.getModel());
        }

        viewPagerCars.setAdapter(new CarSliderAdapter(imageResourceIds, modelList, viewPagerCars));
        viewPagerCars.setClipToPadding(true);
        viewPagerCars.setClipChildren(true);
        viewPagerCars.setOffscreenPageLimit(1);
        viewPagerCars.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(convertDpToPixels(30)));
        viewPagerCars.setPageTransformer(compositePageTransformer);
        int infiniteItemCount = imageResourceIds.size() * 1000;
        int startingItem = infiniteItemCount / 2;
        viewPagerCars.setCurrentItem(startingItem, false);
    }

    private List<Car> generateSliderItems() {
        Type notificationListType = new TypeToken<List<Car>>() {
        }.getType();
        JsonLoader<Car> jsonLoader = new JsonLoader<>("newcars.json", notificationListType, mContext);
        List<Car> sliderItems = jsonLoader.loadItemsFromJson();

        return sliderItems;
    }

    private int convertDpToPixels(int dp) {
        Resources resources = mContext.getResources();
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.getDisplayMetrics());
    }
}

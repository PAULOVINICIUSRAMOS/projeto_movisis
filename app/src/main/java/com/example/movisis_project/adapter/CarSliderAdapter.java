package com.example.movisis_project.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.movisis_project.R;

import java.util.List;

public class CarSliderAdapter extends RecyclerView.Adapter<CarSliderAdapter.ViewHolder> {

    private List<Integer> imageResources;
    private List<String> modelList;
    private ViewPager2 viewPager2;
    private static final int infiniteItemCount = 1000;

    public CarSliderAdapter(List<Integer> imageResources, List<String> modelList, ViewPager2 viewPager2) {
        this.imageResources = imageResources;
        this.modelList = modelList;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.slide_item_container, parent, false
                ));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int imagePosition = position % imageResources.size();
        int imageName = imageResources.get(imagePosition);
        String model = modelList.get(imagePosition);
        int imageResourceId = holder.itemView.getContext().getResources().getIdentifier(String.valueOf(imageName),
                "drawable", holder.itemView.getContext().getPackageName());
        holder.setImage(imageResourceId);
        holder.setModel(model);
    }

    @Override
    public int getItemCount() {
        return infiniteItemCount;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView;
        private final TextView textModel;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageSlide);
            textModel = itemView.findViewById(R.id.textModel);
        }

        void setImage(int imageResourceId) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setImageResource(imageResourceId);
        }

        void setModel(String model) {
            textModel.setText(model);
        }
    }
}

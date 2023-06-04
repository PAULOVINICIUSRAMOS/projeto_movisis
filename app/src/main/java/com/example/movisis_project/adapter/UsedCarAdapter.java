package com.example.movisis_project.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movisis_project.databinding.LayoutUsedItemsBinding;
import com.example.movisis_project.model.Car;

import java.util.List;

public class UsedCarAdapter extends RecyclerView.Adapter<UsedCarAdapter.ViewHolder> {

    private LayoutUsedItemsBinding binding;
    private List<Car> carList;

    public UsedCarAdapter(List<Car> cars) {
        this.carList = cars;
    }

    @NonNull
    @Override
    public UsedCarAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = LayoutUsedItemsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding.getRoot());
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull UsedCarAdapter.ViewHolder holder, int position) {
        Car car = carList.get(position);
        int imageResourceId = holder.itemView.getContext().getApplicationContext().getResources().getIdentifier(String.valueOf(car.getUrlImage()),
                "drawable", holder.itemView.getContext().getPackageName());
        binding.imageUsed.setImageResource(imageResourceId);
        binding.txtNameUsed.setText(car.getModel());
        binding.txtAnoUsed.setText("ANO: "+car.getYear());
        binding.txtPriceUsed.setText("R$ " + car.getPrice().toString());

    }

    @Override
    public int getItemCount() {
        return carList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private LayoutUsedItemsBinding binding;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = LayoutUsedItemsBinding.bind(itemView);
        }
    }
}


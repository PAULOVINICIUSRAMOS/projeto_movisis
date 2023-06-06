package com.example.movisis_project.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movisis_project.databinding.LayoutNotificationItemsBinding;
import com.example.movisis_project.model.Notification;

import java.util.List;

public class NotificationsAdapter extends RecyclerView.Adapter<NotificationsAdapter.ViewHolder> {

    private LayoutNotificationItemsBinding binding;
    private List<Notification> notificationList;

    public void setNotificationList(List<Notification> notifications) {
        this.notificationList = notifications;
    }

    public NotificationsAdapter(List<Notification> notification) {
        this.notificationList = notification;
    }

    @NonNull
    @Override
    public NotificationsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = LayoutNotificationItemsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding.getRoot());
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull NotificationsAdapter.ViewHolder holder, int position) {
        Notification notification = notificationList.get(position);
        binding.txtDate.setText(notification.getDate());
        binding.txtTittle.setText(notification.getTittle());
        binding.txtDescription.setText(notification.getDescription());
    }

    @Override
    public int getItemCount() {
        return notificationList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private LayoutNotificationItemsBinding binding;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = LayoutNotificationItemsBinding.bind(itemView);
        }
    }
}

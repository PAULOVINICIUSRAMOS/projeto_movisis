package com.example.movisis_project.util;

import android.content.Context;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class JsonLoader<T> {

    private final String fileName;
    private final Type objectType;
    Context mContext;

    public JsonLoader(String fileName, Type objectType, Context context) {
        this.fileName = fileName;
        this.objectType = objectType;
        this.mContext = context;
    }

    public List<T> loadItemsFromJson() {
        List<T> items = new ArrayList<>();
        try {
            InputStream inputStream = mContext.getAssets().open(fileName);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();

            String json = new String(buffer, StandardCharsets.UTF_8);
            Gson gson = new Gson();
            items = gson.fromJson(json, objectType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return items;
    }
}

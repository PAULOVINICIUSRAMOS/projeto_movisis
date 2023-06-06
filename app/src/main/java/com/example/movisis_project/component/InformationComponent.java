package com.example.movisis_project.component;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.example.movisis_project.R;
import com.example.movisis_project.databinding.WidgetInformationComponentBinding;

public class InformationComponent extends LinearLayout {

    private WidgetInformationComponentBinding binding;

    public InformationComponent(Context context) {
        this(context, null);
    }

    public InformationComponent(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public InformationComponent(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        binding = WidgetInformationComponentBinding.inflate(LayoutInflater.from(context), this, true);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.InformationComponent);
        String title = a.getString(R.styleable.InformationComponent_information_title);
        String text = a.getString(R.styleable.InformationComponent_information_text);
        a.recycle();
        Typeface customTypeface = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Regular.ttf");
        binding.informationComponentTitle.setTypeface(customTypeface);
        binding.informationComponentTitle.setText(title);
        binding.informationComponentText.setText(text);
    }

    public void setText(String text) {
        binding.informationComponentText.setText(text);
    }

    public void setTitle(String title) {
        binding.informationComponentTitle.setText(title);
    }
}

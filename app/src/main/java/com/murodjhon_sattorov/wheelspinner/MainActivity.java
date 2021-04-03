package com.murodjhon_sattorov.wheelspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageView ivArrow, ivSelectedTattoo;
    private Button btnSpin;
    private WheelSpinner wheelSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivArrow = findViewById(R.id.ivArrow);
        wheelSpinner = findViewById(R.id.wheelSpinner);
        ivSelectedTattoo = findViewById(R.id.ivSelectedTattoo);
        btnSpin = findViewById(R.id.btnSpin);


        List<Integer> bitmaps = new ArrayList<>();
        bitmaps.add(R.drawable.potato);
        bitmaps.add(R.drawable.cabbage);
        bitmaps.add(R.drawable.onion);
        bitmaps.add(R.drawable.carrot);
        bitmaps.add(R.drawable.tomato);
        bitmaps.add(R.drawable.cucumber);
        wheelSpinner.setArrowPointer(ivArrow);
        wheelSpinner.setBitmapsId(bitmaps);
        wheelSpinner.setOnItemSelectListener(bitmap -> {
            ivSelectedTattoo.setImageBitmap(bitmap);
            ivSelectedTattoo.setVisibility(View.VISIBLE);
        });

        btnSpin.setOnClickListener(v -> {
            ivSelectedTattoo.setVisibility(View.GONE);
            wheelSpinner.rotateWheel();
        });

    }
}
package com.example.imagesdisplay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.GridView;

public class MainActivity extends AppCompatActivity {
    GridView gridViewImages;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridViewImages = findViewById(R.id.gridViewImages);

        // Array of image resource IDs
        int[] imageIds = {
            R.raw.image1,	R.raw.image2, R.raw.image3, // Add your images More images...
        };

        // Set the adapter to the GridView
        gridViewImages.setAdapter(new ImageAdapter(this, imageIds));

    }
}
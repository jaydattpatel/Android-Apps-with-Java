package com.example.imagesdisplay;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;


public class ImageAdapter extends BaseAdapter {
    private Context context;
    private int[] imageIds; // Array of image resource IDs
    // Constructor
    public ImageAdapter(Context context, int[] imageIds) {
        this.context = context;
        this.imageIds = imageIds;
    }

    @Override
    public int getCount() {
        return imageIds.length;
    }


    @Override
    public Object getItem(int position) {
        return imageIds[position];
    }


    @Override
    public long getItemId(int position) {
        return 0; // Not implemented
    }

    @Override
    public	View	getView(int	position,	View	convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // Inflate the layout for each grid item
            imageView =	(ImageView) LayoutInflater.from(context).inflate(R.layout.grid_item, parent, false);
        } else {
            imageView = (ImageView) convertView;
        }

        // Set the image for the current position
        imageView.setImageResource(imageIds[position]);
        return imageView;
    }

}

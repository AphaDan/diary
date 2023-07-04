package com.example.myactivity.view;

import android.widget.ImageView;

public interface IImageLoader {
    void loadImage(String imagePath, ImageView imageView, int imageHeight);
}

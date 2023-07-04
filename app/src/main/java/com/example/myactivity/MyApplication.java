package com.example.myactivity;

import android.app.Application;

import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;

import com.example.myactivity.comm.TransformationScale;
import com.example.myactivity.view.IImageLoader;
import com.example.myactivity.view.XRichText;


public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();


        XRichText.getInstance().setImageLoader(new IImageLoader() {
            @Override
            public void loadImage(final String imagePath, final ImageView imageView, final int imageHeight) {
                Log.e("---", "imageHeight: "+imageHeight);

                    if (imageHeight > 0) {//固定高度
                        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                                FrameLayout.LayoutParams.MATCH_PARENT, imageHeight);//固定图片高度，记得设置裁剪剧中
                        lp.bottomMargin = 10;//图片的底边距
                        imageView.setLayoutParams(lp);

                        Glide.with(getApplicationContext()).asBitmap().load(imagePath).centerCrop()
                                .into(imageView);
                    } else {//自适应高度
                        Glide.with(getApplicationContext()).asBitmap().load(imagePath)
                                .into(new TransformationScale(imageView));
                    }
//                }
            }
        });
    }

}

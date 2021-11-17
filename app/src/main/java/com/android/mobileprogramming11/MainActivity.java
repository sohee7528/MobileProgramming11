package com.android.mobileprogramming11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import java.nio.channels.GatheringByteChannel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("갤러리 영화 포스터");

        Gallery gallery= findViewById(R.id.gallery1);

        MyGalleryAdapter galleryAdapter = new MyGalleryAdapter(this);
        gallery.setAdapter(galleryAdapter);
    }


    public class MyGalleryAdapter extends BaseAdapter{

        Context context;

        Integer[] posterID = { R.drawable.mov11, R.drawable.mov12,R.drawable.mov13,R.drawable.mov14,
                R.drawable.mov15,R.drawable.mov16,R.drawable.mov17,R.drawable.mov18,R.drawable.mov19,
                R.drawable.mov20};

        public MyGalleryAdapter(Context context){
            this.context=context;
        }

        @Override
        public int getCount() {
            return posterID.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new Gallery.LayoutParams(200,300));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(5,5,5,5);
            imageView.setImageResource(posterID[i]);

            imageView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    ImageView ivPoster = findViewById(R.id.ivPoster);
                    ivPoster.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    ivPoster.setImageResource(posterID[i]);
                    return false;
                }
            });
            return imageView;
        }
    }
}
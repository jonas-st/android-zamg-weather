package com.example.jonas.wetter;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;



public class WetterkartenFragment extends Fragment {
    private ImageView imageView;
    private Button prevButton, nextButton;
    private ArrayList<String> urls;
    private ArrayList<String> dates;
    private int current;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_wetterkarten, container, false);

        loadURLS();

        prevButton = (Button) fragmentView.findViewById(R.id.button_prev_wetterkarten);
        nextButton = (Button) fragmentView.findViewById(R.id.button_next_wetterkarten);
        imageView = (ImageView) fragmentView.findViewById(R.id.image_view_wetterkarten);
        current = 20;
        Glide.with(this).load(urls.get(current)).into(imageView);


        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPrevImage();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNextImage();
            }
        });
        return fragmentView;
    }

    private void setNextImage(){
        if(current != 20){
            current ++;
            Glide.with(this).load(urls.get(current)).into(imageView);
        }

    }
    private void setPrevImage(){
        if(current != 0){
            current --;
            Glide.with(this).load(urls.get(current)).into(imageView);
        }
    }


    private void loadURLS() {
        this.urls = URLProvider.getInstance().getWetterkartenUrls();
    }
}

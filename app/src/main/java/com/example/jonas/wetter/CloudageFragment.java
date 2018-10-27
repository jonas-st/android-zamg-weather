package com.example.jonas.wetter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class CloudageFragment extends Fragment {

    private ImageView imageView;
    private Button prevButton, nextButton;
    private TextView dateTextView;
    private ArrayList<String> urls;
    private ArrayList<String> dates;
    private int current;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_cloudage, container, false);

        loadURLS();

        prevButton = (Button) fragmentView.findViewById(R.id.button_prev_cloudage);
        nextButton = (Button) fragmentView.findViewById(R.id.button_next_cloudage);
        imageView = (ImageView) fragmentView.findViewById(R.id.image_view_cloudage);
        dateTextView = (TextView) fragmentView.findViewById(R.id.text_view_cloudage_date);
        current = 0;
        Glide.with(this).load(urls.get(current)).into(imageView);
        dateTextView.setText(dates.get(current));




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
        if(current != 68){
            current ++;
            Glide.with(this).load(urls.get(current)).into(imageView);
            dateTextView.setText(dates.get(current));
        }

    }
    private void setPrevImage(){
        if(current != 0){
            current --;
            Glide.with(this).load(urls.get(current)).into(imageView);
            dateTextView.setText(dates.get(current));
        }
    }

    private void loadURLS() {
        this.urls = URLProvider.getInstance().getCloudUrls();
        this.dates = URLProvider.getInstance().getCloudDateStrings();
    }
}

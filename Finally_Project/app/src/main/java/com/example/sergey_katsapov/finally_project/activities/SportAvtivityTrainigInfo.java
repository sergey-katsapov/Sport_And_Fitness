package com.example.sergey_katsapov.finally_project.activities;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.sergey_katsapov.finally_project.R;



public class SportAvtivityTrainigInfo  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport_training_info);

        getSupportActionBar().hide();


        //Rrecieve data
        String name = getIntent().getExtras().getString("name");
        String description = getIntent().getExtras().getString("description");
        String image_url = getIntent().getExtras().getString("thumbnail");

        //ini views
        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar_id);
        collapsingToolbarLayout.setTitleEnabled(true);


        TextView tv_name = findViewById(R.id.aa_name);
        TextView tv_description = findViewById(R.id.aa_description);
        ImageView img = findViewById(R.id.aa_thumbnail);

        //setting_values to each view
        tv_name.setText(name);
        tv_description.setText(description);

        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);


        //set image view Glide
        Glide.with(this).load(image_url).apply(requestOptions).into(img);
    }

}

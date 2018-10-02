package com.example.sergey_katsapov.finally_project.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.BundleCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import com.example.sergey_katsapov.finally_project.R;


public class Home extends AppCompatActivity implements View.OnClickListener {

    private CardView trainingInfo, trainig, foodInfo, food, aboutMe;

    @Override
    protected  void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        trainingInfo = (CardView) findViewById(R.id.training_info);
        trainig = (CardView) findViewById(R.id.training);
        foodInfo = (CardView) findViewById(R.id.food_info);
        food = (CardView) findViewById(R.id.food);
        aboutMe  = (CardView) findViewById(R.id.info_about_me);



        trainingInfo.setOnClickListener(this);
        trainig.setOnClickListener(this);
        foodInfo.setOnClickListener(this);
        food.setOnClickListener(this);
        aboutMe.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {
            case R.id.training_info : i =  new Intent (this,TrainingInfoActivity.class); startActivity(i); break;
            case R.id.training : i =  new Intent (this, TrainingActivity.class); startActivity(i); break;
            case R.id.food_info : i =  new Intent (this, FoodInfoActivity.class); startActivity(i); break;
            case R.id.food : i =  new Intent (this, Activity.class); startActivity(i); break;
            case R.id.info_about_me : i =  new Intent (this,  Profile_UI.class); startActivity(i); break;

            default:break;
        }

    }
}
